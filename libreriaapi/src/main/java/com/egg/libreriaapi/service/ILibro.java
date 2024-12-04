package com.egg.libreriaapi.service;

import com.egg.libreriaapi.model.dto.MessageDto;
import com.egg.libreriaapi.model.request.LibroEditReq;
import com.egg.libreriaapi.model.request.LibroReq;
import com.egg.libreriaapi.model.response.LibroResp;

import java.util.List;

public interface ILibro {


    List<LibroResp> listarTodos();

    LibroResp agregar(LibroReq libro);

    LibroResp encontrarPorId(Integer id);

    MessageDto eliminar(Integer id);

    LibroResp editar(LibroEditReq libro);

    List<LibroResp> listarLibrosActivos();

}
