# 🧺 Sistema de Gerenciamento de Estoque de Camisas

Este projeto é um sistema simples para gerenciar o estoque de camisas, controlando produtos (camisas), entradas de estoque e fornecedores. Ele consiste em um **backend** desenvolvido com **Spring Boot (Java)** e um **frontend** básico em **HTML, CSS e JavaScript Vanilla** para interação.

---

## 📚 Descrição do Projeto

O sistema permite realizar operações **CRUD (Criar, Ler, Atualizar, Deletar)** para as seguintes entidades:

### 👕 Camisas
Gerencia informações sobre diferentes modelos de camisas:
- Nome
- Time
- Tamanho
- Preço
- Quantidade em estoque

### 📦 Entradas de Estoque
Registra a adição de lotes de camisas ao inventário:
- Vincula a entrada a um modelo de camisa e a um fornecedor
- Atualiza automaticamente o estoque da camisa

### 🚚 Fornecedores
Gerencia informações das empresas fornecedoras:
- Nome
- CNPJ
- Endereço

> Os relacionamentos entre as entidades são modelados de forma que cada `EntradaEstoque` referencia uma `Camisa` e um `Fornecedor`.

---

## 🛠️ Tecnologias Utilizadas

### Backend
- Java 17+
- Spring Boot 3.x
- Spring Data MongoDB
- Maven
- Lombok
- Apache Tomcat (embarcado)

### Banco de Dados
- MongoDB (NoSQL)

### Frontend
- HTML5
- CSS3
- JavaScript (ES6+)

---

## 📥 Como Clonar o Repositório

```bash
git clone <https://github.com/NiangZd/BDII.git>
cd <nome-da-pasta-do-seu-projeto>
```

## 📦 Como Instalar as Dependências

### 1. Requisitos Prévios

Certifique-se de ter instalado em sua máquina:

- **Java Development Kit (JDK) 17 ou superior**  
  Baixe em: [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) ou [OpenJDK](https://jdk.java.net)

- **Apache Maven 3.x**  
  Baixe em: [https://maven.apache.org](https://maven.apache.org)

- **MongoDB Community Server**  
  Instale a versão apropriada para seu sistema em: [MongoDB Download Center](https://www.mongodb.com/try/download/community)

> ⚠️ Certifique-se de que o serviço do MongoDB esteja rodando (porta padrão: 27017)

---

### 2. Dependências do Projeto (Maven)

Após clonar o repositório, navegue até a pasta raiz do projeto (onde está o `pom.xml`) e o Maven baixará as dependências automaticamente na primeira execução.

---

## ▶️ Como Executar o Projeto Localmente

### 1. Iniciar o Servidor MongoDB

- **Windows**: O MongoDB é normalmente iniciado como serviço automaticamente. Verifique em "Serviços" do sistema.

- **Linux/macOS**: Use um dos comandos abaixo, conforme sua instalação:

```bash
  sudo systemctl start mongod
```

ou

```bash
  brew services start mongodb-community
```

A aplicação Spring Boot está configurada para conectar ao MongoDB em `localhost:27017`, utilizando o banco de dados `camisasdb`.

---

## ▶️ Executar o Backend (Spring Boot)

Com o terminal aberto na pasta raiz do projeto (onde está o arquivo `pom.xml`), execute o seguinte comando:

```bash
mvn spring-boot:run
```

Isso irá:

- ✅ Compilar o projeto (se necessário)
- 🚀 Iniciar o servidor Spring Boot
- 🌐 Disponibilizar a aplicação em: [http://localhost:8080](http://localhost:8080)

Você verá logs no terminal indicando que a aplicação foi iniciada com sucesso.

---

## 🌐 Acessar o Frontend

Com o backend em execução, você pode acessar as interfaces do frontend diretamente no navegador. As páginas estão localizadas na pasta `src/main/resources/static` e são servidas automaticamente pelo Spring Boot.

- **🧥 Página de Camisas:**  
  [http://localhost:8080/index.html](http://localhost:8080/index.html)

- **📦 Página de Entradas de Estoque:**  
  [http://localhost:8080/entradas.html](http://localhost:8080/entradas.html)

- **🚚 Página de Fornecedores:**  
  [http://localhost:8080/fornecedores.html](http://localhost:8080/fornecedores.html)
---

## 📄 Licença

Este projeto é livre para uso **educacional ou pessoal**.  
Distribuído sob uma **licença aberta**.
