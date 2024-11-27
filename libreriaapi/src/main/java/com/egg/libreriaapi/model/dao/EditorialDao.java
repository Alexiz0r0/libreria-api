package com.egg.libreriaapi.model.dao;

import com.egg.libreriaapi.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialDao extends JpaRepository<Editorial, String> {
}
