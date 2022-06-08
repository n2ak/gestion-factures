package com.factures.facturations_consumer.mappers;

import com.factures.facturations_consumer.dto.BillingRequest;
import com.factures.facturations_consumer.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {
    BillingRequest billToBillRequest(Bill request);
}
