package com.egg.libreriaapi.service;

import com.egg.libreriaapi.model.request.AutorEditReq;
import com.egg.libreriaapi.model.request.AutorReq;
import com.egg.libreriaapi.model.response.AutorResp;

import java.util.List;

public interface IAutor {

    List<AutorResp> listarTodos();

    AutorResp agregar(AutorReq autor);

    AutorResp encontrarPorId(String id);

    void eliminar(String id);

    AutorResp editar(AutorEditReq autor);
}
