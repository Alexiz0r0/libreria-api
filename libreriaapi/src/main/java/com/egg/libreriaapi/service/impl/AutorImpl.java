package com.egg.libreriaapi.service.impl;

import com.egg.libreriaapi.entity.Autor;
import com.egg.libreriaapi.exception.BadRequestException;
import com.egg.libreriaapi.exception.ResourceNotFoundException;
import com.egg.libreriaapi.model.dao.AutorDao;
import com.egg.libreriaapi.model.dto.MessageDto;
import com.egg.libreriaapi.model.request.AutorEditReq;
import com.egg.libreriaapi.model.request.AutorReq;
import com.egg.libreriaapi.model.response.AutorResp;
import com.egg.libreriaapi.service.IAutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorImpl implements IAutor {

    private final AutorDao autorDao;

    @Override
    public List<AutorResp> listarTodos() {
        List<AutorResp> resps = new ArrayList<>();
        List<Autor> autors = autorDao.findAll();
        for (Autor autor : autors) {
            resps.add(generateAutorResp(autor));
        }
        return resps;
    }

    @Override
    public AutorResp agregar(AutorReq autor) {
        validateNombreReq(autor.getName());
        Autor autor1 = autorDao.save(generateAutor(autor));
        return generateAutorResp(autor1);
    }

    @Override
    public AutorResp encontrarPorId(String id) {
        Autor autor = autorDao.findById(id).orElse(null);
        isAutorPresent(autor);
        return generateAutorResp(autor);
    }

    @Override
    public MessageDto eliminar(String id) {
        Autor autor = autorDao.findById(id).orElse(null);
        isAutorPresent(autor);
        autorDao.delete(autor);
        return MessageDto.builder()
                .msg("Recurso eliminado")
                .code("E-500")
                .build();
    }

    @Override
    public AutorResp editar(AutorEditReq autor) {
        Autor autor1 = autorDao.findById(autor.getId()).orElse(null);
        isAutorPresent(autor1);
        validateNombreReq(autor.getName());
        autor1.setNombreAutor(autor.getName());
        autor1.setAutorActivo(autor.getActive());
        return generateAutorResp(autorDao.save(autor1));
    }

    @Override
    public List<AutorResp> buscarPorNombre(String name) {
        validateArgument(name);
        List<AutorResp> resps = new ArrayList<>();
        List<Autor> autors = autorDao.buscarPorNombre(name);
        for (Autor autor : autors) {
            resps.add(generateAutorResp(autor));
        }
        return resps;
    }


    private void isAutorPresent(Autor autor) {
        if (autor == null) {
            throw new ResourceNotFoundException("El recurso no existe", "A-100");
        }
    }

    private AutorResp generateAutorResp(Autor autor) {
        return AutorResp.builder()
                .id(autor.getIdAutor())
                .active(autor.getAutorActivo())
                .name(autor.getNombreAutor())
                .build();
    }

    private Autor generateAutor(AutorReq autorReq) {
        Autor autor = new Autor();
        autor.setNombreAutor(autorReq.getName());
        autor.setAutorActivo(autorReq.getActive());
        return autor;
    }

    private void validateNombreReq(String name) {
        if (name.trim().equals("") || name == null) {
            throw new BadRequestException("Nombre es obligatorio", "A-200");
        }
    }

    private void validateArgument(String name) {
        if (name == null || name.length() > 50) {
            throw new BadRequestException("El parametro proporcionado no es válido.", "A-300");
        }
    }
}
