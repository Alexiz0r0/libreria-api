package com.egg.libreriaapi.service.impl;

import com.egg.libreriaapi.entity.Editorial;
import com.egg.libreriaapi.exception.BadRequestException;
import com.egg.libreriaapi.exception.ResourceNotFoundException;
import com.egg.libreriaapi.model.dao.EditorialDao;
import com.egg.libreriaapi.model.dto.MessageDto;
import com.egg.libreriaapi.model.request.EditorialEditReq;
import com.egg.libreriaapi.model.request.EditorialReq;
import com.egg.libreriaapi.model.response.EditorialResp;
import com.egg.libreriaapi.service.IEditorial;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialImpl implements IEditorial {

    private final EditorialDao editorialDao;

    @Override
    public List<EditorialResp> listarTodos() {
        List<EditorialResp> resps = new ArrayList<>();
        List<Editorial> editorials = editorialDao.findAll();
        for (Editorial editorial : editorials) {
            resps.add(generateEditorialResp(editorial));
        }
        return resps;
    }

    @Override
    public EditorialResp agregar(EditorialReq editorial) {
        validateNombreReq(editorial.getName());
        Editorial editorial1 = editorialDao.save(generateEditorial(editorial));
        return generateEditorialResp(editorial1);
    }

    @Override
    public EditorialResp encontrarPorId(String id) {
        Editorial editorial = editorialDao.findById(id).orElse(null);
        isEditorialPresent(editorial);
        return generateEditorialResp(editorial);
    }

    @Override
    public MessageDto eliminar(String id) {
        Editorial editorial = editorialDao.findById(id).orElse(null);
        isEditorialPresent(editorial);
        editorialDao.delete(editorial);
        return MessageDto.builder()
                .msg("Recurso eliminado")
                .code("E-500")
                .build();
    }

    @Override
    public EditorialResp editar(EditorialEditReq editorial) {
        validateNombreReq(editorial.getName());
        Editorial editorial1 = editorialDao.findById(editorial.getId()).orElse(null);
        isEditorialPresent(editorial1);
        editorial1.setNombreEditorial(editorial.getName());
        editorial1.setEditorialActiva(editorial.getActive());
        return generateEditorialResp(editorialDao.save(editorial1));
    }

    @Override
    public List<EditorialResp> buscarPorNombre(String name) {
        validateArgument(name);
        List<EditorialResp> resps = new ArrayList<>();
        List<Editorial> editorials = editorialDao.buscarPorNombre(name);
        for (Editorial editorial : editorials) {
            resps.add(generateEditorialResp(editorial));
        }
        return resps;
    }


    private void isEditorialPresent(Editorial editorial) {
        if (editorial == null) {
            throw new ResourceNotFoundException("El recurso no existe", "E-100");
        }
    }

    private Editorial generateEditorial(EditorialReq req) {
        Editorial editorial = new Editorial();
        editorial.setNombreEditorial(editorial.getNombreEditorial());
        editorial.setEditorialActiva(editorial.getEditorialActiva());
        return editorial;
    }

    private EditorialResp generateEditorialResp(Editorial editorial) {
        return EditorialResp.builder()
                .id(editorial.getIdEditorial())
                .name(editorial.getNombreEditorial())
                .active(editorial.getEditorialActiva())
                .build();
    }

    private void validateNombreReq(String name) {
        if (name.trim().equals("") || name == null) {
            throw new BadRequestException("Nombre es obligatorio", "E-200");
        }
    }

    private void validateArgument(String name) {
        if (name == null || name.length() > 50) {
            throw new BadRequestException("El parametro proporcionado no es válido.", "E-300");
        }
    }
}
