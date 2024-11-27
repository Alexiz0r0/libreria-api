package com.egg.libreriaapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "autores")
@Setter
@Getter
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_autor")
    private String idAutor;

    @Column(name = "autor_activo")
    private Boolean autorActivo;

    @Column(name = "nombre_autor")
    private String nombreAutor;
}
