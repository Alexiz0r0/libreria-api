package com.egg.libreriaapi.service;

import com.egg.libreriaapi.entity.Autor;

import java.util.List;

public interface IAutor {

    List<Autor> listarTodos();

    Autor agregar(Autor autor);

    Autor encontrarPorId(String id);

    void eliminar(String id);

    Autor editar(Autor autor);
}
