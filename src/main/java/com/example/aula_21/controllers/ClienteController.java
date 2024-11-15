package com.example.aula_21.controllers;

import com.example.aula_21.exceptions.ClienteNaoEncontradoException;
import com.example.aula_21.models.ClienteModel;
import com.example.aula_21.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService _clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteModel>> buscarTodosClientes() {
        try {
            List<ClienteModel> clientes = _clienteService.BuscarTodosClientes();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarClientePorId(@PathVariable long id) {
        try {
            ClienteModel cliente = _clienteService.BuscarClientePorId(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (ClienteNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Void> adicionarCliente(@RequestBody ClienteModel cliente) {
        try {
            _clienteService.CriarCliente(cliente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable long id, @RequestBody ClienteModel cliente) {
        try {
            _clienteService.AtualizarCliente(id, cliente);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ClienteNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno do servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable long id) {
        try {
            _clienteService.RemoverPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ClienteNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno do servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
