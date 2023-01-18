package com.store.hulk.controller;

import com.store.hulk.controller.dto.ProductDTO;
import com.store.hulk.controller.dto.response.ResponseCreateDTO;
import com.store.hulk.controller.dto.response.ResponseDTO;
import com.store.hulk.domain.service.ProductService;
import com.store.hulk.domain.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    ProductDTO productDTO= new ProductDTO();

    ResponseEntity responseEntity = ResponseEntity.ok().build();

    @BeforeEach
    void setUp() {
        productDTO.setDescription("Test description");
        productDTO.setImage("Test image");
        productDTO.setName("Test name");
        productDTO.setStock(2);
        productDTO.setValue(200.3);

    }


    @Test
    public void create() throws Exception {
        Mockito.when(productService.create(productDTO)).thenReturn(responseEntity);
        ResponseEntity<ResponseDTO> responseCreate = productController.create(productDTO);
        Assert.assertEquals(responseCreate.getStatusCode().value(),200);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(productService.update(productDTO)).thenReturn(responseEntity);
        ResponseEntity<ResponseDTO> responseCreate = productController.update(productDTO);
        Assert.assertEquals(responseCreate.getStatusCode().value(),200);
    }

    @Test
    public void getAll() {
        Mockito.when(productService.getAllByStock()).thenReturn(responseEntity);
        ResponseEntity<ResponseCreateDTO> responseCreate = productController.getAll();
        Assert.assertEquals(responseCreate.getStatusCode().value(),200);
    }

    @Test
    public void getAgentById() throws Exception {
        Mockito.when(productService.getById(1)).thenReturn(responseEntity);
        ResponseEntity<ResponseDTO> responseCreate = productController.getAgentById(1);
        Assert.assertEquals(responseCreate.getStatusCode().value(),200);
    }


}