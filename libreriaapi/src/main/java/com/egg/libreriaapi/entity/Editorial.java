package com.egg.libreriaapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
