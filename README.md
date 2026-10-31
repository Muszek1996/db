# db

University project: a Spring Boot REST API with Hibernate (XML mappings) over a MySQL database `steam`. It manages players and games with CRUD endpoints.

## Endpoints
- `POST /Player/add`, `GET /Player/get`, `PUT /Player/update`, `DELETE /Player/delete`
- Matching operations for games

## Run
1. Start MySQL and set the connection URL and credentials in `src/main/resources/hibernate.cfg.xml`.
2. `./mvnw spring-boot:run`

## Structure
```
src/main/java/crud/       controller, entities (Player, Game), repositories
src/main/resources/       Hibernate mappings (*.hbm.xml) and config
lib/                      Hibernate jars
```
