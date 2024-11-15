package com.example.aula_21.controllers;

import com.example.aula_21.exceptions.CarroNaoEncontradoException;
import com.example.aula_21.models.CarroModel;
import com.example.aula_21.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    @Autowired
    private CarroService _carroService;

    @GetMapping
    public ResponseEntity<List<CarroModel>> buscarTodosCarros() {
        try {
            List<CarroModel> carros = _carroService.BuscarTodosCarros();
            return new ResponseEntity<>(carros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCarroPorId(@PathVariable long id) {
        try {
            CarroModel carro = _carroService.BuscarCarroPorId(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (CarroNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Void> adicionarCarro(@RequestBody CarroModel carro) {
        try {
            _carroService.CriarCarro(carro);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCarro(@PathVariable long id, @RequestBody CarroModel carro) {
        try {
            _carroService.AtualizarCarro(id, carro);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CarroNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno do servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCarro(@PathVariable long id) {
        try {
            _carroService.RemoverPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CarroNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno do servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
