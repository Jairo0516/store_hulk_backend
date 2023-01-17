package com.store.hulk.domain.service.impl;


import com.store.hulk.controller.dto.ProductDTO;
import com.store.hulk.controller.dto.response.ResponseCreateDTO;
import com.store.hulk.controller.dto.response.ResponseDTO;
import com.store.hulk.controller.dto.response.StatusDTO;
import com.store.hulk.domain.builder.ObjectBuilder;
import com.store.hulk.domain.entity.Products;
import com.store.hulk.domain.repository.ProductRepository;
import com.store.hulk.domain.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.store.hulk.util.Constants.*;


@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectBuilder objectBuilder;


    @Override
    public ResponseEntity<ResponseDTO> create(ProductDTO productDTO) {

        Products product = objectBuilder.map(productDTO, Products.class);
        Products productSave = productRepository.save(product);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ResponseDTO> update(ProductDTO productDTO) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ResponseCreateDTO> getAllByStock() {
        List<Products> products;
        List<ProductDTO> productsList = new ArrayList<>();
        StatusDTO statusDTO;
        try {
            products = productRepository.getAllByStock(1);
            productsList = objectBuilder.mapAll(products, ProductDTO.class);
            statusDTO = productsList.size()>0 ? new StatusDTO(SUCCESS_MESSAGE) :  new StatusDTO(MESSAGE_LIST_EMPTY);
        }catch (Exception e){
            statusDTO = new StatusDTO(ERROR_MESSAGE);
        }

        return ResponseEntity.ok(ResponseCreateDTO.builder()
                .status(statusDTO)
                .products(productsList)
                .build());
    }

    @Override
    public ResponseEntity<ResponseDTO> getById(Integer id) {
        return ResponseEntity.ok().build();
    }

}
