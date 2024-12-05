# Trabalho AS - CRUD de Clientes e Carros

### Grupo
- ***Cleiton Becker Pereira***
- ***Giovanna Emerim***
- ***Donisete Lumertz***

## Índice

- [Descrição do Projeto](#Descrição-do-Projeto)
- [Estrutura do Projeto](#Estrutura-do-Projeto)
- [Injeção de Dependência](#Injeção-de-Dependência)
- [Endpoints Disponíveis](#Endpoints-Disponíveis)
- [Como Executar o Projeto](#Endpoints-Disponíveis)

## Descrição do Projeto

Este projeto é um sistema de cadastro de clientes e carros desenvolvido utilizando o Spring Framework, onde permite realizar operações de CRUD (Create, Read, Update, Delete) em registros de clientes e carros, sistema é composto por três camadas principais: Controller, Service e Repository.

## Estrutura do Projeto

### Controllers
___

- **ClienteController**: Responsável por lidar com as requisições HTTP e direcioná-las para os serviços apropriados, define endpoints para obter todos os clientes, obter um cliente por ID, adicionar um novo cliente, atualizar um cliente existente e deletar um cliente.

___
 
- **CarroController**: Responsável por lidar com as requisições HTTP e direcioná-las para os serviços apropriados, define endpoints para obter todos os carros, obter um carro por ID, adicionar um novo carro, atualizar um carro existente e deletar um carro.

___

### Exceptions
___

- **ClienteNaoEncontradoException**: Exceção personalizada lançada quando um cliente não é encontrado

___

- **CarroNaoEncontradoException**: Exceção personalizada lançada quando um carro não é encontrado.

___

### Models

___

- **BaseModel**: Representa a entidade BaseModel com atributos como DataCriacao, DataAtualizacao, DataDelecao, utilizando as anotações `@MappedSuperclass`, `@Getter` e `@Setter` do Lombok.

___

- **ClientModel**: Representa a entidade Cliente com atributos como ID, Nome, Idade e Profissao, utilizando as anotações `@Entity`, `@Getter` e `@Setter` do Lombok.
 
___

- **CarroModel**: Representa a entidade Carro com atributos como ID, Modelo, Cor e Placa, utilizando as anotações `@Entity`, `@Getter` e `@Setter` do Lombok.

___

### Repositories

___

- **ClienteRepository**: Interface que estende `JpaRepository` para a entidade `ClienteModel`.

___ 

- **CarroRepository**: Interface que estende `JpaRepository` para a entidade `CarroModel`.

___

### Services

___

- **ClienteService**: Contém a lógica de negócios para operações relacionadas a clientes, como buscar todos os clientes, buscar cliente por ID, criar, atualizar e remover clientes.
___

- **CarroService**: Contém a lógica de negócios para operações relacionadas a carros, como buscar todos os carros, buscar carro por ID, criar, atualizar e remover carros.

___

## Injeção de Dependência

O projeto utiliza a anotação `@Autowired` do Spring para injeção de dependência, isso permite que o Spring resolva e injete automaticamente as dependências necessárias nos componentes, facilitando a gestão de dependências e melhorando a modularidade e testabilidade do código.

## Endpoints Disponíveis

### Clientes

- **GET /api/clientes**: Retorna todos os clientes.
- **GET /api/clientes/{id}**: Retorna um cliente pelo ID.
- **POST /api/clientes**: Adiciona um novo cliente.
- **PUT /api/clientes/{id}**: Atualiza um cliente existente.
- **DELETE /api/clientes/{id}**: Deleta um cliente pelo ID.

### Carros

- **GET /api/carros**: Retorna todos os carros.
- **GET /api/carros{id}**: Retorna um carro pelo ID.
- **POST /api/carros**: Adiciona um novo carro.
- **PUT /api/carros{id}**: Atualiza um carro existente.
- **DELETE /api/carros{id}**: Deleta um carro pelo ID.

## Como Executar o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/cleiton-bp/programacao-orientada-a-objetos-trabalho-as.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd programacao-orientada-a-objetos-trabalho-as
    ```

3. Compile e execute o projeto:
    ```bash
    
    ```

4. Acesse a aplicação em `http://localhost:5553`.