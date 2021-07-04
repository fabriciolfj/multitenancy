curl --request GET --header "x-tenant: financeiro-01" http://localhost:8080/v1/persons; echo

curl --request GET --header "x-tenant: estoque-01" http://localhost:8080/v1/persons; echo

curl --request POST --header "x-tenant: financeiro-01" --header "Content-Type: application/json" --data '{"name" : "fabricio", "address" : "rua teste 01"}' http://localhost:8080/v1/persons; echo

curl --request POST --header "x-tenant: estoque-01" --header "Content-Type: application/json" --data '{"name" : "carlos", "address" : "rua teste 02"}' http://localhost:8080/v1/persons; echo

curl --request GET --header "x-tenant: financeiro-01" http://localhost:8080/v1/persons; echo

curl --request GET --header "x-tenant: estoque-01" http://localhost:8080/v1/persons; echo