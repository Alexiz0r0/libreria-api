package com.egg.libreriaapi.controller;

import com.egg.libreriaapi.model.dto.MessageDto;
import com.egg.libreriaapi.model.request.LibroEditReq;
import com.egg.libreriaapi.model.request.LibroReq;
import com.egg.libreriaapi.model.response.LibroResp;
import com.egg.libreriaapi.service.ILibro;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
@CrossOrigin
public class LibroController {

    private final ILibro libroService;

    @PostMapping
    public LibroResp saveLibro(@RequestBody LibroReq libroReq) {
        return libroService.agregar(libroReq);
    }

    @GetMapping("/{id}")
    public LibroResp findLibroById(@PathVariable Integer id) {
        return libroService.encontrarPorId(id);
    }

    @PutMapping
    public LibroResp editarLibro(@RequestBody LibroEditReq libroEditReq) {
        return libroService.editar(libroEditReq);
    }

    @GetMapping
    public List<LibroResp> getAllLibro() {
        return libroService.listarTodos();
    }

    @DeleteMapping({"/{id}"})
    public MessageDto deleteLibto(@PathVariable Integer id) {
        return libroService.eliminar(id);
    }

    @GetMapping("/active")
    public List<LibroResp> getAllActiveLibro() {
        return libroService.listarLibrosActivos();
    }

}
