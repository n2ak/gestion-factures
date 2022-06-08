package com.factures.Billing.services;

import com.factures.Billing.dto.BillingRequest;
import com.factures.Billing.dto.BillingResponse;
import com.factures.Billing.entities.Bill;
import com.factures.Billing.entities.Customer;
import com.factures.Billing.feign.CustomerService;
import com.factures.Billing.feign.InventoryService;
import com.factures.Billing.mappers.BillMapper;
import com.factures.Billing.repos.BillingRepo;
import com.factures.Billing.repos.ProductItemRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BillingServiceImpl implements BillingService {

    private ProductItemRepo productItemsRepo;
    private BillingRepo repo;
    private BillMapper mapper;
    private CustomerService customerService;
    private InventoryService inventoryService;

    public BillingServiceImpl(ProductItemRepo productItemRepo, BillingRepo repo, BillMapper mapper, CustomerService customerService,InventoryService inventoryService) {
        this.productItemsRepo = productItemRepo;
        this.repo = repo;
        this.mapper = mapper;
        this.customerService = customerService;
        this.inventoryService = inventoryService;
    }

    @Override
    public BillingResponse save(BillingRequest req) {
        req.setId(UUID.randomUUID().toString());
        Bill bill = repo.save(mapper.billRequestToBill(req));
        bill.getProductItems().forEach(pi->productItemsRepo.save(pi));
        return mapper.billToBillResponse(bill);
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
        bill.getProductItems().forEach(p->p.setProduct(inventoryService.getProductById(p.getProductId())));
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
