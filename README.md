# CRUD - Sistema Gerenciador de Clientes - FirmaNotes

Sitema CLI, para getão dos dados de clientes.

## Ferramentas utilizadas
 - MySQL
 - Eclipse
 - JDBC

## Estrutura do projeto 
Esse projeto possui 5 camadas de desenvolvimento.
 - TO: Essa camada é onde criamos a classe que será a entidade do nosso banco de dados.
 - DAO: Essa camada possui uma interface na que receberá as assinaturas dos métodos que iremos usar para conectar ao banco de dados.
 - DAO implement: Aqui é onde implementamos a interface DAO e nos conectamos com o banco de dados e executamos os comandos necessários.
 - BO: Classe responsável pelas regras de negócio do projeto, ela será a ponte entre o programa e a classe DaoImplements.
 - Program: Essa classe é responsável por rodar o programa.
## OBS
Ao clonar esse reposiório, você precisará criar um pacote chamado confidencial onde você criara uma classe Credencials onde você deve armazenar os dados como user e password do seu banco de dados.

## Descobertas
Percebi que não posso utilizar singleton quando quero listar entidades do banco de dados.
Como singleton cada instancia é o mesmo endereço de memória acabava que todos os itens da lista apontavam para o mesmo objeto.
## CRUD
[ X ] CREATE:
Cadastro de clientes.

[ X ] READ:
Listagem e pesquisa de clientes.

[ X ] UPDATE:
Atualização de dados de clientes.

[ X ] DELETE:
Remoção de clientes.
