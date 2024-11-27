package com.egg.libreriaapi.service.impl;

import com.egg.libreriaapi.entity.Autor;
import com.egg.libreriaapi.exception.ResourceNotFoundException;
import com.egg.libreriaapi.model.dao.AutorDao;
import com.egg.libreriaapi.service.IAutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorImpl implements IAutor {

    private final AutorDao autorDao;

    @Override
    public List<Autor> listarTodos() {
        return autorDao.findAll();
    }

    @Override
    public Autor agregar(Autor autor) {
        return autorDao.save(autor);
    }

    @Override
    public Autor encontrarPorId(String id) {
        Autor autor = autorDao.findById(id).orElse(null);
        isAutorPresent(autor);
        return autor;
    }

    @Override
    public void eliminar(String id) {
        Autor autor = autorDao.findById(id).orElse(null);
        isAutorPresent(autor);
        autorDao.delete(autor);
    }

    @Override
    public Autor editar(Autor autor) {
        Autor autor1 = autorDao.findById(autor.getIdAutor()).orElse(null);
        isAutorPresent(autor1);
        autor1.setNombreAutor(autor.getNombreAutor());
        autor1.setAutorActivo(autor.getAutorActivo());
        return autorDao.save(autor1);
    }

    private void isAutorPresent(Autor autor) {
        if (autor == null) {
            throw new ResourceNotFoundException("El recurso no existe", "A-100");
        }
    }
}
