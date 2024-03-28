package com.ecommerce.sys.pertionalized.repository;

import com.ecommerce.sys.pertionalized.entity.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper, Long> {
}
