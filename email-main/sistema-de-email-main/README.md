# Projeto `sistema-de-email`

Autores: David Barnes and Michael Kölling

- Traduzido por: Julio César Alves

Este projeto é parte do material do livro

```
   Objects First with Java - A Practical Introduction using BlueJ
   6ª edição
   David J. Barnes e Michael Kölling
   Pearson Education, 2017
```

É discutido no capítulo 3.

Este projeto simula um sistema de email simples.
Os clientes de email simulam programas de email de diferentes usuários.
Se você criar dois ou mais clientes de email, eles podem enviar mensagens
um para o outro.
(Observe que esta é uma simulação: você não pode realmente enviar email.
Todas as mensagens são trocadas apenas entre os objetos de cliente de email 
neste projeto.)

Para usar este projeto:

- crie uma instância de ServidorDeEmail.
- crie uma instância de ClienteDeEmail. Aqui você deve passar o servidor de email
  como um parâmetro e você deve inventar um nome para este usuário.
- crie um segundo objeto ClienteDeEmail com o mesmo servidor de email e um nome de
  usuário diferente.
- Use o método "enviarEmail" de um objeto ClienteDeEmail para enviar uma mensagem
  para o outro cliente de email.
- Use o método "imprimirProximoEmail" do segundo cliente de email para receber a
  mensagem.

O objetivo deste projeto é demonstrar a interação entre objetos.
Ele inclui chamadas de método externo (um objeto chamando métodos de outro objeto)
e comandos de criação de objeto.

O depurador pode ser usado para investigar essas interações de objetos.

