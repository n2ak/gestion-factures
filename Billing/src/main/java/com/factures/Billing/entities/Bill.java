package com.factures.Billing.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long customerId;
    @Transient
    private Customer customer;
    @Transient @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
}
@Projection(name="ff",types=Bill.class)
interface CProjection{
    public Long getId();
    public String getCustomerId();
    public Customer getCustomer();
    public List<ProductItem> getProductItems();
}