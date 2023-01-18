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
import static com.store.hulk.util.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.store.hulk.util.Constants.*;


@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectBuilder objectBuilder;

    private StatusDTO statusDTO;

    @Override
    public ResponseEntity<ResponseDTO> create(ProductDTO productDTO) {
        Products productSave = null;
        try {
            Products product = objectBuilder.map(productDTO, Products.class);
            productSave = productRepository.save(product);
            statusDTO = new StatusDTO(SUCCESS_MESSAGE, SUCCESS_CODE);
        }catch (Exception e){
            statusDTO = new StatusDTO(ERROR_MESSAGE,ERROR_CODE);
        }


        return ResponseEntity.ok(ResponseDTO.builder()
                .status(statusDTO)
                .product(objectBuilder.map(productSave, ProductDTO.class))
                .build());
    }

    @Override
    public ResponseEntity<ResponseDTO> update(ProductDTO productDTO) {
        Products productSave = null;
        try {
            Products product = objectBuilder.map(productDTO, Products.class);
            productSave = productRepository.save(product);
            statusDTO = new StatusDTO(SUCCESS_MESSAGE, SUCCESS_CODE);
        }catch (Exception e){
            statusDTO = new StatusDTO(ERROR_MESSAGE,ERROR_CODE);
        }

        return ResponseEntity.ok(ResponseDTO.builder()
                .status(statusDTO)
                .product(objectBuilder.map(productSave, ProductDTO.class))
                .build());
    }

    @Override
    public ResponseEntity<ResponseCreateDTO> getAllByStock() {
        List<Products> products;
        List<ProductDTO> productsList = new ArrayList<>();
        try {
            products = productRepository.getAllByStock(1);
            productsList = objectBuilder.mapAll(products, ProductDTO.class);
            statusDTO = productsList.size() > 0 ? new StatusDTO(SUCCESS_MESSAGE, SUCCESS_CODE) :  new StatusDTO(MESSAGE_LIST_EMPTY, NOT_FOUND_CODE);
        }catch (Exception e){
            statusDTO = new StatusDTO(ERROR_MESSAGE,ERROR_CODE);
        }

        return ResponseEntity.ok(ResponseCreateDTO.builder()
                .status(statusDTO)
                .products(productsList)
                .build());
    }

    @Override
    public ResponseEntity<ResponseDTO> getById(Integer id) {
        Optional<Products> product;
        Products productById = null;
        try {
            product = productRepository.findById(id);
            productById = objectBuilder.map(product.get(), Products.class);


            statusDTO = new StatusDTO(SUCCESS_MESSAGE, SUCCESS_CODE);
        }catch (Exception e){
            statusDTO =new StatusDTO(MESSAGE_REGISTER_NOT_FOUND, NOT_FOUND_CODE);
        }





        return ResponseEntity.ok(ResponseDTO.builder()
                .status(statusDTO)
                .product(objectBuilder.map(productById, ProductDTO.class))
                .build());
    }

}
