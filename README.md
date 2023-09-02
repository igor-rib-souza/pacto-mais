# TESTE PRÁTICO PACTO MAIS

# FASE 1
Foi desenvolvida uma API em Java 17 e Spring Boot, para o controle de transações em uma conta bancária

* Sobre as estruturas de dados: foi utilizado H2 para a criação do banco de dados, sendo criadas uma tabela para conta e uma tabela para transação. Na documentação constava uma tabela para os tipos de transações possíveis, mas optei por não criar essa tabela, visto que o nome da operação nunca era utilizado na aplicação, apenas o seu ID.
* Uma vez executando o projeto, o banco de dados pode ser acessado na url: http://localhost:8080/h2, usando o user "sa", sem senha
* No campo JDBC URL insira:
  ```
  jdbc:h2:file:~/workspace/projeto/database/database.db
  ```
* Foram criados 3 endpoints:
  * /conta, responsável pela criação (POST) de uma nova conta, sendo o objeto enviado pelo body da seguinte forma:
  
  ```
  {
     "numConta":"string"
  }
  ```
* /conta/:idConta, responsável por pegar (GET) uma conta pelo seu ID, retornando uma mensagem de erro, caso a conta não seja encontrada
* /transacao, responsável pela criação (POST) de uma nova transação, sendo o objeto enviado pelo body no formato:

  ```
  {
    "contaId":1,
    "tipoOperacaoId": 1,
    "valor":50.00
  }
  ```
* Nota: o valor enviado deve sempre ser positivo, o código converterá o valor para negativo se o tipo da operação for diferente de 4, pois o ID de operação 4 é o único que simboliza a entrada de dinheiro na conta, caso não seja encontrada uma conta com o ID  informado é retornada uma mensagem de erro

# FASE 2
Nessa fase foi adicionada uma nova tabela ao banco de dados, junto a novas regras de negócio

* Foi adicionada a tabela de limite da conta, ao ser criada uma conta é automaticamente criada um limite para ela
* O limite inicia sempre zerado, visto que não foi realizade nenhum depósito na conta ainda
* Ao tentar realizar uma operação de saída monetária, caso o valor seja maior que o limite associado a conta, será exibida uma mensagem de erro e a transação não será criada
* Devido à forma incremental com que os IDs são gerados e ao fato da conta e do limite serem criados simultaneamente, eles sempre possuem o mesmo ‘ID’
* Também foram realizados refatoramentos a respeito da estruturação do código, melhorando o tratamento de erros e movendo a lógica dos controllers para os services
* Também foi adicionado um check se o tipo de operação é válido (se está no intervalo [1,4])