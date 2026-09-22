
/**
 * A classe VisorDeNumero representa um vistor digital de números que pode
 * armazenar valores de zero até um dado limite. O limite pode ser definido
 * quando o vistor é criado. Os valores vão de zero (inclusive) até limite-1.
 * Se o visor for usado para os seguintes de um relógio digital, por exemplo,
 * o limite seria 60, e os valores exibidos seriam de 0 a 59. Quando 
 * incrementado, o visor automaticamente volta para zero se chegar ao limite
 * definido.
 * 
 * Traduzido por Julio César Alves - 2021-09-15
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 *
 *Realizei o desafio 2.2. Foi possível implementar o design alternativo, porém foi necessário aumentar o acoplamento entre os objetos do código.
 *No exercício anterior, a relação entre horas, minutos e segundos era controlada pelo objeto VisorDeRelogio.
 *Já neste novo design, essa relação passou a ser responsabilidade dos próprios objetos VisorDeNumero, criando uma ligação entre segundos, minutos e horas.
 */
public class VisorDeNumero
{
    private int limite;
    private int valor;
    private VisorDeNumero proximo;

    /**
     * Construtor para objetos da classe VisorDeNumero.
     * Define o limite no qual o visor volta para zero.
     */
    public VisorDeNumero(int limiteParaZerar)
    {
        limite = limiteParaZerar;
        valor = 0;
    }

    public void definirProximo(VisorDeNumero proximo)
    {
        this.proximo = proximo;
    }
    
    /**
     * Retorna o valor atual.
     */
    public int obterValor()
    {
        return valor;
    }

    /**
     * Retorna o valor a ser exibido (ou seja, o valor atual com uma String
     * de dois dígitos). Se o valor é menor que dez, um zero é acrescentado
     * à esquerda.
     */
    public String obterValorVisor()
    {
        if(valor < 10) {
            return "0" + valor;
        }
        else {
            return "" + valor;
        }
    }

    /**
     * Define o valor do vistor para o novo valor fornecido. Não faz nada,
     * se o novo valor é menor que ou maior que o limite.
     */
    public void definirValor(int novoValor)
    {
        if((novoValor >= 0) && (novoValor < limite)) {
            valor = novoValor;
        }
    }


    public void incrementar()
    {
        valor = (valor + 1) % limite;
        
        if(valor == 0 && proximo != null)
        {
            proximo.incrementar();
        }
    }
}
