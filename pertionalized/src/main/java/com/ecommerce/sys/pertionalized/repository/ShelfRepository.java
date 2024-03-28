package com.ecommerce.sys.pertionalized.repository;

import com.ecommerce.sys.pertionalized.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf,Long> {
}
