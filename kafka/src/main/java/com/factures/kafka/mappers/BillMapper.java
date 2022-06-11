package com.factures.kafka.mappers;

import com.factures.kafka.dto.BillingRequest;
import com.factures.kafka.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {
    BillingRequest billToBillRequest(Bill request);
}
