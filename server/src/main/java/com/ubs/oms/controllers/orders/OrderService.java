package com.ubs.oms.controllers.orders;

import java.util.Collection;

public interface OrderService {
    public Collection<Order> getOrders(String username);

    public void sendOrder(String username, Order order);
}
