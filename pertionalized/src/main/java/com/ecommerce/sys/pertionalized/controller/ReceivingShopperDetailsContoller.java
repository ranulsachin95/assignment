package com.ecommerce.sys.pertionalized.controller;

import com.ecommerce.sys.pertionalized.entity.Product;
import com.ecommerce.sys.pertionalized.entity.Shopper;
import com.ecommerce.sys.pertionalized.service.ProductService;
import com.ecommerce.sys.pertionalized.service.ShopperService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("internal/")
public class ReceivingShopperDetailsContoller {

    @Autowired
    private ProductService productService;
    @Autowired
    ShopperService shopperService;
    @PostMapping("receive-products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        log.info("ReceivingShopperDetailsContoller -> addProduct ->started");
    return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @PostMapping("/save-shopper")
    public ResponseEntity<Shopper> addShopper(@RequestBody Shopper shopper) {
        log.info("ReceivingShopperDetailsContoller -> addShopper ->started");
        return new ResponseEntity<>(shopperService.saveShopper(shopper), HttpStatus.OK);
    }



}
