package com.egg.libreriaapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class LibroEditReq {
    private Integer id;
    private Integer ejemplares;
    private Boolean active;
    private String titulo;
    private String idAutor;
    private String idEditorial;
}
