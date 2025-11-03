# Exemplos de Uso da API - Disciplinas

## 📋 Base URL
```
http://localhost:8080
```

## 🔍 Endpoints

### 1. Listar Todas as Disciplinas

**Request:**
```http
GET /api/disciplinas HTTP/1.1
Host: localhost:8080
```

**cURL:**
```bash
curl http://localhost:8080/api/disciplinas
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "Desenvolvimento Web I",
    "cargaHoraria": 80,
    "professor": "Prof. João Silva"
  },
  {
    "id": 2,
    "nome": "Banco de Dados",
    "cargaHoraria": 80,
    "professor": "Prof. Maria Santos"
  }
]
```

---

### 2. Buscar Disciplina por ID (Existente)

**Request:**
```http
GET /api/disciplinas/1 HTTP/1.1
Host: localhost:8080
```

**cURL:**
```bash
curl http://localhost:8080/api/disciplinas/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "nome": "Desenvolvimento Web I",
  "cargaHoraria": 80,
  "professor": "Prof. João Silva"
}
```

---

### 3. Buscar Disciplina por ID (Inexistente)

**Request:**
```http
GET /api/disciplinas/999 HTTP/1.1
Host: localhost:8080
```

**cURL:**
```bash
curl http://localhost:8080/api/disciplinas/999
```

**Response (404 Not Found):**
```
(corpo vazio)
```

---

### 4. Criar Nova Disciplina

**Request:**
```http
POST /api/disciplinas HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "nome": "Programação Orientada a Objetos",
  "cargaHoraria": 80,
  "professor": "Prof. Carlos Oliveira"
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/api/disciplinas \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Programação Orientada a Objetos",
    "cargaHoraria": 80,
    "professor": "Prof. Carlos Oliveira"
  }'
```

**Response (201 Created):**
```json
{
  "id": 3,
  "nome": "Programação Orientada a Objetos",
  "cargaHoraria": 80,
  "professor": "Prof. Carlos Oliveira"
}
```

---

## 🧪 Exemplos de Teste com PowerShell

### Listar Todas
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/disciplinas" -Method Get
```

### Buscar por ID
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/disciplinas/1" -Method Get
```

### Criar Nova Disciplina
```powershell
$body = @{
    nome = "Engenharia de Software"
    cargaHoraria = 80
    professor = "Prof. Ana Costa"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api/disciplinas" `
                  -Method Post `
                  -Body $body `
                  -ContentType "application/json"
```

---

## 🧪 Exemplos com Postman

### Collection JSON

```json
{
  "info": {
    "name": "API Disciplinas",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Listar Todas as Disciplinas",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/api/disciplinas",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "disciplinas"]
        }
      }
    },
    {
      "name": "Buscar Disciplina por ID",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/api/disciplinas/1",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "disciplinas", "1"]
        }
      }
    },
    {
      "name": "Criar Nova Disciplina",
      "request": {
        "method": "POST",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nome\": \"Programação Orientada a Objetos\",\n  \"cargaHoraria\": 80,\n  \"professor\": \"Prof. Carlos Oliveira\"\n}"
        },
        "url": {
          "raw": "http://localhost:8080/api/disciplinas",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "disciplinas"]
        }
      }
    }
  ]
}
```

---

## 🌐 Swagger UI

A forma mais fácil de testar é usando o Swagger UI integrado:

1. Inicie a aplicação: `.\mvnw.cmd spring-boot:run`
2. Acesse: http://localhost:8080/swagger-ui.html
3. Expanda os endpoints
4. Clique em "Try it out"
5. Preencha os parâmetros (se necessário)
6. Clique em "Execute"

---

## 📝 Exemplos de Disciplinas para Cadastro

### Disciplina 1
```json
{
  "nome": "Programação Orientada a Objetos",
  "cargaHoraria": 80,
  "professor": "Prof. Carlos Oliveira"
}
```

### Disciplina 2
```json
{
  "nome": "Engenharia de Software",
  "cargaHoraria": 80,
  "professor": "Prof. Ana Costa"
}
```

### Disciplina 3
```json
{
  "nome": "Estrutura de Dados",
  "cargaHoraria": 80,
  "professor": "Prof. Pedro Santos"
}
```

### Disciplina 4
```json
{
  "nome": "Desenvolvimento Mobile",
  "cargaHoraria": 80,
  "professor": "Prof. Laura Mendes"
}
```

### Disciplina 5
```json
{
  "nome": "Inteligência Artificial",
  "cargaHoraria": 80,
  "professor": "Prof. Roberto Lima"
}
```

---

## 🐛 Tratamento de Erros

### Endpoint não encontrado
**Request:** `GET /api/disciplina` (sem o 's')  
**Response:** `404 Not Found`

### Disciplina não encontrada
**Request:** `GET /api/disciplinas/9999`  
**Response:** `404 Not Found`

### Erro de formato JSON
**Request:** `POST /api/disciplinas` com JSON inválido  
**Response:** `400 Bad Request`

---

## 💡 Dicas

1. **Content-Type**: Sempre use `Content-Type: application/json` nas requisições POST
2. **IDs**: São gerados automaticamente pelo sistema (sequencial)
3. **Persistência**: Os dados ficam em memória (HashMap), reiniciar a aplicação limpa os dados
4. **Disciplinas Iniciais**: O sistema sempre inicia com 2 disciplinas pré-cadastradas
