package com.egg.libreriaapi.controller;

import com.egg.libreriaapi.model.request.AutorEditReq;
import com.egg.libreriaapi.model.request.AutorReq;
import com.egg.libreriaapi.model.response.AutorResp;
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
    public AutorResp saveAutor(@RequestBody AutorReq autor) {
        return autorService.agregar(autor);
    }

    @GetMapping("/{id}")
    public AutorResp findAutorPorId(@PathVariable String id) {
        return autorService.encontrarPorId(id);
    }

    @PutMapping
    public AutorResp editarAutor(@RequestBody AutorEditReq autor) {
        return autorService.editar(autor);
    }

    @GetMapping
    public List<AutorResp> getAllAutor() {
        return autorService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable String id) {
        autorService.eliminar(id);
    }
}
