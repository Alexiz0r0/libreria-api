package com.egg.libreriaapi.service;

import com.egg.libreriaapi.model.dto.MessageDto;
import com.egg.libreriaapi.model.request.EditorialEditReq;
import com.egg.libreriaapi.model.request.EditorialReq;
import com.egg.libreriaapi.model.response.EditorialResp;

import java.util.List;

public interface IEditorial {

    List<EditorialResp> listarTodos();

    EditorialResp agregar(EditorialReq editorial);

    EditorialResp encontrarPorId(String id);

    MessageDto eliminar(String id);

    EditorialResp editar(EditorialEditReq editorial);

    List<EditorialResp> buscarPorNombre(String name);
}
