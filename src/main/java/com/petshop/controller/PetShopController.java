package com.petshop.controller;

import com.petshop.model.Pet;
import com.petshop.service.PetShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/petshop")
@CrossOrigin
public class PetShopController {
    @Autowired
    private PetShopService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Pet petShop) {
        service.salvar(petShop);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pet> finAll() {
        return service.findAll();
    }

    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pet findById(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestParam("id") Long id, @RequestBody Pet pet) {
        service.atualizar(id, pet);
    }
}
