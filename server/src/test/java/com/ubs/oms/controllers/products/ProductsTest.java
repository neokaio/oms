package com.ubs.oms.controllers.products;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.Model;

import java.util.Collection;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductsTest {
    @Rule public MockitoRule mr = MockitoJUnit.rule();

    @Mock private ProductService productService;
    @Mock private Model model;
    @Mock private Collection<Product> productList;

    private Products products;

    @Before
    public void setUp() {
        products = new Products(productService);
    }

    @Test
    public void when_products_requested_then_product_list_set_into_model_from_product_service() {
        when(productService.getProducts()).thenReturn(productList);

        products.showProducts(model);

        verify(model).addAttribute("products", productList);
    }
}
