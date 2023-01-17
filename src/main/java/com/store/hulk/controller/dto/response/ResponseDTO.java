package com.store.hulk.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ResponseDTO {

    private StatusDTO status;

    public static ResponseDTO apply(String message) {
        return new ResponseDTO(new StatusDTO(message));
    }
}
