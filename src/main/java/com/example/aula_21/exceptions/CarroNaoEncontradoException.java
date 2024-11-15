package com.example.aula_21.exceptions;


public class CarroNaoEncontradoException extends RuntimeException {
  public CarroNaoEncontradoException(String mensagem) {
    super(mensagem);
  }
}