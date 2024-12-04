package com.egg.libreriaapi.model.dao;

import com.egg.libreriaapi.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroDao extends JpaRepository<Libro, Integer> {

    @Query(
            value = "SELECT * FROM libros l WHERE l.libro_activo = 1",
            nativeQuery = true
    )
    public List<Libro> encontrarLibroActivos();
}
