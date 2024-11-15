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
public class ClienteModel extends BaseModel {
    public @Id @GeneratedValue(strategy = GenerationType.AUTO) long Id;
    public String Nome;
    public int Idade;
    public String Profissao;
}
