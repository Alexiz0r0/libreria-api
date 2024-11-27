package com.egg.libreriaapi.service;

import com.egg.libreriaapi.entity.Editorial;

import java.util.List;

public interface IEditorial {

    List<Editorial> listarTodos();

    Editorial agregar(Editorial editorial);

    Editorial encontrarPorId(String id);

    void eliminar(Editorial editorial);

    Editorial editar(Editorial editorial);
}