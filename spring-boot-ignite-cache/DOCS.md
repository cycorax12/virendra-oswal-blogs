# Getting Started

### Running Postgres Database Locally via Docker
```
docker run --name postgres_db -p 5432:5432 -e POSTGRES_USER=vo -e POSTGRES_PASSWORD=vo -e POSTGRES_DB=emp_db -d postgres
```

### Maven Install
```
mvn clean install
```

### Run Spring Boot Application