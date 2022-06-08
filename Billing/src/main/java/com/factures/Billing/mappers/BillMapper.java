package com.factures.Billing.mappers;

import com.factures.Billing.dto.BillingRequest;
import com.factures.Billing.dto.BillingResponse;
import com.factures.Billing.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {
    Bill billRequestToBill(BillingRequest request);
    BillingResponse billToBillResponse(Bill customer);
}
