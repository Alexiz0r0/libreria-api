package com.egg.libreriaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Libro> libros;

}
