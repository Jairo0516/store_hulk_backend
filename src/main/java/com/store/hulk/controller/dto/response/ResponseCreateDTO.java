package com.store.hulk.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.store.hulk.controller.dto.ProductDTO;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ResponseCreateDTO {

    private StatusDTO status;

    private List<ProductDTO> products;
}
