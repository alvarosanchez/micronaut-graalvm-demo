#Run DB
export POSTGRES_PASSWORD="mysecretpassword123"
docker run --name postgres -d -e POSTGRES_PASSWORD=$POSTGRES_PASSWORD -p 5432:5432 \
  -v $(pwd)/src/main/resources/create.sql:/docker-entrypoint-initdb.d/01.sql \
  -v $(pwd)/src/main/resources/data.sql:/docker-entrypoint-initdb.d/02.sql postgres