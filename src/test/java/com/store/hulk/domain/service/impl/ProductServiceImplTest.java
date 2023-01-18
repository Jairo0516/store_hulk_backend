package com.store.hulk.domain.service.impl;

import com.store.hulk.controller.dto.ProductDTO;
import com.store.hulk.controller.dto.response.ResponseCreateDTO;
import com.store.hulk.controller.dto.response.ResponseDTO;
import com.store.hulk.domain.builder.ObjectBuilder;
import com.store.hulk.domain.entity.Products;
import com.store.hulk.domain.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Mock
    ObjectBuilder objectBuilder;

    ProductDTO productDTO = new ProductDTO();

    Products product;

    ResponseEntity<ResponseDTO> responseEntityDto = ResponseEntity.ok().build();


    @Before
    public void setUp() throws Exception {
        productDTO.setDescription("Test sevice description");
        productDTO.setImage("Test sevice  image");
        productDTO.setName("Test sevice name");
        productDTO.setStock(20);
        productDTO.setValue(90000.3);


    }

    @Test
    public void create() {

        product = getProduct();

        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(objectBuilder.map(productDTO, Products.class)).thenReturn(product);


        ResponseEntity<ResponseDTO> response = productService.create(productDTO);
        Assert.assertEquals(response.getStatusCode().value(), 200);
    }

    @Test
    public void update() {

        product = getProduct();

        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(objectBuilder.map(productDTO, Products.class)).thenReturn(product);


        ResponseEntity<ResponseDTO> response = productService.update(productDTO);
        Assert.assertEquals(response.getStatusCode().value(), 200);
    }

    @Test
    public void getAllByStock() {
        product = getProduct();

        List<Products> productsList = new ArrayList<>();
        productsList.add(product);


        List<ProductDTO> productDTOList = new ArrayList<>();
        productDTOList.add(productDTO);

        Mockito.when(productRepository.getAllByStock(1)).thenReturn(productsList);
        Mockito.when(objectBuilder.mapAll(productsList, ProductDTO.class)).thenReturn(productDTOList);
        ResponseEntity<ResponseCreateDTO> response = productService.getAllByStock();
        Assert.assertEquals(response.getStatusCode().value(), 200);
    }

    @Test
    public void getById() {
        product = getProduct();

        Mockito.when(productRepository.findById(1)).thenReturn(Optional.ofNullable(product));
        Mockito.when(objectBuilder.map(product, Products.class)).thenReturn(product);
        Mockito.when(objectBuilder.map(product, ProductDTO.class)).thenReturn(productDTO);

        ResponseEntity<ResponseDTO> response = productService.getById(1);
        Assert.assertEquals(response.getStatusCode().value(), 200);

    }


    private Products getProduct(){
        return Products.builder()
                .description(productDTO.getDescription())
                .image(productDTO.getImage())
                .name(productDTO.getName())
                .stock(productDTO.getStock())
                .value(productDTO.getValue())
                .build();
    }
}