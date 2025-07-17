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

## 🗄️ Banco de Dados

A aplicação utiliza o banco de dados **MongoDB**, com três coleções:

- `camisas`
- `fornecedores`
- `entradas`

### 🔧 Configuração (MongoDB Local)

O projeto está configurado para se conectar a um servidor MongoDB local na porta **27017**, utilizando o banco de dados `camisasdb`.

Configuração no arquivo `application.properties`:
```properties
spring.application.name=bandodados
spring.data.mongodb.database=camisasdb
spring.data.mongodb.uri=mongodb://localhost:27017
server.port=8080
```

> 🔔 **Importante:** Certifique-se de que o MongoDB esteja instalado e em execução no momento da execução da aplicação.

Você pode verificar se o serviço está ativo com o comando:

### Windows:
Abra o terminal (Prompt de Comando ou PowerShell) e execute:

```bash
net start MongoDB
```

ou verifique em *Serviços* se o **"MongoDB"** está em execução.

Se não estiver, você pode iniciá-lo manualmente por lá ou reiniciar sua máquina (caso o serviço esteja configurado para iniciar automaticamente).

---

## 📥 Dados de Exemplo

Caso deseje testar a aplicação com dados prontos, você pode importar os arquivos `.json` de exemplo (fornecidos no repositório) usando os comandos abaixo:

```bash
mongoimport --db camisasdb --collection camisas --file camisas.json --jsonArray
mongoimport --db camisasdb --collection fornecedores --file fornecedores.json --jsonArray
mongoimport --db camisasdb --collection entradas --file entradas.json --jsonArray
```

Os arquivos devem estar na raiz do projeto ou você pode ajustar o caminho conforme necessário.

---

## ✅ Resumo da Configuração do Banco

- Banco utilizado: **MongoDB** local
- Banco de dados: `camisasdb`
- Configuração no `application.properties`:

```properties
spring.application.name=bandodados
spring.data.mongodb.database=camisasdb
spring.data.mongodb.uri=mongodb://localhost:27017
server.port=8080
```

MongoDB deve estar instalado e rodando localmente antes de iniciar a aplicação.

---

## 📋 Importante

- Verifique se o serviço do MongoDB está ativo antes de iniciar a aplicação.
