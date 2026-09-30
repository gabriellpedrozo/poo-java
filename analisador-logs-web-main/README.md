# Projeto `analisador-logs-web`

- Traduzido por: Julio César Alves

Este projeto é parte do material do livro

```
   Objects First with Java - A Practical Introduction using BlueJ
   6ª edição
   David J. Barnes e Michael Kölling
   Pearson Education, 2016
```

É discutido no capítulo 7.

Objetivo do projeto: Fornecer uma ilustração do uso de arrays.

Como iniciar este projeto: Crie um objeto AnalisadorDeLog.

O LeitorDeArquivoDeLog espera ler um arquivo, weblog.txt,
contendo linhas de dados no formato:

    ano mês dia hora minuto

Os valores do mês estão no intervalo de 1 a 12 e os 
valores do dia no intervalo de 1 a 31.

Se o arquivo de exemplo não for encontrado, o leitor criará  alguns dados simulados.
Alternativamente, use o GeradorDeArquivoDeLog para criar alguns dados aleatórios.
Use o método gerarArquivo para fornecer um nome de arquivo e o número de entradas a serem criadas.
