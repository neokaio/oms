package com.ubs.oms.controllers.orders;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.Arrays.asList;

@Service
public class NoopOrderService implements OrderService {
    private final ConcurrentMap<String, Collection<Order>> orders = new ConcurrentHashMap<>();

    public NoopOrderService() {
        orders.put("user", new LinkedList<>(asList(createSampleOrder())));
    }

    private Order createSampleOrder() {
        Order order = new Order();
        order.setSymbol("AAPL");
        order.setDate(LocalDate.of(2017, 03, 01).atStartOfDay());
        order.setQuantity(BigDecimal.valueOf(10));
        order.setPrice(BigDecimal.valueOf(153.14));
        return order;
    }

    @Override
    public Collection<Order> getOrders(String username) {
        Collection<Order> orders = this.orders.get(username);
        synchronized (orders) {
            return new ArrayList<>(orders);
        }
    }

    @Override
    public void sendOrder(String username, Order order) {
        Collection<Order> orders = this.orders.computeIfAbsent(username, ignore -> new LinkedList<>());
        synchronized (orders) {
            orders.add(order);
        }
    }
}
