package com.egg.libreriaapi.service.impl;

import com.egg.libreriaapi.entity.Editorial;
import com.egg.libreriaapi.exception.ResourceNotFoundException;
import com.egg.libreriaapi.model.dao.EditorialDao;
import com.egg.libreriaapi.service.IEditorial;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialImpl implements IEditorial {

    private final EditorialDao editorialDao;

    @Override
    public List<Editorial> listarTodos() {
        return editorialDao.findAll();
    }

    @Override
    public Editorial agregar(Editorial editorial) {
        return editorialDao.save(editorial);
    }

    @Override
    public Editorial encontrarPorId(String id) {
        Editorial editorial = editorialDao.findById(id).orElse(null);
        isEditorialPresent(editorial);
        return editorial;
    }

    @Override
    public void eliminar(String id) {
        Editorial editorial = editorialDao.findById(id).orElse(null);
        isEditorialPresent(editorial);
        editorialDao.delete(editorial);
    }

    @Override
    public Editorial editar(Editorial editorial) {
        Editorial editorial1 = editorialDao.findById(editorial.getIdEditorial()).orElse(null);
        isEditorialPresent(editorial1);
        editorial1.setNombreEditorial(editorial.getNombreEditorial());
        return editorialDao.save(editorial1);
    }


    private void isEditorialPresent(Editorial editorial) {
        if (editorial == null) {
            throw new ResourceNotFoundException("El recurso no existe", "E-100");
        }
    }
}
