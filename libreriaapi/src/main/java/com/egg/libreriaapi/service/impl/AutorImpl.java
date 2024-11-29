package com.egg.libreriaapi.service.impl;

import com.egg.libreriaapi.entity.Autor;
import com.egg.libreriaapi.exception.BadRequestException;
import com.egg.libreriaapi.exception.ResourceNotFoundException;
import com.egg.libreriaapi.model.dao.AutorDao;
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
        Autor autor1 = autorDao.save(generateAutor(autor));
        validateNombreReq(autor.getName());
        return generateAutorResp(autor1);
    }

    @Override
    public AutorResp encontrarPorId(String id) {
        Autor autor = autorDao.findById(id).orElse(null);
        isAutorPresent(autor);
        return generateAutorResp(autor);
    }

    @Override
    public void eliminar(String id) {
        Autor autor = autorDao.findById(id).orElse(null);
        isAutorPresent(autor);
        autorDao.delete(autor);
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
}
