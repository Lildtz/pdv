package com.all.pdv.repository;

import com.all.pdv.entity.ItemSale;
import com.all.pdv.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
