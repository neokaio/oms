package com.ubs.oms.controllers.products;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private final String symbol;
    private final AssetType assetType;
    private final BigDecimal price;
}
