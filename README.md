# 🚀 Enterprise Management API (V2 - Refactored)

Esta é uma API REST corporativa desenvolvida com **Java 17** e **Spring Boot 3**. O projeto foi refatorado para implementar padrões de mercado que garantem segurança, performance e separação de responsabilidades.

## 🛠️ Novas Implementações Técnicas
Nesta versão, foquei em transformar um CRUD básico em um sistema de nível profissional, aplicando:

* **Padrão DTO (Data Transfer Object):** Utilização de `RequestDTO` e `ResponseDTO` para desacoplar a camada de banco de dados da camada de visualização, impedindo o vazamento de dados sensíveis (como senhas).
* **Segurança com BCrypt:** Integração do `BCryptPasswordEncoder` para criptografia de senhas, garantindo que credenciais nunca sejam armazenadas em texto puro.
* **Bean Validation (JSR 303):** Validações rigorosas na entrada de dados (`@NotBlank`, `@Email`, `@Size`) para garantir a integridade das informações.
* **Java Stream API:** Processamento funcional de coleções para mapeamento de objetos e transformações de listas.
* **Arquitetura Clean:** Separação clara entre Controllers, Services, DTOs, Repositories e Models.

## 📦 Tecnologias Utilizadas
* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Segurança:** Spring Security (BCrypt)
* **Persistência:** Spring Data JPA / Hibernate
* **Validação:** Hibernate Validator
* **Banco de Dados:** MySQL

## 🛣️ Endpoints Principais
| Método | Endpoint | Função |
|---|---|---|
| GET | `/funcionarios` | Lista todos os funcionários (Retorna ResponseDTO) |
| POST | `/funcionarios` | Cadastra novo funcionário (Recebe RequestDTO + BCrypt) |

---
Desenvolvido por **Rodrigo Costa** 📩 [rodrigocostas147@gmail.com](mailto:rodrigocostas147@gmail.com)
