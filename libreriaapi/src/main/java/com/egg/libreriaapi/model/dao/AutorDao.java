package com.egg.libreriaapi.model.dao;

import com.egg.libreriaapi.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorDao extends JpaRepository<Autor, String> {

    @Query("SELECT a FROM Autor a WHERE a.nombreAutor LIKE %:name%")
    public List<Autor> buscarPorNombre(@Param("name") String name);
}
