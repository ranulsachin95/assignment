package com.ecommerce.sys.pertionalized.repository;

import com.ecommerce.sys.pertionalized.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(
            nativeQuery = true,
            value
                    = "SELECT p.* FROM ((shelf s \n" +
                    "INNER JOIN Product p ON s.product_id = p.id and p.category =:category or p.brand=:brand)\n" +
                    "INNER JOIN shopper sp ON s.shopper_id = sp.id  and sp.shopper_id=:shopperId ) limit :limit")
       List<Product> getProductByShopper(@Param("shopperId")  String shopperId,@Param("category")  String category,@Param("brand")  String brand ,@Param("limit") int limit);

}
