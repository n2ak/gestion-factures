package com.factures.Billing.services;

import com.factures.Billing.dto.BillingRequest;
import com.factures.Billing.dto.BillingResponse;
import com.factures.Billing.entities.Bill;
import com.factures.Billing.entities.Customer;
import com.factures.Billing.entities.Product;
import com.factures.Billing.feign.CustomerService;
import com.factures.Billing.feign.InventoryService;
import com.factures.Billing.mappers.BillMapper;
import com.factures.Billing.repos.BillingRepo;
import com.factures.Billing.repos.ProductItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan("com.factures.Billing.mappers")
public class BillingServiceImpl implements BillingService {

    @Autowired private ProductItemRepo productItemsRepo;
    @Autowired private BillingRepo repo;
    @Autowired private BillMapper mapper;
    @Autowired private CustomerService customerService;
    @Autowired private InventoryService inventoryService;
    /*
    public BillingServiceImpl(ProductItemRepo productItemRepo, BillingRepo repo, BillMapper mapper, CustomerService customerService,InventoryService inventoryService) {
        this.productItemsRepo = productItemRepo;
        this.repo = repo;
        this.mapper = mapper;
        this.customerService = customerService;
        this.inventoryService = inventoryService;
    }*/

    @Override
    public BillingResponse save(BillingRequest req) {
        Bill bill = mapper.billRequestToBill(req);
        Bill savedBill = repo.save(bill);
        bill.getProductItems().forEach(pi-> {
            pi.setBillId(savedBill.getId());
            productItemsRepo.save(pi);
        });
        return mapper.billToBillResponse(savedBill);
    }

    @Override
    public BillingResponse getById(BillingRequest req) {
        return mapper.billToBillResponse(attachItems(repo.findById(req.getId()).get()));
    }

    @Override
    public List<BillingResponse> getAllByCustomerId(BillingRequest req) {
        Bill bill = mapper.billRequestToBill(req);
        Customer c = customerService.getCustomerById(bill.getCustomerId());
        if (c == null){
            //TODO
            return null;
        }
        return repo.findAllByCustomerId(c.getId())
                .stream()
                .map(this::attachItems)
                .map(b->mapper.billToBillResponse(b))
                .collect(Collectors.toList());
    }
    private Bill attachItems(Bill bill){
        bill.setProductItems(productItemsRepo.findAllByBillId(bill.getId()));
        bill.getProductItems().forEach(p->{
            Product product = null;
            try{
                product = inventoryService.getProductById(p.getProductId());
            }catch(Exception e){}
            p.setProduct(product);
        });
        return bill;
    }
    @Override
    public List<BillingResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(this::attachItems)
                .map(b->mapper.billToBillResponse(b))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(BillingRequest req) {
        repo.deleteById(req.getId());
    }

}
