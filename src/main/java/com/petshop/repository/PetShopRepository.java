package com.petshop.repository;

import com.petshop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetShopRepository extends JpaRepository<Pet, Long> {
}
