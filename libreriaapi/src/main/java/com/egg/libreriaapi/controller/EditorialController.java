package com.egg.libreriaapi.controller;

import com.egg.libreriaapi.entity.Editorial;
import com.egg.libreriaapi.service.IEditorial;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
@RequiredArgsConstructor
@CrossOrigin
public class EditorialController {

    private final IEditorial editorialService;

    @PostMapping
    public Editorial saveEditorial(@RequestBody Editorial editorial) {
        return editorialService.agregar(editorial);
    }

    @GetMapping("/{id}")
    public Editorial findEditorialById(@PathVariable String id) {
        return editorialService.encontrarPorId(id);
    }

    @PutMapping
    public Editorial editarEditorial(@RequestBody Editorial editorial) {
        return editorialService.editar(editorial);
    }

    @GetMapping
    public List<Editorial> getAllEditorial() {
        return editorialService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable String id) {
        editorialService.eliminar(id);
    }
}
