# TESTE PRÁTICO PACTO MAIS

# FASE 1
Foi desenvolvida uma API em Java Spring Boot, para o controle de transações em uma conta bancária

* Sobre as estruturas de dados: foi utilizado H2 para a criação do banco de dados, sendo criadas uma tabela para conta e uma tabela para transação. Na documentação constava uma tabela para os tipos de transações possíveis, mas optei por não criar essa tabela, visto que o nome da operação nunca era utilizado na aplicação, apenas o seu ID.
* Foram criados 3 endpoints:
  * /conta, responsável pela criação de uma nova conta, sendo o objeto enviado pelo body da seguinte forma:
  ```
  {
   "numConta":"string"
  }
  ```