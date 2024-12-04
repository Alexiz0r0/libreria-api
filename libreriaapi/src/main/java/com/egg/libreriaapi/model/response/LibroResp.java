package com.egg.libreriaapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class LibroResp {
    private Integer id;
    private Integer ejemplares;
    private Boolean active;
    private String titulo;
    private String idAutor;
    private String nombreAutor;
    private String idEditorial;
    private String nombreEditorial;

}
