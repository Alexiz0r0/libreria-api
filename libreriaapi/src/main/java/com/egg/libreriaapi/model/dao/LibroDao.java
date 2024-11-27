package com.egg.libreriaapi.model.dao;

import com.egg.libreriaapi.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDao extends JpaRepository<Libro, Integer> {
}
