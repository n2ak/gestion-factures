package com.factures.batchprecessing.jobitems;

import com.factures.batchprecessing.entities.Bill;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IWImpl implements ItemWriter<Bill> {
    @Override
    public void write(List<? extends Bill> bills) throws Exception {
        System.out.println("Réduction");
        System.out.println("-------------------");
        bills.forEach((b)->{
            System.out.println(b);
        });
        System.out.println("-------------------");
    }
}
