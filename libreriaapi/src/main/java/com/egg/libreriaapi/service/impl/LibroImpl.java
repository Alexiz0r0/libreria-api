package com.egg.libreriaapi.service.impl;

import com.egg.libreriaapi.entity.Autor;
import com.egg.libreriaapi.entity.Editorial;
import com.egg.libreriaapi.entity.Libro;
import com.egg.libreriaapi.exception.ResourceNotFoundException;
import com.egg.libreriaapi.model.dao.AutorDao;
import com.egg.libreriaapi.model.dao.EditorialDao;
import com.egg.libreriaapi.model.dao.LibroDao;
import com.egg.libreriaapi.model.dto.MessageDto;
import com.egg.libreriaapi.model.request.LibroEditReq;
import com.egg.libreriaapi.model.request.LibroReq;
import com.egg.libreriaapi.model.response.LibroResp;
import com.egg.libreriaapi.service.ILibro;
import com.egg.libreriaapi.validator.LibroValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroImpl implements ILibro {

    private final AutorDao autorDao;
    private final EditorialDao editorialDao;
    private final LibroDao libroDao;
    private final LibroValidator validator;

    @Override
    public List<LibroResp> listarTodos() {
        List<LibroResp> resps = new ArrayList<>();
        List<Libro> libros = libroDao.findAll();
        for (Libro libro : libros) {
            resps.add(generateLibroResp(libro));
        }
        return resps;
    }

    @Override
    public LibroResp agregar(LibroReq libro) {
        validator.validateLibroReq(libro);
        Libro libro1 = libroDao.save(generateLibro(libro));
        return generateLibroResp(libro1);
    }

    @Override
    public LibroResp encontrarPorId(Integer id) {
        Libro libro = libroDao.findById(id).orElse(null);
        isLibroPresent(libro);
        return generateLibroResp(libro);
    }

    @Override
    public MessageDto eliminar(Integer id) {
        Libro libro = libroDao.findById(id).orElse(null);
        isLibroPresent(libro);
        libroDao.delete(libro);
        return MessageDto.builder()
                .msg("Recurso eliminado")
                .code("L-500")
                .build();
    }

    @Override
    public LibroResp editar(LibroEditReq libro) {
        validator.validateLibroEditReq(libro);
        Libro libro1 = libroDao.findById(libro.getId()).orElse(null);
        isLibroPresent(libro1);
        Autor autor = autorDao.findById(libro.getIdAutor()).orElse(null);
        isAutorPresent(autor);
        Editorial editorial = editorialDao.findById(libro.getIdEditorial()).orElse(null);
        isEditorialPresent(editorial);
        libro1.setAutor(autor);
        libro1.setEditorial(editorial);
        libro1.setEjemplares(libro.getEjemplares());
        libro1.setLibroActivo(libro.getActive());
        libro1.setTitulo(libro.getTitulo());
        return generateLibroResp(libroDao.save(libro1));
    }

    @Override
    public List<LibroResp> listarLibrosActivos() {
        List<LibroResp> resps = new ArrayList<>();
        List<Libro> libros = libroDao.encontrarLibroActivos();
        for (Libro libro : libros) {
            resps.add(generateLibroResp(libro));
        }
        return resps;
    }

    private void isLibroPresent(Libro libro) {
        if (libro == null) {
            throw new ResourceNotFoundException("El recurso no existe", "L-100");
        }
    }

    private void isAutorPresent(Autor autor) {
        if (autor == null) {
            throw new ResourceNotFoundException("El autor no existe", "L-a100");
        }
    }

    private void isEditorialPresent(Editorial libro) {
        if (libro == null) {
            throw new ResourceNotFoundException("La editorial no existe", "L-e100");
        }
    }

    private LibroResp generateLibroResp(Libro libro) {
        return LibroResp.builder()
                .id(libro.getIdLibro())
                .active(libro.getLibroActivo())
                .titulo(libro.getTitulo())
                .ejemplares(libro.getEjemplares())
                .idAutor(libro.getAutor().getIdAutor())
                .nombreAutor(libro.getAutor().getNombreAutor())
                .idEditorial(libro.getEditorial().getIdEditorial())
                .nombreEditorial(libro.getEditorial().getNombreEditorial())
                .build();
    }

    private Libro generateLibro(LibroReq req) {
        Autor autor = autorDao.findById(req.getIdAutor()).orElse(null);
        isAutorPresent(autor);
        Editorial editorial = editorialDao.findById(req.getIdEditorial()).orElse(null);
        isEditorialPresent(editorial);
        Libro libro = new Libro();
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setEjemplares(req.getEjemplares());
        libro.setLibroActivo(req.getActive());
        libro.setTitulo(req.getTitulo());
        return libro;
    }


}
