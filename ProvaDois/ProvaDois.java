Para analisar o aprendizado, desenvolva um mini sistema de registro de heróis, que possui como entidades:
* Franquia
	- Identificador Único (ID)
	- Nome
	- Apelido
	- Data de Criação
* Herói
	- Identificador Único (ID)
	- Nome
	- Localização
	- Identidade
	- Preço
	- I.D. da Franquia
* Filme
	- Identificador Único (ID)
	- Data de Lançamento
	- Previsão de Investimento
* Heróis no Filme
	- I.D. do Herói
	- I.D. do Filme


Cada arquivo fonte de objeto deverá conter as suas propriedades e deverá respeitar os relacionamentos existentes entre si:
	* Franquia possui relacionamento 1-N com Herói
	* Herói possui relacionamento 1-N com Heróis no Filme
	* Filme possui relacionamento 1-N com Heróis no Filme

Cada arquivo fonte de objeto deverá conter, minimamente:
* Franquia
	- Método com a Quantidade de Heróis
* Filme
	- Método com a Quantidade de Heróis
	- Metodo com o Valor Total investido com os Heróis
	- Método que exiba as informações de:
	- Valor Previsto
	- Valor Total Investido
	- Se a diferença for positiva, (+) Lucro:
	- Se a diferença for negativa, (-) Perda:
* Herói
	- Método com o valor total de investimentos
	- Método com a quantidade de filmes que participa

Deverá ser criado um arquivo principal para gerenciamento das informações dos objetos, onde deverão ser criados 10 heróis (a sua escolha) e 5 franquias.
 Cada Filme deverá possuir alguns heróis que estarão participando e ao final deverá ser exibida a Quantidade de Heróis por Companhia, a Quantidade de Filmes que cada Herói participou, 
 o Valor que cada Herói gerou e as informações de Valor Previsto do Filme, Valor Total Investido e se gerou Lucro ou Perda.

O código fonte deverá ser trabalhando dentro do GitHub, sendo sincronizado e aberto PR ao final do desenvolvimento.