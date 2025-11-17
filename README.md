# 📘 SkillUp SOA API  
Microserviço desenvolvido para a disciplina **SOA & Web Services (FIAP)**, fazendo parte da plataforma SkillUp.  
O serviço permite **cadastro de usuários**, **login com JWT** e **listagem protegida**.

---

## 👥 Integrantes  
- João Pedro Do Vale Cruz Novo — RM 98650  
- Victor Eid Carbutti Nicolas — RM 98668  
- Tiago Rafael Paulino Ferreira — RM 551169  

---

## 🚀 Tecnologias  
- Java 21  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- JWT (JSON Web Token)  
- MySQL  
- Maven  

---

## 🗄️ Banco de Dados  
Banco utilizado: **MySQL**  
Criação do banco:

sql
CREATE DATABASE skillup_soa_db;

---

## 🔐 Autenticação
Após o login, o sistema retorna um token JWT, que deve ser enviado no header para acessar rotas protegidas.

---

## ✔ Status
- Cadastro funcionando
- Login com JWT funcionando
- Rota protegida funcionando
- Validações OK
- Banco conectado
