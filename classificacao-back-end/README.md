## Backend

Projeto gerado pelo [Spring Initializr](https://start.spring.io/).

## Requerimentos

Instalar: [Maven](https://maven.apache.org/install.html)

Instalar: [Java 11](https://jdk.java.net/archive/)

Obs: Verificar variaveis de ambiente da instalação dos requerimentos, para não dar problema na execução dos proximos passos.

Executar no prompt de comandos do Windows o comando: `mvn -version` para verificar se a instação está correta, img a baixo:

![alt text](https://raw.githubusercontent.com/lucaspvanderlinde/projeto-classificacao/master/cmd.png)

Caso for utilizar alguma IDE instalar a biblioteca [Lombok](https://projectlombok.org/).

## Start Backend

Executando pelo prompt de comandos do Windows:

1 - Acessar a pasta do projeto `projeto-classificacao/classificacao-back-end`, dentro dela executar o comando: `mvn clean install` para baixar as dependências do projeto.

2 - Após baixar as dependências, acessar a pasta `projeto-classificacao/classificacao-back-end/target` e executar o comando: 
`java -jar desafio-0.0.1-SNAPSHOT.jar` para executar o arquivo jar e iniciar o backend.

3 - Seguir passo-a-passo para instalar o [Frontend](https://github.com/lucaspvanderlinde/projeto-classificacao/blob/master/classificacao-front-end/README.md)

# Banco de dados utilizado

PostgresSQL [ElephantSQL](https://www.elephantsql.com/).

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
    
    URL: http://localhost:8080/empresa/1/importacao
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

