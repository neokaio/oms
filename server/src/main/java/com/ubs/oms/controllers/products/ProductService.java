package com.ubs.oms.controllers.products;

import java.util.Collection;
import java.util.Optional;

public interface ProductService {
    public Collection<Product> getProducts();

    public default Optional<Product> getBySymbol(String symbol) {
        return getProducts().stream()
                .filter(product -> product.getSymbol().equals(symbol))
                .findFirst();
    }
}
