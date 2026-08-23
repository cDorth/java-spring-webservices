# conceitos sobre HTTP e Rest

Stateless = sem estado entre requisições
"Cada pedido(request) precisa carregar as informações necessárias."

## STATUS CODES

100–199 → informação

200–299 → sucesso <br>
200 → OK <br>
201 → CREATED <br>
204 → NO CONTENT <br>

300–399 → redirecionamento

400–499 → erro do cliente
400 → BAD REQUEST
401 → UNAUTHORIZED
403 → FORBIDDEN
404 → NOT FOUND
405 → METHOD NOT ALLOWED
409 → CONFLICT
422 → validação/semântica, conforme a API

500–599 → erro do servidor
500 → INTERNAL SERVER ERROR
502 → BAD GATEWAY
503 → SERVICE UNAVAILABLE
504 → GATEWAY TIMEOUT

Base URL para testes no Postman: https://jsonplaceholder.typicode.com
