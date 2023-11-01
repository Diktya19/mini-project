package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.ProductEntity;
import com.bootcamp.belajarspringjpa.model.ProductDto;

import java.util.List;
//STEP5

public interface ProductService {
    List<ProductEntity> getAll();
    ProductEntity getByid(Integer id);
    ProductEntity save(ProductDto request);
    ProductEntity delete(Integer id);
    ProductEntity update(Integer id, ProductDto request);
}
