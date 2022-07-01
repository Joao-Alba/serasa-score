# SerasaScore
Programa criado para o Desafio Serasa Experian – Nível 1

A API conta com cadastro e consulta de pessoas

Programa construido em Java 11, utilizando: Maven, banco em memória H2 e Hibernate, com JUnit e Mockito para testes.

# Requisição para cadastro
POST /pessoa
```json
{
    "nome":"Fulano de Tal",
    "telefone":"99 99999-9999",
    "idade":99,
    "cidade":"Cidade de Fulano",
    "estado":"XX",
    "score":1000 // Entre 0 e 1000
}
```

# Requisição para retornar pessoa por id
GET /pessoa/{id}

# Requisição para retornar todas as pessoas
GET /pessoa

