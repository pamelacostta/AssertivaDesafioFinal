
<a href="https://www.linkedin.com/in/p%C3%A2mela-costa-177bb41b3/">
<img align="right" alt="LinkedIn" src="https://img.shields.io/badge/-Pamela%20Costa-blue"/>
</a>

<a href="mailto:pameladapalmacosta.dev@gmail.com">
<img align="right" alt="E-mail" src="https://img.shields.io/badge/Email-red"/>
</a>

<br/>

### Bem-vindo(a) ao meu projeto!👋🏽

## Desafio final Assertiva | Campinas Tech Talents

O CRUD é um acrônimo de Create(Criação), Retrieve(Consulta), Update(Atualização), Delete(Deleta) realiza as 4 operações básicas usadas em Banco de dados relacionais.

O desafio era elaborar um crud de usuários, criar um menu onde o usuário ira informar qual atividade ele deseja: <br>
1 - Cadastrar <br>
2 - Procurar <br>
3 -Alterar <br>
4 - Excluir  <br> 

Criar a classe Junit para testar maior parte dos código;

Para começar a testar o projeto você tera que ter conexão ao banco de dados MySQL, atraves desse projeto você podera inserir dados no banco de dados,procurar por algum
dado que tem na tabela,listar todos od dados da tabela, atualizar lista de contato e excluir dados da tabela.

###  📑 Crie uma tabela semelhante a essa

CREATE DATABASE cadastros; <br>
USE cadastros; <br>
CREATE TABLE users( <br>
id INT AUTO_INCREMENT, <br>
name VARCHAR(45) NOT NULL, <br>
email VARCHAR(45) NOT NULL, <br>
password VARCHAR(45) NOT NULL, <br>
dtCreation DATE, <br>
PRIMARY KEY (id) <br>
); <br>
USE cadastros; <br>
SELECT * FROM cadastros;


Tecnologias usadas no projet Java 11, maven para gerenciar as dependências, junit(versão 4.13.2) para os testes e o mysql-connector-java(Versão 8.0.23). 
deixarei o download abaixo ↓

###  ✅Tecnologias usadas para realizar o projeto
As seguintes ferramentas foram usadas na construção do projeto:

- [Java](https://www.java.com/pt-BR/)
- [MySql](https://dev.mysql.com/downloads/)
- [JUnit](https://junit.org/junit5/)
- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/)   


## Criei dois pacotes(package) 
### 👉Package domin
- Contém a class User
    - Na classe User temos os atributos que serão trabalhados na classe UserService.
    
### 👉Package service
- Contém a class UserService
    - Onde criei o crud fazendo conexão com o banco de dados.

### 👉Class Main
Class Main para rodar o projeto

Na parte de test criei um test para cada funcionalidade conforme vou estudando e aprendendo vou aprimorando eles.






