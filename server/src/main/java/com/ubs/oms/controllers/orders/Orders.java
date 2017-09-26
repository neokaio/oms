package com.ubs.oms.controllers.orders;

import com.ubs.oms.controllers.products.Product;
import com.ubs.oms.controllers.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class Orders {
    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public Orders(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String showOrders(Model model, Principal principal) {
        model.addAttribute("orders", orderService.getOrders(principal.getName()));
        return "orders";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrderTicket(Model model, @RequestParam(name = "symbol") String symbol) {
        // FIXME: handle non-existent product gracefully
        Product product = productService.getBySymbol(symbol).get();
        model.addAttribute("product", product);
        Order order = new Order();
        order.setSymbol(product.getSymbol());
        model.addAttribute("order", order);
        return "order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public void placeOrder(@ModelAttribute Order order, Principal principal, HttpServletResponse response) throws IOException {
        order.setDate(LocalDateTime.now());
        orderService.sendOrder(principal.getName(), order);
        response.sendRedirect("/orders");
    }
}
