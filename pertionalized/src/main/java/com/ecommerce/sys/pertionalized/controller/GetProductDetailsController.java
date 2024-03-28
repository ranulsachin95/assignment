package com.ecommerce.sys.pertionalized.controller;

import com.ecommerce.sys.pertionalized.entity.Product;
import com.ecommerce.sys.pertionalized.exception.ProductNotFoundException;
import com.ecommerce.sys.pertionalized.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("external/")
public class GetProductDetailsController {

    @Autowired
    private ProductService productService;
    @GetMapping("get-products-by-shopper")
    public ResponseEntity<List<Product>> getProductByShopper(
            @RequestParam String shopperId,
            @RequestParam String category,
            @RequestParam String brand,
            @RequestParam int limit ) throws ProductNotFoundException {
        log.info("GetProductDetailsController -> getProductByShopper ->started");
        return new ResponseEntity<>(productService.getProductByShopper(shopperId,category,brand,limit), HttpStatus.OK);
    }
}
