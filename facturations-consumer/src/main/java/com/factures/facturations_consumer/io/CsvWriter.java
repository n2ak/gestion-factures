package com.factures.facturations_consumer.io;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWriter {
    private File file;
    PrintWriter writer;
    public  CsvWriter(String filename){
        file = new File(filename);
        try {
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            writer = new PrintWriter(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void write(String text){
        writer.println(text);
    }
}
