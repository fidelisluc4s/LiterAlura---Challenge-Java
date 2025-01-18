# LiterAlura - Catálogo de Livros

## Descrição

Neste desafio de programação, o objetivo é construir seu próprio catálogo de livros chamado **LiterAlura**. O projeto permite que os usuários interajam com o catálogo via console, oferecendo ao menos 5 opções de interação. As informações dos livros serão buscadas através de uma API, manipuladas em formato JSON, armazenadas em um banco de dados e exibidas ao usuário de maneira filtrada.

### Funcionalidades

- **Busca de Livros:** Realiza requisições à API para buscar livros.
- **Armazenamento:** Armazena dados dos livros em um banco de dados.
- **Interação via Console:** Permite que o usuário interaja com o sistema, consultando livros e autores.
- **Exibição de Resultados:** Exibe os resultados filtrados para o usuário com base nas interações realizadas.

## Objetivos

O projeto visa desenvolver um Catálogo de Livros que permita:

1. Realizar requisições à API para obter livros.
2. Manipular dados JSON recebidos da API.
3. Armazenar os livros em um banco de dados.
4. Exibir informações sobre os livros e autores aos usuários.
5. Oferecer interações no console com pelo menos 5 opções de consulta.

## Etapas do Desenvolvimento

1. **Configuração do Ambiente Java**
   - Configuração da versão do JDK e das dependências necessárias.

2. **Criação do Projeto**
   - Criação de um projeto Java utilizando o Spring Boot.

3. **Consumo da API**
   - Implementação de chamadas à API para obter dados dos livros.

4. **Análise da Resposta JSON**
   - Processamento dos dados JSON retornados pela API.

5. **Inserção e Consulta no Banco de Dados**
   - Armazenamento dos dados dos livros no banco de dados.
   - Consultas para filtrar e exibir livros e autores.

6. **Exibição de Resultados aos Usuários**
   - Implementação de opções de interação no console para exibir os livros de acordo com o interesse do usuário.

## Como Rodar

1. Clone este repositório.
2. Abra o projeto em sua IDE favorita (como IntelliJ IDEA ou Eclipse).
3. Configure as credenciais do banco de dados no arquivo `application.properties` ou `application.yml`.
4. Execute a aplicação com o comando:

   ```bash
   mvn spring-boot:run
