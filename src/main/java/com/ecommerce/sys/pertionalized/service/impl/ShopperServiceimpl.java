package com.ecommerce.sys.pertionalized.service.impl;

import com.ecommerce.sys.pertionalized.entity.Shopper;
import com.ecommerce.sys.pertionalized.exception.EntityException;
import com.ecommerce.sys.pertionalized.repository.ProductRepository;
import com.ecommerce.sys.pertionalized.repository.ShelfRepository;
import com.ecommerce.sys.pertionalized.repository.ShopperRepository;
import com.ecommerce.sys.pertionalized.service.ShopperService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ShopperServiceimpl implements ShopperService {
    @Autowired
    private ShopperRepository shopperRepository;
    @Autowired
    private ShelfRepository shelfRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    @Transactional
    public Shopper saveShopper(Shopper shopper) {
        log.info("ShopperServiceimpl -> saveShopper ->started");
        Shopper shopper1=shopperRepository.save(shopper);
        if (shopper1==null){
            log.info("ShopperServiceimpl -> saveShopper ->started");
            throw new EntityException("Shopper Not Saved");
        }
        System.out.print(shopper.toString());
        shopper.getShelf().forEach(shelf->{
            shelf.setShopper(shopper1);
            System.out.print(shelf.getProduct().toString());
            productRepository.save(shelf.getProduct());
        });


        shelfRepository.saveAll(shopper.getShelf());

        return shopper1;
    }
}
