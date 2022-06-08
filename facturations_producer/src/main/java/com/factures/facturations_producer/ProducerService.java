package com.factures.facturations_producer;

import lombok.Data;
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
        customers.add(new Customer("c1"));
        customers.add(new Customer("c2"));
        customers.add(new Customer("c3"));

        products.add(new Product("p1","product1",10));
        products.add(new Product("p2","product2",20));
        products.add(new Product("p3","product3",30));
        products.add(new Product("p4","product4",40));
        products.add(new Product("p5","product5",50));
    }

    private <T> T randomElement(List<T> list){
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    public Bill randomBill(){
        List<ProductItem> items = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(10); i++) {
            Product p = randomElement(products);
            items.add(new ProductItem("p1",p.getId(),10L,p.getPrice()));
        }
        Bill bill = new Bill("b1",randomElement(customers).getId(),items);
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
