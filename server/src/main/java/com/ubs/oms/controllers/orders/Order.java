package com.ubs.oms.controllers.orders;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private String symbol;
    private LocalDateTime date;
    private BigDecimal quantity;
    private BigDecimal price;
}
