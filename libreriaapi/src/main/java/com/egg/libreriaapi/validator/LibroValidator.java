package com.egg.libreriaapi.validator;

import com.egg.libreriaapi.exception.BadRequestException;
import com.egg.libreriaapi.exception.FieldInvalidException;
import com.egg.libreriaapi.model.request.LibroEditReq;
import com.egg.libreriaapi.model.request.LibroReq;
import org.springframework.stereotype.Service;

@Service
public class LibroValidator {

    public void validateLibroReq(LibroReq req) {
        validateNombreReq(req.getTitulo());
        validateIdAutorReq(req.getIdAutor());
        validateIdEditorialReq(req.getIdEditorial());
    }

    public void validateLibroEditReq(LibroEditReq req) {
        validateNombreReq(req.getTitulo());
        validateIdAutorReq(req.getIdAutor());
        validateIdEditorialReq(req.getIdEditorial());
        validateIdLibroReq(req.getId());
        validateEjemplares(req.getEjemplares());
    }

    private void validateNombreReq(String name) {
        if (name == null) {
            throw new FieldInvalidException("El titulo no puede ser nulo", "L-400");
        } else if (name.trim().equals("")) {
            throw new BadRequestException("Titulo es obligatorio", "La-200");
        }
    }

    private void validateIdAutorReq(String id) {
        if (id == null) {
            throw new FieldInvalidException("La id del Autor no puede ser nulo", "La-400");
        } else if (id.trim().equals("")) {
            throw new BadRequestException("Id del Autor es obligatorio", "La-200");
        }
    }

    private void validateIdEditorialReq(String id) {
        if (id == null) {
            throw new FieldInvalidException("La id de la Editorial no puede ser nulo", "La-400");
        } else if (id.trim().equals("")) {
            throw new BadRequestException("Id de la Editorial es obligatorio", "Le-200");
        }
    }

    private void validateIdLibroReq(Integer id) {
        if (id == null) {
            throw new FieldInvalidException("La id del Libro no puede ser nulo", "L-450");
        } else if (id <= 0) {
            throw new BadRequestException("Id no puede ser 0 o negativo", "L-250");
        }
    }

    private void validateEjemplares(Integer ejemplares) {
        if (ejemplares == null) {
            throw new FieldInvalidException("Los ejemplares del Libro no puede ser nulo", "L-450");
        } else if (ejemplares <= 0) {
            throw new BadRequestException("La cantidad de ejemplares no puede ser 0 o negativo", "L-250");
        }
    }
}
