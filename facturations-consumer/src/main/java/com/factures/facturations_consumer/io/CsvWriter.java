package com.factures.facturations_consumer.io;

import com.factures.facturations_consumer.entities.Bill;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvWriter {
    private File file;
    FileWriter writer;
    public  CsvWriter(String filename){
        file = new File(filename);
        try {
            boolean exist=true;
            if(!file.exists()){
                //file.getParentFile().mkdirs();
                //file.createNewFile();
                exist = false;
            }
            writer = new FileWriter(file,true);
            if(!exist){
                writer.write("id,customerId,productItems\n");
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String billToCSV(Bill bill){
        String items = "\"[" + bill.getProductItems()
                .stream()
                .map(pi-> "" + pi.getId() + "," + pi.getProductId()+","+pi.getQuantity()+","+pi.getPrice())
                .map(s-> "{"+s+"}")
                .collect(Collectors.joining(",")) + "]\"";
        List<String> list = Arrays.asList(
                bill.getId().toString(),
                bill.getCustomerId().toString(),
                items
        );
        return String.join(",",list);
    }
    public void write(Bill bill)  {
        String text = billToCSV(bill);
        System.out.println("-------------");
        System.out.println(text);
        try {
            writer.write(text);
            writer.write("\n");
            writer.flush();
        }catch(IOException e){
        }
    }
}
