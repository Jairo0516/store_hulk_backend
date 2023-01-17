package com.store.hulk.domain.entity;

import com.store.hulk.domain.entity.key.ProductsKey;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@IdClass(ProductsKey.class)
@Table(name = "products", schema = "schema_store")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "value")
    private Float value;

    @Column(name = "image")
    private String image;
}
