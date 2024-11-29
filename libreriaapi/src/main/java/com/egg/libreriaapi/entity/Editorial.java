package com.egg.libreriaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "editoriales")
@Setter
@Getter
@NoArgsConstructor
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_editorial")
    private String idEditorial;

    @Column(name = "editorial_activa")
    private Boolean editorialActiva;

    @Column(name = "nombre_editorial")
    private String nombreEditorial;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "editorial", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Libro> libros;
}
