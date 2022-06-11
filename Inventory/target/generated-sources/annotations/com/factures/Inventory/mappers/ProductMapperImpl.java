package com.factures.Inventory.mappers;

import com.factures.Inventory.dto.ProductRequest;
import com.factures.Inventory.dto.ProductResponse;
import com.factures.Inventory.entities.Product;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-11T02:07:25+0000",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productRequestToProduct(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( request.getId() );
        product.setName( request.getName() );
        product.setPrice( request.getPrice() );

        return product;
    }

    @Override
    public ProductResponse productToProductResponse(Product customer) {
        if ( customer == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( customer.getId() );
        productResponse.setName( customer.getName() );
        productResponse.setPrice( customer.getPrice() );

        return productResponse;
    }
}
