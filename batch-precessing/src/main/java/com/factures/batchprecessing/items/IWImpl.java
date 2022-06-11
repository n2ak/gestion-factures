package com.factures.batchprecessing.items;

import com.factures.batchprecessing.entities.Bill;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IWImpl implements ItemWriter<Bill> {
    @Override
    public void write(List<? extends Bill> bills) throws Exception {
        System.out.println("Réduction");
        bills.forEach((b)->{
            System.out.println("*********");
            System.out.println(b);
            System.out.println("*********");
        });
    }
}
