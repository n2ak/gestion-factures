package com.factures.batchprecessing.config;

import com.factures.batchprecessing.entities.Bill;
import com.factures.batchprecessing.entities.ProductItem;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired private JobBuilderFactory jobBuilderFactory;
    @Autowired private StepBuilderFactory stepBuilderFactory;
    @Autowired private ItemReader<Bill> itemReader;
    @Autowired private ItemWriter<Bill> itemWriter;
    @Autowired private ItemProcessor<Bill,Bill> itemProcessor;

    @Bean
    public Job billJob(){
        Step step = stepBuilderFactory.get("bill-step-1")
                .<Bill,Bill>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
        return jobBuilderFactory.get("bill-job")
                .start(step)
                .build();
    }

    @Bean
    public FlatFileItemReader<Bill> flatFileItemReader(@Value("${file}") Resource file){
        FlatFileItemReader<Bill> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setName("csv_reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setResource(file);
        flatFileItemReader.setLineMapper(linemapper());
        return flatFileItemReader;
    }
    @Bean
    public LineMapper<Bill> linemapper(){
        return (line,linenumber)->{
            List<String> champs = Arrays.asList(line.split(",",3));
            String last = champs.get(champs.size()-1);
            List<ProductItem> productItems = last.length() <= 4 ? new ArrayList<>():
                    Arrays.asList(last.substring(2, last.length() - 2)
                            .split("},"))
                            .stream()
                            .map(s->s.replace("}",""))
                            .map(s->s.replace("{",""))
                            .map((s)->{
                                List<String> c = Arrays.asList(s.split(","));
                                return new ProductItem(
                                        Long.parseLong(c.get(0)),
                                        Long.parseLong(c.get(1)),
                                        Long.parseLong(c.get(2)),
                                        Double.parseDouble(c.get(3)));
                            })
                            .collect(Collectors.toList());
            //TODO
            Bill bill = new Bill(
                    Long.parseLong(champs.get(0)),
                    Long.parseLong(champs.get(1)),
                    productItems
            );
            return bill;
        };
    }
}
