package com.ecommerce.sys.pertionalized.service.impl;

import com.ecommerce.sys.pertionalized.entity.Product;
import com.ecommerce.sys.pertionalized.exception.ProductNotFoundException;
import com.ecommerce.sys.pertionalized.repository.ProductRepository;
import com.ecommerce.sys.pertionalized.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductByShopper(String shopperId, String category, String brand, int limit) throws ProductNotFoundException {

        log.info("ProductServiceImpl -> getProductByShopper ->started");
        if (shopperId==null|| shopperId.isEmpty()) {
            log.info("ProductServiceImpl -> getProductByShopper ->Not Fount Shopper Id");
            throw new ProductNotFoundException("Not Fount Shopper Id");
        }

        else if (limit<10 || limit>100) {
            log.info("ProductServiceImpl -> getProductByShopper ->Limit Error Generated ");
            throw new ProductNotFoundException("Limit Should Be Less than 100 and Grater than 10");

        }
        log.info("ProductServiceImpl -> getProductByShopper ->ended");
        return productRepository.getProductByShopper(shopperId,category,brand,limit);
    }
}
