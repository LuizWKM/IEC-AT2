# API Links Úteis - Catálogo de Disciplinas DSM

Sistema de catálogo de disciplinas do curso de Desenvolvimento de Software Multiplataforma (DSM) implementado com Spring Boot.

## 📋 Funcionalidades

- ✅ Simulação de banco de dados com HashMap
- ✅ API REST com operações CRUD
- ✅ Documentação interativa com Swagger
- ✅ Testes unitários e de integração
- ✅ CI/CD com GitHub Actions

## 🚀 Tecnologias

- **Java 21**
- **Spring Boot 3.5.6**
- **Maven**
- **SpringDoc OpenAPI (Swagger)**
- **JUnit 5**
- **GitHub Actions**

## 📡 Endpoints da API

### Disciplinas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/disciplinas` | Lista todas as disciplinas |
| GET | `/api/disciplinas/{id}` | Busca uma disciplina por ID |
| POST | `/api/disciplinas` | Cria uma nova disciplina |

### Exemplo de Requisição POST

```json
{
  "nome": "Programação Orientada a Objetos",
  "cargaHoraria": 80,
  "professor": "Prof. Carlos Oliveira"
}
```

## 🏃 Como Executar

### Pré-requisitos

- Java 21 ou superior
- Maven (ou use o wrapper incluído: `./mvnw` ou `mvnw.cmd`)

### Executar a aplicação

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Documentação Swagger

Após iniciar a aplicação, acesse a documentação interativa:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Docs (JSON)**: http://localhost:8080/v3/api-docs

## 🧪 Executar Testes

### Testes Unitários

```bash
# Windows
.\mvnw.cmd test

# Linux/Mac
./mvnw test
```

### Testes de Integração

```bash
# Windows
.\mvnw.cmd verify

# Linux/Mac
./mvnw verify
```

## 📦 Gerar Artefato JAR

```bash
# Windows
.\mvnw.cmd clean package

# Linux/Mac
./mvnw clean package
```

O arquivo JAR será gerado em: `target/api-links-uteis-0.0.1-SNAPSHOT.jar`

Para executar o JAR:

```bash
java -jar target/api-links-uteis-0.0.1-SNAPSHOT.jar
```

## 🔄 CI/CD

O projeto possui pipeline automatizado no GitHub Actions que:

1. **CI (Continuous Integration)**:
   - Executa todos os testes unitários e de integração
   - Verifica a compilação do projeto

2. **CD (Continuous Deployment)**:
   - Gera o artefato JAR
   - Faz upload do artefato para download
   - Artefato fica disponível por 30 dias

O pipeline é executado automaticamente a cada push na branch `main`.

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/com/fatec/api_links_uteis/
│   │       ├── ApiLinksUteisApplication.java
│   │       ├── controller/
│   │       │   ├── DisciplinaController.java
│   │       │   └── returnNameController.java
│   │       └── model/
│   │           └── Disciplina.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── br/com/fatec/api_links_uteis/
            ├── ApiLinksUteisApplicationTests.java
            └── controller/
                ├── DisciplinaControllerTest.java
                ├── DisciplinaControllerIT.java
                ├── returnNameControllerTest.java
                └── returnNameControllerIT.java
```

## 📝 Dados Iniciais

O sistema já vem pré-populado com duas disciplinas:

1. **Desenvolvimento Web I**
   - Carga Horária: 80h
   - Professor: Prof. João Silva

2. **Banco de Dados**
   - Carga Horária: 80h
   - Professor: Prof. Maria Santos

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença especificada no arquivo LICENSE.

## 👥 Autores

Desenvolvido como parte do curso de Desenvolvimento de Software Multiplataforma - FATEC.
