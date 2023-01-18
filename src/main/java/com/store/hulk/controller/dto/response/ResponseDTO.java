package com.store.hulk.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.store.hulk.controller.dto.ProductDTO;
import lombok.*;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ResponseDTO {

    private StatusDTO status;

    private ProductDTO product;

}
