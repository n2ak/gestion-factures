package com.factures.batchprecessing.items;

import com.factures.batchprecessing.entities.Bill;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class IPImpl implements  ItemProcessor<Bill,Bill>{

    @Override
    public Bill process(Bill bill) throws Exception {
        bill.getProductItems()
                .forEach(p-> {
                    p.setPrice(p.getPrice() * 0.7);
                });
        return bill;
    }
}
