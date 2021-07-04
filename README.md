# Multitenancy
- aplicativos que permitem diferentes clientes trabalharem com o mesmo, sem ver os dados uns dos outros.
- isso acarreta na configuração de armazenamento separado para cada cliente

## Projeto
- para simular uma aplicação multitenancy, utilizaremos:
  - spring boot web
  - h2
  - flyway

## Observação importante
- Não use números sequenciais como IDs de inquilino. Os números sequenciais são fáceis de adivinhar. Tudo que você precisa fazer como cliente é adicionar ou subtrair de seu próprio tenantId, modificar o cabeçalho HTTP e pronto, você terá acesso aos dados de outro inquilino. É melhor usar um UUID, pois é quase impossível adivinhar e as pessoas não vão confundir acidentalmente um ID de locatário com outro. Melhor ainda, verifique se o usuário conectado realmente pertence ao inquilino especificado em cada solicitação.
- Utilize schemas ou base de dados diferentes a cada inquilino (cliente).
