package com.factures.Billing.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill {
    @Id
    private String id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String customerId;
    @Transient
    private Customer customer;
    @Transient @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
}