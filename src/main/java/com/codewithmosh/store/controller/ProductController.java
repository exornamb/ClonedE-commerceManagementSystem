package com.codewithmosh.store.controller;

import com.codewithmosh.store.dtos.ProductDto;
import com.codewithmosh.store.mapper.ProductMapper;
import com.codewithmosh.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @GetMapping
    public List<ProductDto> getProducts(
            @RequestParam(required = false) Byte categoryId
    ){
        if(categoryId != null){
            return productRepository.findByCategoryId(categoryId)
                    .stream()
                    .map(productMapper::toProductDto)
                    .toList();
        }

        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        var product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productMapper.toProductDto(product));
    }
}
