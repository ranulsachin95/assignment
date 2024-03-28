package com.ecommerce.sys.pertionalized.service;

import com.ecommerce.sys.pertionalized.entity.Product;
import com.ecommerce.sys.pertionalized.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getProductByShopper(String shopperId, String category, String brand, int limit ) throws ProductNotFoundException;

}
