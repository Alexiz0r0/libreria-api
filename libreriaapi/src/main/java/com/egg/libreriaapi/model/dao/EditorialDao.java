package com.egg.libreriaapi.model.dao;

import com.egg.libreriaapi.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditorialDao extends JpaRepository<Editorial, String> {

    @Query(
            value = "SELECT * FROM editoriales e WHERE e.nombre_editorial LIKE %:nombre%",
            nativeQuery = true
    )
    public List<Editorial> buscarPorNombre(@Param("nombre") String nombre);
}
