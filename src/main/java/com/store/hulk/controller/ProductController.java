package com.store.hulk.controller;

import com.store.hulk.controller.dto.ProductDTO;
import com.store.hulk.controller.dto.response.ResponseCreateDTO;
import com.store.hulk.controller.dto.response.ResponseDTO;
import com.store.hulk.domain.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/store/product")
@CrossOrigin(origins= "*" , allowedHeaders = "*")
@RestController
@Validated
@Api(value = "Store Products", tags = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "Get all product service")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<ResponseCreateDTO> getAll() {
        return productService.getAllByStock();

    }

    @ApiOperation(value = "Create product service", response = ResponseDTO.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> create(@RequestBody @Valid ProductDTO productDTO) throws Exception {
        return productService.create(productDTO);
    }


    @ApiOperation(value = "Get product by id service", response = ResponseDTO.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getAgentByAgentCode(
            @PathVariable Integer id
    ) throws Exception {
        return productService.getById(id);
    }


    @ApiOperation(value = "Update product service by id", response = ResponseDTO.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDTO> update(@RequestBody @Valid ProductDTO productDTO) throws Exception {
        return productService.update(productDTO);
    }

}
