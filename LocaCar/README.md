Instruções
Para analisar o aprendizado, desenvolva um mini sistema de locação de veículos, que possui como entidades:

Cliente
int: Identificador Único (ID)
String: Nome
Date: Data de Nascimento
String: C.P.F.
int: Dias para Devolução

Veículo
String: Marca
String: Modelo
int: Ano
double: Valor para Locação

Veículos Leves (Herança de Veículo)
int: Identificador Único (ID)
String: Cor

Veículos Pesados (Herança de Veículo)
int: Identificador Único (ID)
String: Restrições

Locação
int: Identificador Único (ID)
int: I.D. do Cliente
Date: Data de Locação
Date: Data de Devolução

Veículo Locados
int: I.D. da Locação
int: I.D. do Veículo Level
int: I.D. do Veículo Pesado

Cada arquivo fonte de objeto deverá conter as suas propriedades e deverá respeitar os relacionamentos existentes entre si:

Cliente possui relacionamento 1-N com Locação
Locação possui relacionamento 1-N com Veículos Locados
Veículos Leves possui relacionamento 1-N com Veículos Locados
Veículos Pesados possui relacionamento 1-N com Veículos Locados

A classe Veículos trata-se de uma classe abstrata e não deve ser instânciada.

Deverá ser criada uma interface no qual Veículos Leves e Veículos Pessados serão implementados. Esta interface se chamará BaseVeiculo e possuirá os seguintes métodos:

public: Quantidade de Locações Realizadas
public default: Selo da Empresa

Cada arquivo fonte de objeto deverá conter, minimamente:

Cliente 
Método com a Quantidade de Veículos locados.

Locação
Método com o Valor total da Locação
Método com a quantidade de veículos locados
A data de devolução deverá ser calculada com base na Data de Locação e a quantidade de dias para Devolução que o cliente tem disponível na locadora.
Deverá ser criado um arquivo principal para gerenciamento das informações dos objetos, este arquivo deverá ser estruturado com um menu com as seguintes opções:

1 - Cadastrar Cliente
2 - Cadastrar Veículo
3 - Cadastrar Locação
4 - Listar Clientes
5 - Listar Veículos
6 - Listar Locações

Ao selecionar as opções de cadastro, deverão ser solicitadas as informações necessárias para registro de cada entidade via terminal, criando ao final o objeto. Para a opção cadastrar Veículo, deverá ser questionado se o cadastro é de 
1 - Veículo Leve
2 - Veículo Pesado.

Ao selecionar as opções de listar, deverão ser impressas as informações de cada entidade, sendo que:

Cliente
Deverá ser exibida a Quantidade de Veículos

Veículos
Deverá ser exibida a quantidade de Locações e o valor total de cada locação
Deverá ser exibido o selo da empresa

Locação
Deverá ser exibida a quantidade de veículos por Locação.
Para a opção listar Veículo, deverá ser questionado se a listagem é de
 1 - Veículo Leve
 2 - Veículo Pesado

Os objetos deverão ser gerenciados simulando um banco de dados com ArrayList, ou seja, as impressões deverão ser geradas e gerenciadas por forEach.

Deverão ser trabalhadas corretamente as estruturas de Orientação a Objeto, aplicando os encapsulamentos, as heranças e os polimorfismos necessários para cada entidade.

Pontos importantes:

Comentários de Código demonstrando a estrutura
Indentação de Código
Aplicação de camelCase e PascalCase para o código fonte
Nomenclatura de variáveis que determinem sua utilização
O código fonte deverá ser trabalhando dentro do GitHub, sendo sincronizado e aberto PR ao final do desenvolvimento.