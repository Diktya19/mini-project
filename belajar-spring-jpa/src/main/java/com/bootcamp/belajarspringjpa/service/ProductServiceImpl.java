package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.ProductEntity;
import com.bootcamp.belajarspringjpa.model.ProductDto;
import com.bootcamp.belajarspringjpa.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
            //implements adalah bagaimana metod itu bekerja
            //Depedency = ketergantungan
            //STEP6
@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity getByid(Integer id) {
        return productRepo.findById(id).orElse(new ProductEntity());
    }

    @Override
    public ProductEntity save(ProductDto request) {

        ProductEntity result = new ProductEntity();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setDescription(request.getDescription());
        result.setPrice(request.getPrice());
        result.setQuantity(request.getQuantity());

        try {
            productRepo.save(result);
            log.info("Save product to database succesfully");
            return result;
        } catch (Exception e){
            log.error("Save product to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public ProductEntity delete(Integer id) {
        // search data product base on id
        ProductEntity entity = productRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Product with id: {} not found", id);
            return null;
        }

        try{
            //proses delete ke DB
            productRepo.delete(entity);
            log.info("Delete product from database successfully");
            return entity;
        } catch (Exception e){
            // jika ada error
            log.error("Delete product from database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public ProductEntity update(Integer id, ProductDto request) {
        ProductEntity entity = productRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Product with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());

        try{
           productRepo.save(entity);
           log.info("Update product to database successfully");
           return entity;
        } catch (Exception e){
            log.error("Update product to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}