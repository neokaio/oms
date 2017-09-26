package com.ubs.oms.controllers.products;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.asList;

@Service
public class HardcodedProductService implements ProductService {
    @Override
    public Collection<Product> getProducts() {
        return new ArrayList<>(asList(
                new Product("AAPL", AssetType.EQUITY, new BigDecimal("153.14")),
                new Product("AAPL171216C00160000", AssetType.OPTION, new BigDecimal("2.15"))
        ));
    }
}
