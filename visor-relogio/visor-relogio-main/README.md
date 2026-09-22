# Projeto `visor-relogio`

Autores: Michael Kölling and David J. Barnes

- Traduzido por: Julio César Alves

Este projeto é parte do material do livro

```
   Objects First with Java - A Practical Introduction using BlueJ
   6ª edição
   David J. Barnes e Michael Kölling
   Pearson Education, 2017
```

É discutido no capítulo 3.

Para usar este projeto, crie uma instância da classe `VisorDeRelogio`. 
Em seguida, inspecione esta instância e deixe a janela do inspetor de objetos aberta. 
Com a janela do inspetor aberta, chame os métodos do objeto, como `tiqueTaque` e `definirHora`. 
Observe o atributo `stringVisor` no inspetor.

O atributo `stringVisor` simula o dispositivo de exibição do relógio real.
Se este programa estivesse sendo executado em um relógio real, ele mudaria o hardware de exibição real,
em vez desta string.
O método `tiqueTaque` seria acionado uma vez a cada minuto por algum hardware de temporizador.

Tudo o mais poderia ser praticamente como é.

Obs.: Este projeto não implementa um tratamento adequado de erros.
