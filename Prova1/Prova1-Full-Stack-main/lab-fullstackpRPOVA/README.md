Prova FullStack - Spring Boot 3.x
API REST para gerenciamento de Departamentos e Funcionários em memória (Java 17).

Como Executar
Abra o projeto no IntelliJ IDEA.

Aguarde o Maven sincronizar as dependências.

Execute a classe principal ProvaApplication.java.

Endpoints Principais
Departamentos:

GET /departamento — Lista departamentos (filtro opcional por nome)

GET /departamento/{id}/funcionario — Lista funcionários do departamento

Funcionários:

GET /funcionario — Lista funcionários (filtros opcionais por nome e salarioMinimo)

GET /funcionario/{id} — Busca por ID

POST /funcionario — Cadastra novo funcionário (com validações de campos e regras de negócio)

PUT /funcionario/{id} — Atualiza funcionário existente

DELETE /funcionario/{id} — Remove funcionário
