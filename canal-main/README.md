# Projeto `canal`

Autores: Michael Kölling and David J. Barnes

- Traduzido por: Julio César Alves

Este projeto, cujo nome original é `club`, é parte do material do livro

```
   Objects First with Java - A Practical Introduction using BlueJ
   6ª edição
   David J. Barnes e Michael Kölling
   Pearson Education, 2017
```

## Objetivo do projeto

O projeto pretende ampliar o entendimento do uso de objetos coleções.
Os três primeiros exercícios podem ser resolvidos após a conclusão da Seção 4.6
do Capítulo 4, e os demais após a Seção 4.9.

## O contexto

Este projeto traz uma implementação inicial para tratar a inscrição de usuários
em um canal (como um canal do YouTube, por exemplo).

A inscrição no canal é representada por uma instância da classe `Inscricao`.
Uma versão completa da classe `Inscricao` já é fornecida a você no projeto
`canal`, e ela **não deve ser modificada**.
Cada objeto `Inscricao` tem as informações do nome da pessoa que se increveu
e o mês e o ano de quando ela se inscreveu no canal.
Todas essas informações são definidas quando um objeto `Inscricao` é criado.

Sua tarefa é completar a classe `Canal`, cuja implementação inicial é
fornecida para você no projeto.
A ideia é que a classe `Canal` guarde os objetos `Inscricao` em uma coleção
de tamanho flexível, permitindo assim reforçarmos os conceitos estudados
no capítulo atual.


## Implementação passo a passo

As alterações necessárias no projeto são detalhadas passo a passo a seguir. 
É **altamente recomendável** que você compile e rode o programa após a
implementação de cada passo, para testar se tudo foi feito corretamente.

### Exercício 1

Crie um atributo na classe `Canal`para referenciar um objeto coleção de
tamanho flexível, que armazene as inscrições feitas no canal.

Use o comando de importação adequado para esta coleção.

No construtor, crie o objeto coleção e atribua-o ao atributo correspondente.

### Exercício 2

Complete a implementação do método `quantidadeDeInscritos` para que retorne
o tamanho atual do objeto coleção.
É claro que este método retornará zero enquanto o método `inscrever` não for 
implementado, mas ele estará pronto para ser testado quando isso for feito.

### Exercício 3

Complete a implementação do método `inscrever`.

Há duas formas de adicionar um novo objeto `Inscricao` em um objeto `Canal`
usando os objetos da bancada de objetos do BlueJ:

- Você pode criar um objeto `Inscricao` na bancada de objetos, chamar o método 
  `inscrever` do objeto `Canal`, e clicar no objeto `Inscricao` para
  informar o parâmetro.
  
- Ou você pode chamar o método `inscrever` do objeto `Canal` e digitar o código
  que cria um objeto `Inscricao` diretamente no parâmetro do construtor.
  
  `new Inscricao("nome do membro", nro_do_mes, nro_do_ano)`

Depois que você adicionar novos inscritos use o método `quantidadeDeInscritos`
para testar:

a) que o método `inscrever` está adicionando o inscrito na coleção;

b) e que o método `quantidadeDeMembros` está funcionando corretamente.

### Exercício 4

Implemente um método na classe `Canal` com a seguinte assinatura e descrição:

```java
    /** 
     * Retorna quantos membros se inscreveram em um dado mês.
     * @param mes O mês que estamos interessados.
     * @return Quandos membros se inscreveram no mês.
     */
    public int inscritosNoMes(int mes) 
```

Se o parâmetro `mes` estiver fora da faixa válida (1 a 12), imprima no terminal
uma mensagem de erro e retorne zero.

### Exercício 5

Implemente um método na classe `Canal` com a seguinte assinatura e descrição:

```java
    /**
     * Retorna se o canal tem alguém inscrito com o nome passado.
     * @param nome O nome a ser procurado na lista de inscritos.
     * @return Retorna true se tem alguém inscrito com o nome passado,
     *         e false em caso contrário
     */
    private boolean estaInscrito(String nome) {
```

Dica: lembre-se que para comparação de Strings em Java, não podemos usar o
operador `==`. Em vez disse, use o método `equals`.

### Exercício 6

Repare que, provavelmente, da forma que o método `inscrever` da classe `Canal` 
está  implementado, uma pessoa pode se inscrever mais de uma vez no canal.

A ideia neste exercício é alterar o método `inscrever` para que ele só inclua
a inscrição se não existir nenhuma outra inscricao com o mesmo nome.
Repare que você deve usar o método implementado no exercício anterior para
tratar isso.

Com essa alteração o método `inscrever` nem sempre adiciona uma inscricao ao
canal.
Nesse tipo de situação, o ideal é que o método indique isso de alguma forma
para quem chamou o método.
Para isso, altere o tipo de retorno do método para `boolean` e faça com que
ele retorne `true` se a inscrição foi adicionada no canal e `false` em caso 
contrário.

Dica: faça os testes abaixo para garantir que o método está implementado
corretamente:

- Tente inscrever objetos `Inscricao` que tenham nomes diferentes.
- Tente inscrever no canal dois objetos `Inscricao` diferentes, mas que tenham
  o mesmo nome.
- Tente inscrever o mesmo objeto `Inscricao` duas vezes no canal.


### (Opcional) Exercício 7 [Desafio]

Obs.: para fazer esse exercício você precisa assistir ao início da aula 
teórica 4.3.

Implemente um método na classe `Canal` com a seguinte assinatura e descrição:

```java
    /**
     * Remove todos os membros da classe `Canal` que se inscreveram em um dado
     * mês de um determinado ano, e os retorna em um objeto coleção separado.
     * @param mes O mês da inscrição.
     * @param ano O ano da inscrição.
     */
    public ArrayList removerInscritos(int mes, int ano)
```

Se o parâmetro `mes` estiver fora da faixa válida (1 a 12), imprima no terminal
uma mensagem de erro e retorne um objeto coleção sem nenhum objeto dentro.

