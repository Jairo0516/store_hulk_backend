package com.store.hulk.domain.repository;

import com.store.hulk.domain.entity.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {

    @Query(value = "select * from schema_store.products where stock >= :stock",
            nativeQuery = true)
    List<Products> getAllByStock(@Param("stock") Integer stock);



}
