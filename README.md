# Gestão de Funcionários

Este é um projeto de gerenciamento de funcionários desenvolvido em Java utilizando Spring Boot. O objetivo deste sistema é fornecer uma solução eficaz para gerenciar informações de funcionários de uma empresa.

## Funcionalidades

- **CRUD de Funcionários:** 
  - Adição de novos funcionários com informações como nome, sobrenome, e-mail, telefone, e data de contratação.
  - Edição de informações de funcionários existentes.
  - Remoção de funcionários do sistema.
  - Visualização de lista completa de funcionários com detalhes.
- **Autenticação e Autorização:** 
  - Implementação de segurança utilizando Spring Security.
  - Autenticação baseada em JWT.
- **Documentação da API:**
  - Utilização do Swagger para geração automática da documentação da API.
- **Validação de Dados:**
  - Validação de dados de entrada utilizando Bean Validation (JSR 380).
- **Métricas e Monitoramento:**
  - Integração com Spring Boot Actuator para monitoramento da aplicação.

## Tecnologias Utilizadas

- **Linguagem de Programação:**
  - Java 22
- **Frameworks e Bibliotecas:**
  - Spring Boot 2.7
  - Spring Data JPA
  - Spring Security
  - Swagger (Springdoc OpenAPI)
  - Lombok
- **Banco de Dados:**
  - MySQL
- **Ferramentas de Construção:**
  - Maven
- **Outras Ferramentas:**
  - Docker (para ambiente de desenvolvimento e produção)
  - Git (para controle de versão)

## Estrutura do Projeto

O projeto segue a estrutura de diretórios padrão do Spring Boot:

gestao-funcionarios/
│
├── src/
│ ├── main/
│ │ ├── java/com/projeto/gestao/
│ │ │ ├── config/ # Classes de configuração (Spring Security, Swagger)
│ │ │ ├── controller/ # Controllers da API
│ │ │ ├── model/ # Entidades JPA
│ │ │ ├── repository/ # Repositórios JPA
│ │ │ ├── service/ # Serviços contendo a lógica de negócios
│ │ ├── resources/
│ │ │ ├── application.properties # Arquivo de configuração da aplicação
│ ├── test/ # Testes unitários e de integração
│
├── pom.xml # Arquivo de configuração do Maven
└── README.md # Descrição do projeto

