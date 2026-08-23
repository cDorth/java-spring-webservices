# conceitos sobre HTTP e Rest

Stateless = sem estado entre requisições <br>
"Cada pedido(request) precisa carregar as informações necessárias."

## STATUS CODES

100–199 → informação

200–299 → sucesso <br>
200 → OK <br>
201 → CREATED <br>
204 → NO CONTENT <br>

300–399 → redirecionamento

400–499 → erro do cliente <br>
400 → BAD REQUEST <br>
401 → UNAUTHORIZED <br>
403 → FORBIDDEN <br>
404 → NOT FOUND <br>
405 → METHOD NOT ALLOWED <br>
409 → CONFLICT <br>
422 → validação/semântica, conforme a API <br>

500–599 → erro do servidor <br> 
500 → INTERNAL SERVER ERROR <br>
502 → BAD GATEWAY <br>
503 → SERVICE UNAVAILABLE <br>
504 → GATEWAY TIMEOUT <br>

Base URL para testes no Postman: https://jsonplaceholder.typicode.com
