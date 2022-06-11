package com.factures.facturations_producer.services;

import com.factures.facturations_producer.entities.Bill;
import com.factures.facturations_producer.entities.Customer;
import com.factures.facturations_producer.entities.Product;
import com.factures.facturations_producer.entities.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Service
public class ProducerService {
    @Autowired
    private StreamBridge bridge;
    private List<Customer> customers;
    private List<Product> products;


    public ProducerService(StreamBridge bridge){
        this.bridge = bridge;
        customers = new ArrayList<>();
        products = new ArrayList<>();
        for(int i=1;i<=3;i++){
            customers.add(new Customer((long) i));
        }
        for(int i=1;i<=5;i++){
            products.add(new Product((long) i,null,10));
        }
    }

    private <T> T randomElement(List<T> list){
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    private int i;
    public Bill randomBill(){
        List<ProductItem> items = new ArrayList<>();
        for (int j = 1; j < 1+new Random().nextInt(10); j++) {
            long quantity = new Random().nextInt(30)+1;
            Product p = randomElement(products);
            items.add(new ProductItem((long) -1,p.getId(),quantity,p.getPrice()*quantity));
        }
        Bill bill = new Bill((long) -1,randomElement(customers).getId(),items);
        return bill;
    }
    @Bean
    public Supplier<Bill> billSupplier(){
        System.out.println("-Starting sending bills");
        return () -> {
            System.out.println("--Bill sent");
            return randomBill();
        };
    }
}
