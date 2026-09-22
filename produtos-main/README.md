# Projeto `produtos`

Autores:  David J. Barnes e Michael Kölling

- Traduzido por: Julio César Alves

Este produto é material suplementar do livro

```
   Objects First with Java - A Practical Introduction using BlueJ
   Sixth edition
   David J. Barnes and Michael Kölling
   Pearson Education, 2016
```

## Objetivo do projeto

O projeto pretende ampliar o entendimento do uso de objetos coleções.
Os exercícios  podem ser resolvidos após a conclusão da Seção 4.9 do Capítulo 4.

## O contexto

Uma empresa registra os níveis de estoque dos produtos que vende.
Um objeto `GerenciadorDeEstoque` mantém uma lista de tamanho arbitrário de objetos `Produto`.
Sua tarefa é completar a implementação rascunhada da classe `GerenciadorDeEstoque`.

A classe `DemonstracaoEstoque` foi fornecida para ajudar a demonstrar maneiras 
nas quais os objetos `GerenciadorDeEstoque` e `Produto` podem ser usados.
Você pode criar um objeto `DemonstracaoEstoque` no banco de objetos e chamar seu método de demonstração.
À medida que você desenvolve a classe `GerenciadorDeEstoque`, esta demonstração deve demonstrar mais funcionalidades.

## A classe `GerenciadorDeEstoque`

A classe GerenciadorDeEstoque usa um objeto `ArrayList` para armazenar zero ou mais itens de produto.
Seu método `adicionarProduto` adiciona um novo produto à coleção.
Os seguintes métodos precisam ser completados: `receberEntrega`, `encontrarProduto`, `imprimirDetalhesDosProdutos` e
`quantidadeEmEstoque`.

Abaixo está um resumo das alterações a serem feitas.
Elas são melhor detalhadas mais adiante na seção **Implementação Passo a Passo**.

- O método que recebe a entrega deve encontrar na lista de produtos o Produto com identificador passado e depois chamar seu método `aumentarQuantidade`.

- O método `encontrarProduto` deve procurar na coleção por um produto cujo campo identificador corresponda ao parâmetro id deste método.
Se um produto correspondente for encontrado, esse Produto deverá ser retornado como resultado do método.
Se nenhum produto correspondente for encontrado, retorne o método deve retornar `null`.

- O método `imprimirDetalhesDosProdutos` deve iterar na lista de produtos e imprimir o resultado da chamada do método `paraString()`
de cada produto.

- O método `quantidadeEmEstoque` deve localizar um produto na coleção com o ID correspondente e retornar 
a quantidade atual desse produto como resultado do método.
Se nenhum produto com ID correspondente for encontrado, retorne zero.

## A classe `Produto`

Esta classe foi fornecida para você e você não deve precisar fazer nenhuma alteração nela.

Cada produto vendido pela empresa é representado por uma instância da classe `Produto`, 
que registra o identificador, o nome e quantos desse produto estão atualmente em estoque.
A classe `Produto` define o método `aumentarQuantidade` para registrar aumentos no nível de estoque desse produto.
O método `venderUm` registra que um item desse produto foi vendido, diminuindo em um o valor do atributo de `quantidade`.

## Implementação Passo a Passo

A tarefa completa foi dividida em etapas separadas para ajudá-lo a criar a versão final em pequenos passos.

**Recomenda-se compilar e executar o programa após cada etapa para verificar se as alterações feitas estão corretas**.

### Exercício 1

Implemente o método `imprimirDetalhesDosProdutos` para garantir que você é capaz de iterar na coleção de Produtos.

Apenas imprima cada produto usando `System.out` e chamando o método `paraString` do produto.

### Exercício 2

Implemente o método `encontrarProduto`.

Repare que, ao contrário do método `imprimirDetalhesDosProdutos`, não necessariamente temos que verificar
todos os produtos da coleção antes que o produto procurado seja encontrado. 
Por exemplo, se o primeiro produto da coleção corresponde ao identificador do produto, a iteração pode terminar e
aquele primeiro produto ser retornado. 
Por outro lado, é possível que não haja correspondência para o identificador na coleção.
Nesse caso, toda a coleção será verificada, sem encontrar um produto para retornar.
Nesse caso o valor `null` deve ser retornado.

Ao procurar por um produto, você precisará chamar o método `obterID` de um produto.

### Exercício 3

Implemente o método `quantidadeEmEstoque`.
Isto é relativamente simples de implementar depois que tiver feito o método `encontrarProduto`.

Por exemplo, `quantidadeEmEstoque` pode chamar o método `encontrarProduto` para fazer a pesquisa e, 
em seguida, chamar o método `obterQuantidade` para o produto encontrado.
Lembre-se apenas que o produto pode não ser encontrado e, neste caso, o método deve retornar zero.

### Exercício 4

Implemente o método que recebe a entrega usando uma abordagem semelhante àquela usada em `quantidadeEmEstoque`.

Será necessário chamar o método `aumentarQuantidade` do produto encontrado (se ele for encontrado).

### Exercício 5

Implemente um método na classe `GerenciadorDeEstoque` que imprime os detalhes de todos os produtos 
com níveis de estoque abaixo de um determinado valor (passado como parâmetro para o método).

### Exercício 6

Modifique o método `adicionarProduto` para que um novo produto não possa ser adicionado à lista de produtos 
se tiver o mesmo identificador de um produto já existente.

### Exercício 7

Adicione à classe `GerenciadorDeEstoque` um método que encontra um produto a partir de seu nome em vez de seu identificador:

```java
    public Product encontrarProduto(String nome)
```
Para fazer isso, você precisará comparar duas strings, lembre-se que, para isso, você precisa usar o método `equals`.
Por exemplo:

```java
     s1.equals(s2)
```
