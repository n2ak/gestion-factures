package com.factures.facturations_real_time_analytics.services;

import com.factures.facturations_real_time_analytics.entities.Bill;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.function.Function;

@Service
public class AnalyticsService {


    @Bean
    public Function<KStream<String,Bill>,KStream<String,Long>> totalFacturations(){
        return (input) -> input
                    .map((k, v) -> new KeyValue<>("-", 0L))
                    .groupBy((k, v) -> k, Grouped.with(Serdes.String(), Serdes.Long()))
                    //.windowedBy(TimeWindows.of(Duration.ofSeconds(1000)))
                    .count()
                    .toStream()
                    .map((k, v) -> new KeyValue<>("total des factures : ", v));

    }

    @Bean
    public Function<KStream<String,Bill>,KStream<String, Double>> totalFacturationsForClients(){
        return (in) -> in
                .map((k,v)-> {
                    Double price = v.getProductItems()
                            .stream()
                            .map(pi->pi.getPrice())
                            .reduce((a,b)->a+b).orElse(0d);
                    return new KeyValue<>(""+v.getCustomerId(),price);
                })
                .groupBy((k,v) -> k, Grouped.with(Serdes.String(),Serdes.Double()))
                //.windowedBy(TimeWindows.of(Duration.ofSeconds(5)))
                .reduce((c1,c2)->c1+c2)
                .toStream()
                .map((k,v) ->new KeyValue<>("montant total à payer pour le client '" + k + "' est:",v));
    }
}
