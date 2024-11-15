package com.example.aula_21.repositories;

import com.example.aula_21.models.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroModel, Long> {

}
