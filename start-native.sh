#Configure datasource
export POSTGRES_PASSWORD="mysecretpassword123"
export DATASOURCES_DEFAULT_URL="jdbc:postgresql://localhost:5432/postgres"
export DATASOURCES_DEFAULT_USERNAME=postgres
export DATASOURCES_DEFAULT_PASSWORD=$POSTGRES_PASSWORD
export DATASOURCES_DEFAULT_MIN_POOL_SIZE=1
export DATASOURCES_DEFAULT_MAX_POOL_SIZE=10

./teams-solution