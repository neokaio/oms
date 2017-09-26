package com.ubs.oms.controllers.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Products {
    private final ProductService productService;

    @Autowired
    public Products(ProductService productProvider) {
        this.productService = productProvider;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }
}
