package com.demo.basic_cache_with_springboot.controllers;

import com.demo.basic_cache_with_springboot.dto.ProductDto;
import com.demo.basic_cache_with_springboot.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> findAll() throws Exception {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto findById(@PathVariable UUID id) {
        return productService.findById(id);
    }
}
