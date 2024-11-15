package com.example.aula_21.services;

import com.example.aula_21.exceptions.ClienteNaoEncontradoException;
import com.example.aula_21.models.ClienteModel;
import com.example.aula_21.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository _clienteRepository;

    public List<ClienteModel> BuscarTodosClientes() {
        return _clienteRepository.findAll().stream()
                .filter(cliente -> cliente.getDataDelecao() == null)
                .toList();
    }

    public ClienteModel BuscarClientePorId(long id) {
        return _clienteRepository.findById(id)
                .filter(cliente -> cliente.getDataDelecao() == null)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));
    }

    public void CriarCliente(ClienteModel cliente) {
        _clienteRepository.save(cliente);
    }

    public void AtualizarCliente(long id, ClienteModel clienteParaAtualizar) {
        ClienteModel cliente = _clienteRepository.findById(id)
                .filter(c -> c.getDataDelecao() == null)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));

        cliente.setNome(clienteParaAtualizar.getNome());
        cliente.setIdade(clienteParaAtualizar.getIdade());
        cliente.setProfissao(clienteParaAtualizar.getProfissao());
        _clienteRepository.save(cliente);
    }

    public void RemoverPorId(long id) {
        ClienteModel cliente = _clienteRepository.findById(id)
                .filter(c -> c.getDataDelecao() == null)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));

        cliente.setDataDelecao(LocalDateTime.now());
        _clienteRepository.save(cliente);
    }
}
