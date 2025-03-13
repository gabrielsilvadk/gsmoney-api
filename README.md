# GSMoney API

GSMoney API é uma aplicação de exemplo desenvolvida com Spring Boot para gerenciar categorias e pessoas. Esta aplicação demonstra o uso de várias tecnologias e padrões de desenvolvimento modernos.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para a construção da aplicação.
- **Spring Data JPA**: Para persistência de dados.
- **Spring Web**: Para criação de APIs RESTful.
- **Flyway**: Para migração de banco de dados.
- **MySQL**: Banco de dados relacional.
- **Jakarta Validation**: Para validação de dados.
- **Spring Boot DevTools**: Ferramenta para facilitar o desenvolvimento.
- **Spring Boot Test**: Para testes unitários e de integração.

## Padrões de Desenvolvimento Aplicados

- **Injeção de Dependência**: Utilização do padrão de injeção de dependência do Spring para gerenciar beans e suas dependências.
- **Padrão REST**: Criação de APIs seguindo os princípios RESTful.
- **Tratamento de Exceções**: Utilização de um handler global para tratar exceções específicas e retornar respostas apropriadas.
- **Eventos e Listeners**: Utilização do padrão de eventos do Spring para publicar e ouvir eventos.
- **Validação de Dados**: Utilização de anotações de validação para garantir a integridade dos dados recebidos nas requisições.

## Estrutura do Projeto

- **Model**: Contém as entidades JPA.
- **Repository**: Contém os repositórios JPA.
- **Service**: Contém a lógica de negócios.
- **Resource**: Contém os controladores REST.
- **ExceptionHandler**: Contém o handler global para tratamento de exceções.

## Endpoints

### Categorias

- **GET /categorias**: Lista todas as categorias.
- **POST /categorias**: Cria uma nova categoria.
- **GET /categorias/{codigo}**: Busca uma categoria pelo código.

### Pessoas

- **PUT /pessoas/{codigo}**: Atualiza uma pessoa.
- **PUT /pessoas/{codigo}/ativo**: Atualiza o status ativo de uma pessoa.

## Como Executar

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/gsmoney-api.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd gsmoney-api
    ```

3. Configure o banco de dados MySQL no arquivo `application.properties`.

4. Execute a aplicação:
    ```sh
    ./mvnw spring-boot:run
    ```

## Testes

Para executar os testes, utilize o comando:
```sh
./mvnw test