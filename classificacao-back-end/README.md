## Backend

Projeto gerado pelo [Spring Initializr](https://start.spring.io/).

## Requerimentos

Instalar: [Maven](https://maven.apache.org/install.html)

Instalar: [Java 11](https://jdk.java.net/archive/)

Caso utilizar alguma IDE [Lombok](https://projectlombok.org/).

## Start Backend

Caso utilizar o prompt de comandos do Windows:

1 - Acessar a pasta do projeto `projeto-classificacao/classificacao-back-end`, dentro dela executar o comando: `mvn clean install` para baixar as dependências do projeto.

2 - Após baixar as dependências, acessar a pasta `projeto-classificacao/classificacao-back-end/target` e executar o comando: 
`java -jar desafio-0.0.1-SNAPSHOT.jar` para executar o arquivo jar e iniciar o backend.

## Utilizando API Rest

## Empresa Service

    URL: http://localhost:8080/empresa
    Method allowed: GET
    Response:
    [
        {
            "id": 1,
            "nome": "Empresa 1",
            "pontuacao: "50.0"
        },
        {
            "id": 2,
            "name": "Empresa 2",
            "pontuacao: "50.0"
        }
    ]
    
    URL: http://localhost:8080/empresa/1
    Method allowed: GET
    Response:
    [
        {
            "id": 1,
            "nome": "Empresa 1",
            "pontuacao: "50.0"
        },
    ]
    
    URL: http://localhost:8090/company/1/computeFile
    Method allowed: POST
    Body:
    FormData
        {
          "file": importacao.json
        }
    Response:
        {
            "id": 1,
            "nome": "Empresa 1",
            "pontuacao: "50.0"
        }
    Arquivo JSON: 
        {
            "notas": 5,
            "debitos": 1
        }

