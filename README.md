# DS - inverted Index - Listas Invertidas
Thats is a homework of my classes of Data Structures at UFSC / INE5609

Uma lista invertida nos traz grande vantagem na questão do aumento da eficiência de busca (necessário para longos arquivos de texto).Este tipo de estrutura é um dos mais eficientes para a indexação de documentos comparados a outros 
tipos de busca (Hash Arvores).

Neste trabalho temos o objetivo de listar e apresentar os dados de diversas bebidas, utilizando os diretórios sabor, tipo e marca para separa-los em listas. Não é possível inserir dois produtos com o mesmo nome, porem vão existir diversos produtos com a mesma marca, tipo, sabor e quantidade (em ML) por embalagem. Em nosso código já existem 16 produtos disponíveis para cadastrar através da opção número 1 do menu.

Temos presentes nele vários tipos de pesquisas para retornar os diretórios requisitados nos seguintes métodos: "productsByBrand", "productsByType" e "productsByFlavor" que retornam os diretórios contendo todas os produtos de certa marca, tipo ou sabor respectivamente em uma busca simples. Além disso temos os métodos "productsByFlavorAndByType" e "productsByBrandAndByType" que retornam os produtos de certo tipo e sabor e os produtos de certa marca e tipo em uma busca composta.

Utilizamos HashMap para a criação dos diretórios que contém todos os produtos cadastrados e os que serão cadastrados de certa categoria, possibilitando que a lista não tenha um valor predefinido.

Além disso utilizamos o método insertProduct para inserir um produto na lista de produtos cadastrados através do seu Index único e ao mesmo tempo aloca-lo nos diretórios que o dizem respeito.

