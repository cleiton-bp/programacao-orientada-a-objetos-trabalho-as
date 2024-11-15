package com.example.aula_21.services;

import com.example.aula_21.exceptions.CarroNaoEncontradoException;
import com.example.aula_21.models.CarroModel;
import com.example.aula_21.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository _carroRepository;

    public List<CarroModel> BuscarTodosCarros() {
        return _carroRepository.findAll().stream()
                .filter(carro -> carro.getDataDelecao() == null)
                .toList();
    }

    public CarroModel BuscarCarroPorId(long id) {
        return _carroRepository.findById(id)
                .filter(carro -> carro.getDataDelecao() == null)
                .orElseThrow(() -> new CarroNaoEncontradoException("Carro não encontrado com o ID: " + id));
    }

    public void CriarCarro(CarroModel carro) {
        _carroRepository.save(carro);
    }

    public void AtualizarCarro(long id, CarroModel carroParaAtualizar) {
        CarroModel carro = _carroRepository.findById(id)
                .filter(c -> c.getDataDelecao() == null)
                .orElseThrow(() -> new CarroNaoEncontradoException("Carro não encontrado com o ID: " + id));

        carro.setCor(carroParaAtualizar.getCor());
        carro.setModelo(carroParaAtualizar.getModelo());
        carro.setPlaca(carroParaAtualizar.getPlaca());
        _carroRepository.save(carro);
    }

    public void RemoverPorId(long id) {
        CarroModel carro = _carroRepository.findById(id)
                .filter(c -> c.getDataDelecao() == null)
                .orElseThrow(() -> new CarroNaoEncontradoException("Carro não encontrado com o ID: " + id));

        carro.setDataDelecao(LocalDateTime.now());
        _carroRepository.save(carro);
    }
}
