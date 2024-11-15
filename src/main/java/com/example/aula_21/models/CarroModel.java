package com.example.aula_21.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CarroModel extends BaseModel {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) long Id;
    private String modelo;
    private String cor;
    private String placa;
}