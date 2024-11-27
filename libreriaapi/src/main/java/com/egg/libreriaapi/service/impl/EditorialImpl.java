package com.egg.libreriaapi.service.impl;

import com.egg.libreriaapi.entity.Editorial;
import com.egg.libreriaapi.service.IEditorial;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialImpl implements IEditorial {
    @Override
    public List<Editorial> listarTodos() {
        return List.of();
    }

    @Override
    public Editorial agregar(Editorial editorial) {
        return null;
    }

    @Override
    public Editorial encontrarPorId(String id) {
        return null;
    }

    @Override
    public void eliminar(Editorial editorial) {

    }

    @Override
    public Editorial editar(Editorial editorial) {
        return null;
    }
}
