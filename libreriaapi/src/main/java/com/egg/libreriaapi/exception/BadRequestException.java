package com.egg.libreriaapi.exception;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends RuntimeException {

    private String code;

    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }
}
