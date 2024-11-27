package com.egg.libreriaapi.model.dao;

import com.egg.libreriaapi.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDao extends JpaRepository<Autor,String> {
}
