# Person REST API

Person REST API  1.0.0<br>
Spring boot REST API for people management.

A API de gerenciamento de pessoas é uma aplicação web construída com Spring Boot que permite criar, atualizar, listar e excluir informações de pessoas, bem como seus endereços. A API tem como objetivo prover um serviço de gestão de dados de pessoas e endereços.

___

Recursos disponíveis

A API disponibiliza as seguintes funcionalidades:

Listagem de todas as pessoas cadastradas;<br>
Busca de uma pessoa por ID;<br>
Criação de uma nova pessoa;<br>
Atualização de uma pessoa existente;<br>
Exclusão de uma pessoa existente;<br>
Listagem de todos os endereços de uma pessoa;<br>
Criação de um novo endereço para uma pessoa;<br>
Atualização de um endereço de uma pessoa;<br>
Definição de um endereço como principal para uma pessoa;<br>



Endpoints

Os endpoints disponíveis na API são:

GET /person - Lista todas as pessoas cadastradas;<br>
GET /person/{personId} - Busca uma pessoa por ID;<br>
POST /person - Cria uma nova pessoa;<br>
PUT /person/{personId} - Atualiza uma pessoa existente;<br>
DELETE /person/{personId} - Exclui uma pessoa existente;<br>
GET /person/{personId}/addresses - Lista todos os endereços de uma pessoa;<br>
PATCH /person/{personId}- Cria um novo endereço para uma pessoa;<br>

Formato de dados

A API recebe e retorna dados em formato JSON.

Exemplo de objeto Pessoa com o Endereço:
```
{
"id": 1,
"name": "Fulano de Tal",
"birthDate": "1980-01-01",
"addresses": [
{
"id": 1,
"street": "Rua A",
"number": 123,
"city": "São Paulo",
"zipCode": "01001-000",
"main": true
},
{
"id": 2,
"street": "Rua B",
"number": 456,
"city": "São Paulo",
"zipCode": "02002-000",
"main": false
}
]
}
```

A API de gerenciamento de pessoas é uma solução completa para o gerenciamento de dados de pessoas e endereços. Através dela, é possível criar, atualizar, listar e excluir informações de pessoas e seus respectivos endereços de maneira fácil e eficiente.
