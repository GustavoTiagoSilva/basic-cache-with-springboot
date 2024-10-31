package com.demo.basic_cache_with_springboot.repositories;

import com.demo.basic_cache_with_springboot.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
