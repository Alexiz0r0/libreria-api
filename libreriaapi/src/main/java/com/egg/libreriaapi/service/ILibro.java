package com.egg.libreriaapi.service;

import com.egg.libreriaapi.entity.Libro;

import java.util.List;

public interface ILibro {


    List<Libro> listarTodos();

    Libro agregar(Libro libro);

    Libro encontrarPorId(String id);

    void eliminar(Libro libro);

    Libro editar(Libro libro);
}
