#Run DB
export POSTGRES_PASSWORD="mysecretpassword123"
docker run --name postgres -d -e POSTGRES_PASSWORD=$POSTGRES_PASSWORD -p 5432:5432 postgres