package com.egg.libreriaapi.service.impl;

import com.egg.libreriaapi.entity.Libro;
import com.egg.libreriaapi.service.ILibro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroImpl implements ILibro {
    @Override
    public List<Libro> listarTodos() {
        return List.of();
    }

    @Override
    public Libro agregar(Libro libro) {
        return null;
    }

    @Override
    public Libro encontrarPorId(String id) {
        return null;
    }

    @Override
    public void eliminar(Libro libro) {

    }

    @Override
    public Libro editar(Libro libro) {
        return null;
    }
}
