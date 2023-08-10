package io.marktoledo.exchangerateapi.dto;

import lombok.Data;

@Data
public class ErrorResponse {

    private Error error;

    @Data
    class Error{
        private String code;

        private String message;
    }
}