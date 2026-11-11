# Sistema de Gerenciamento de Chamados de Suporte Técnico (Support API)

## 🛠️ Tecnologias Utilizadas
- Java 21
- Spring Boot
- Maven

---

## 🔬 1. Análise Técnica 

### - Como o Spring Boot recebe e processa requisições HTTP?
O Spring Boot utiliza o ecossistema Spring MVC. Quando uma requisição HTTP chega ao servidor embutido (no caso deste trabalho, o Tomcat), o DispatcherServlet intercepta a chamada, analisa a URL e o método HTTP (GET, POST, etc.) e a direciona para o método correspondente mapeado na classe `ChamadoRestController` através de anotações como `@GetMapping`, `@PostMapping`, entre outras.

### - Qual é a função do Controller na aplicação?
O `Controller` atua como a camada de entrada (interface) da API. A responsabilidade dele é receber as requisições HTTP enviadas pelo cliente, extrair os parâmetros ou o corpo da requisição, acionar a lógica de negócio (repositório) correspondente e retornar a resposta adequada encapsulada em um objeto `ResponseEntity` (com os status HTTP corretos, como 200, 201 ou 404).

### - Como ocorre a conversão entre objetos Java e JSON?
Essa conversão é feita automaticamente por uma biblioteca integrada ao Spring Boot chamada **Jackson**. Quando a API retorna um objeto Java em um método REST, o Jackson transforma esse objeto em uma string JSON. Inversamente, quando chega um `POST` com um JSON no corpo (`@RequestBody`), o Jackson converte esse JSON em uma instância da classe Java correspondente (ex: a classe `Chamado`).

### - Por que os chamados cadastrados não permanecem armazenados após reiniciar a aplicação?
Porque os dados estão sendo armazenados exclusivamente em memória RAM (utilizando a `List<Chamado>` para simular um banco de dados). Como os dados não são enviados para um banco de dados real, quando o processo da aplicação é encerrado ou reiniciado, todo o conteúdo da lista é apagado e o sistema retorna ao estado inicial (com apenas os 10 chamados fictícios cadastrados no construtor).

---

## 🧪 2. Evidências de Testes (Demonstração das 8 Requisições)

### Teste 1: Listar todos os chamados
* **Requisição:** `GET /chamados`
* **Resposta HTTP:** `200 OK` (PRINT)
* **Explicação:** Retorna a lista completa contendo os chamados iniciais cadastrados em memória.

### Teste 2: Consultar chamado por ID (Sucesso)
* **Requisição:** `GET /chamados/1`
* **Resposta HTTP:** `200 OK` (PRINT)
* **Explicação:** Busca e retorna o chamado específico cujo ID seja igual a 1.

### Teste 3: Consultar chamado por ID (Sem correspondência / Não encontrado)
* **Requisição:** `GET /chamados/999`
* **Resposta HTTP:** `404 Not Found` (PRINT)
* **Explicação:** Demonstra o comportamento da API quando é buscado um ID que não existe na lista em memória.

### Teste 4: Filtrar chamados por setor
* **Requisição:** `GET /chamados/setor?nome=financeiro`
* **Resposta HTTP:** `200 OK` (PRINT)
* **Explicação:** Utiliza Streams do Java para filtrar e retornar apenas os chamados pertencentes ao setor financeiro (case-insensitive).

### Teste 5: Filtrar chamados por prioridade
* **Requisição:** `GET /chamados/prioridade?nivel=ALTA`
* **Resposta HTTP:** `200 OK` (PRINT)
* **Explicação:** Filtra os registros comparando o nível de prioridade informado na query string.

### Teste 6: Buscar chamados por termo no título
* **Requisição:** `GET /chamados/busca?texto=impressora`
* **Resposta HTTP:** `200 OK` (PRINT)
* **Explicação:** Realiza uma busca textual parcial e case-insensitive nos títulos dos chamados.

### Teste 7: Listar chamados críticos (Alta prioridade e não resolvidos)
* **Requisição:** `GET /chamados/criticos`
* **Resposta HTTP:** `200 OK` (PRINT)
* **Explicação:** Aplica uma regra de negócio combinada usando múltiplos filtros (prioridade ALTA + status diferente de RESOLVIDO).

### Teste 8: Cadastrar um novo chamado
* **Requisição:** `POST /chamados`
(PRINT)