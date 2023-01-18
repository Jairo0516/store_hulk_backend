package com.store.hulk.domain.service;


import com.store.hulk.controller.dto.ProductDTO;
import com.store.hulk.controller.dto.response.ResponseCreateDTO;
import com.store.hulk.controller.dto.response.ResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity create(ProductDTO productDTO) throws Exception;

    ResponseEntity update(ProductDTO productDTO, Integer id) throws Exception;

    ResponseEntity<ResponseCreateDTO> getAllByStock();

    ResponseEntity getById(Integer id) throws Exception;
}
