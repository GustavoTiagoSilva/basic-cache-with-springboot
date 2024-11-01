package com.demo.basic_cache_with_springboot.services;

import com.demo.basic_cache_with_springboot.dto.ProductDto;
import com.demo.basic_cache_with_springboot.exceptions.ResourceNotFoundException;
import com.demo.basic_cache_with_springboot.repositories.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    @Cacheable("allProducts")
    public List<ProductDto> findAll() throws Exception {
        var allProducts = productRepository
                .findAll()
                .stream()
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescription()))
                .toList();
        Thread.sleep(10000);
        return allProducts;
    }

    @Transactional(readOnly = true)
    public ProductDto findById(UUID id) {
        var product = productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " not found"));
        return new ProductDto(product.getId(), product.getName(), product.getDescription());
    }
}
