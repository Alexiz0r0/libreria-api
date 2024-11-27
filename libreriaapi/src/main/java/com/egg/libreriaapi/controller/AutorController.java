package com.egg.libreriaapi.controller;

import com.egg.libreriaapi.entity.Autor;
import com.egg.libreriaapi.service.IAutor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
@CrossOrigin
public class AutorController {

    private final IAutor autorService;

    @PostMapping
    public Autor saveAutor(@RequestBody Autor autor) {
        return autorService.agregar(autor);
    }

    @GetMapping("/{id}")
    public Autor findAutorPorId(@PathVariable String id){
        return autorService.encontrarPorId(id);
    }

    @PutMapping
    public Autor editarAutor(@RequestBody Autor autor) {
        return autorService.editar(autor);
    }

    @GetMapping
    public List<Autor> getAllAutor(){
        return autorService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable String id){
        autorService.eliminar(id);
    }
}
