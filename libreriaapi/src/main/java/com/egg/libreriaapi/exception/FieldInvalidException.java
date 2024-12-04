package com.egg.libreriaapi.exception;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldInvalidException extends RuntimeException {

    private String code;

    public FieldInvalidException(String message, String code) {
        super(message);
        this.code = code;
    }
}
