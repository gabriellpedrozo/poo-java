/**
 * Esta classe representa uma figura simples. Você pode desenhar a figura
 * usando o método desenhar. Mas, como é uma figura eletrônica, ela pode
 * ser alterada. Você pode deixá-la em preto e branco ou colorida
 * (somente depois de desenhada, é claro).
 *
 * Esta classe foi criada como um exemplo de aulas em Java usando BlueJ.
 * 
 * Traduzido por Julio César Alves - 2023-08-25
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Figura
{
    private Quadrado parede;
    private Quadrado janela;
    private Triangulo telhado;
    private Circulo sol;
    private Circulo sol2;
    private Pessoa pessoa1;
    private boolean desenhado;

    /**
     * Construtor para objetos da classe Figura
     */
    public Figura()
    {
        parede = new Quadrado();
        janela = new Quadrado();
        telhado = new Triangulo();  
        sol = new Circulo();
        sol2 = new Circulo();
        pessoa1 = new Pessoa();
        desenhado = false;
    }

    /**
     * Desenha esta figura.
     */
    public void desenhar()
    {
        if(!desenhado) {
            parede.moverHorizontal(-140);
            parede.moverVertical(20);
            parede.mudarTamanho(120);
            parede.exibir();
            
            janela.mudarCor("preta");
            janela.moverHorizontal(-120);
            janela.moverVertical(40);
            janela.mudarTamanho(40);
            janela.exibir();
    
            telhado.mudarTamanho(60, 180);
            telhado.moverHorizontal(20);
            telhado.moverVertical(-60);
            telhado.exibir();
    
            sol.mudarCor("azul");
            sol.moverHorizontal(100);
            sol.moverVertical(-40);
            sol.mudarTamanho(80);
            sol.exibir();
            
            sol2.mudarCor("amarela");
            sol2.moverHorizontal(-200);
            sol2.moverVertical(-50);
            sol2.mudarTamanho(70);
            sol2.exibir();
            
            pessoa1.mudarCor("verde");
            pessoa1.moverHorizontal(150);
            pessoa1.moverVertical(35);
            pessoa1.exibir();
            desenhado = true;
        }
    }

    /**
     * Muda esta figura para preto e branco
     */
    public void definirPretoEBranco()
    {
        parede.mudarCor("preta");
        janela.mudarCor("branca");
        telhado.mudarCor("preta");
        sol.mudarCor("preta");
        sol2.mudarCor("preta");
        pessoa1.mudarCor("branca");
    }

    /**
     * Muda esta figura para colorida
     */
    public void definirColorida()
    {
        parede.mudarCor("vermelha");
        janela.mudarCor("preta");
        telhado.mudarCor("verde");
        sol.mudarCor("azul");
        sol2.mudarCor("amarela");
        pessoa1.mudarCor("verde");
    }
    
    /**
     * poente dos sois 
       */
    public void porDoSol()
    {
        sol.moverVerticalLento(350);
        sol2.moverVerticalLento(350);
        pessoa1.moverHorizontalLento(-200);
    }
}
