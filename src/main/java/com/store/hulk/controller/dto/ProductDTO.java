package com.store.hulk.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    @NotNull
    @ApiModelProperty(notes = "name")
    private String name;

    @NotNull
    @ApiModelProperty(notes = "description")
    private String description;

    @NotNull
    @ApiModelProperty(notes = "stock")
    private Integer stock;

    @NotNull
    @ApiModelProperty(notes = "value")
    private Double value;

    @NotNull
    @ApiModelProperty(notes = "Image")
    private String Image;
}
