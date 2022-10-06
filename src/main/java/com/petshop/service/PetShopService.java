package com.petshop.service;

import com.petshop.exeption.PetNaoEncontradoException;
import com.petshop.model.Pet;
import com.petshop.repository.PetShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetShopService {
    @Autowired
    private PetShopRepository repository;

    public void salvar(Pet petShop) {
        repository.save(petShop);
    }

    public List<Pet> findAll() {
        return repository.findAll();
    }

    public Pet findById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Long id, Pet pet) {
        Optional<Pet> res = repository.findById(id);
        if (res.isPresent()) {
            Pet petDb = res.get();
            petDb.setPet(pet.getPet());
            petDb.setEspecie(petDb.getEspecie());
            petDb.setRaça(petDb.getRaça());
            petDb.setTutor(petDb.getTutor());

            repository.save(petDb);
        } else {
            throw new PetNaoEncontradoException();
        }

    }
}
