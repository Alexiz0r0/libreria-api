package com.egg.libreriaapi.controller;

import com.egg.libreriaapi.model.dto.MessageDto;
import com.egg.libreriaapi.model.request.EditorialEditReq;
import com.egg.libreriaapi.model.request.EditorialReq;
import com.egg.libreriaapi.model.response.EditorialResp;
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
    public EditorialResp saveEditorial(@RequestBody EditorialReq editorial) {
        return editorialService.agregar(editorial);
    }

    @GetMapping("/{id}")
    public EditorialResp findEditorialById(@PathVariable String id) {
        return editorialService.encontrarPorId(id);
    }

    @PutMapping
    public EditorialResp editarEditorial(@RequestBody EditorialEditReq editorial) {
        return editorialService.editar(editorial);
    }

    @GetMapping
    public List<EditorialResp> getAllEditorial() {
        return editorialService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public MessageDto deleteAutor(@PathVariable String id) {
        return editorialService.eliminar(id);
    }

    @GetMapping("/search/{name}")
    public List<EditorialResp> getEditorialPorNombre(@PathVariable String name) {
        return editorialService.buscarPorNombre(name);
    }
}
