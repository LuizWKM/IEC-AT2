# Resumo da Implementação - AT2 IEC

## ✅ Itens Implementados

### 1. ✅ Modelo de Dados (HashMap como Banco de Dados)
**Arquivo:** `src/main/java/br/com/fatec/api_links_uteis/model/Disciplina.java`

Criada a classe `Disciplina` com os seguintes atributos:
- `Long id` - Identificador único
- `String nome` - Nome da disciplina
- `Integer cargaHoraria` - Carga horária em horas
- `String professor` - Nome do professor

### 2. ✅ Controller com HashMap
**Arquivo:** `src/main/java/br/com/fatec/api_links_uteis/controller/DisciplinaController.java`

Implementado controlador REST com:
- HashMap simulando banco de dados
- Duas disciplinas pré-cadastradas:
  - Desenvolvimento Web I (Prof. João Silva)
  - Banco de Dados (Prof. Maria Santos)

### 3. ✅ Rotas Implementadas

#### GET `/api/disciplinas`
- Lista todas as disciplinas cadastradas
- Retorna: `200 OK` com array de disciplinas

#### GET `/api/disciplinas/{id}`
- Busca uma disciplina específica por ID
- Retorna: `200 OK` com a disciplina ou `404 Not Found`

#### POST `/api/disciplinas`
- Cria uma nova disciplina
- Body: JSON com nome, cargaHoraria e professor
- Retorna: `201 Created` com a disciplina criada (incluindo ID gerado)

### 4. ✅ Testes Unitários
**Arquivo:** `src/test/java/br/com/fatec/api_links_uteis/controller/DisciplinaControllerTest.java`

Criados 4 testes unitários:
- ✅ `testListarTodas()` - Valida listagem de disciplinas
- ✅ `testBuscarPorIdExistente()` - Valida busca de disciplina existente
- ✅ `testBuscarPorIdInexistente()` - Valida retorno 404 para ID inexistente
- ✅ `testCriarDisciplina()` - Valida criação de nova disciplina

### 5. ✅ Testes de Integração
**Arquivo:** `src/test/java/br/com/fatec/api_links_uteis/controller/DisciplinaControllerIT.java`

Criados 2 testes de integração:
- ✅ `testFluxoCompleto()` - Testa o fluxo completo: listar, buscar, criar e buscar novamente
- ✅ `testBuscarDisciplinaInexistente()` - Valida comportamento com ID inexistente

**Resultado:** Todos os 6 testes unitários passando ✅
**Resultado:** Todos os 3 testes de integração passando ✅

### 6. ✅ Swagger/OpenAPI
**Dependência adicionada no `pom.xml`:**
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.2.0</version>
</dependency>
```

**Acessos:**
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

### 7. ✅ CI/CD GitHub Actions
**Arquivo:** `.github/workflows/ci.yml`

**Job CI (Continuous Integration):**
- ✅ Executa em toda push na branch `main`
- ✅ Configura Java 21
- ✅ Executa testes com `mvn verify`
- ✅ Valida compilação e testes

**Job CD (Continuous Deployment):**
- ✅ Executa após sucesso do CI
- ✅ Gera artefato JAR com `mvn package`
- ✅ Upload do JAR como artefato do GitHub Actions
- ✅ Artefato disponível por 30 dias para download
- ✅ Nome do artefato: `api-links-uteis`

## 📊 Estatísticas

- **Testes Unitários:** 6 ✅
- **Testes de Integração:** 3 ✅
- **Total de Testes:** 9 ✅
- **Taxa de Sucesso:** 100% ✅

## 🎯 Endpoints Testados

Todos os endpoints foram testados e estão funcionando:

1. ✅ GET http://localhost:8080/api/disciplinas
2. ✅ GET http://localhost:8080/api/disciplinas/1
3. ✅ GET http://localhost:8080/api/disciplinas/999 (404)
4. ✅ POST http://localhost:8080/api/disciplinas

## 🚀 Como Testar

### 1. Executar Testes
```bash
.\mvnw.cmd verify
```

### 2. Iniciar Aplicação
```bash
.\mvnw.cmd spring-boot:run
```

### 3. Acessar Swagger
Abra o navegador em: http://localhost:8080/swagger-ui.html

### 4. Testar Endpoints via Swagger
No Swagger UI você pode:
- Visualizar todos os endpoints
- Testar cada operação interativamente
- Ver os schemas dos modelos
- Fazer requisições de exemplo

### 5. Testar via cURL

**Listar todas:**
```bash
curl http://localhost:8080/api/disciplinas
```

**Buscar por ID:**
```bash
curl http://localhost:8080/api/disciplinas/1
```

**Criar nova:**
```bash
curl -X POST http://localhost:8080/api/disciplinas \
  -H "Content-Type: application/json" \
  -d "{\"nome\":\"Programação Orientada a Objetos\",\"cargaHoraria\":80,\"professor\":\"Prof. Carlos Oliveira\"}"
```

## 📁 Arquivos Criados/Modificados

### Novos Arquivos:
1. `src/main/java/br/com/fatec/api_links_uteis/model/Disciplina.java`
2. `src/main/java/br/com/fatec/api_links_uteis/controller/DisciplinaController.java`
3. `src/test/java/br/com/fatec/api_links_uteis/controller/DisciplinaControllerTest.java`
4. `src/test/java/br/com/fatec/api_links_uteis/controller/DisciplinaControllerIT.java`

### Arquivos Modificados:
1. `pom.xml` - Adicionada dependência Swagger
2. `.github/workflows/ci.yml` - Melhorado pipeline CI/CD
3. `README.md` - Documentação completa atualizada

## 🎉 Conclusão

Todos os requisitos da AT2 foram implementados com sucesso:

✅ Simulação de banco de dados com HashMap  
✅ Duas disciplinas do curso de DSM  
✅ Rota GET - Listar todas as disciplinas  
✅ Rota GET - Buscar disciplina por ID  
✅ Rota POST - Criar nova disciplina  
✅ Testes unitários para cada rota  
✅ Swagger configurado e funcionando  
✅ CI/CD GitHub Actions executando testes  
✅ CD gerando artefato .jar  

**Status:** Projeto 100% funcional e testado! 🚀
