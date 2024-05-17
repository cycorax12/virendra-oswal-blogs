### Run Postgres Locally
docker run --name vo_db -p 5455:5432 -e POSTGRES_USER=vo -e POSTGRES_PASSWORD=vo123 -e POSTGRES_DB=vo_db -d postgres