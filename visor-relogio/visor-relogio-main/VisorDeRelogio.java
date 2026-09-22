
/**
 * A classe VisorDeRelogio implementa um visor de relógio digital.
 * O relógio mostra horas e minutos. O relógio marca de 00:00 (meia-noite)
 * até 23:59 (um minuto para meia-noite).
 * 
 * O visor do relógio recebe "tique-taques" (através do método tiqueTaque) a
 * cada minuto e reage incrementado o valor do visor. Isso é feito como é em
 * um relógio, a hora incrementa quando os minutos voltam para zero.
 * 
 * Traduzido por Julio César Alves - 2023.09.15
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Realizei o desafio 2.2 explicação está no começo do codigo VisorDeNumero
 */
public class VisorDeRelogio
{
    private VisorDeNumero horas;
    private VisorDeNumero minutos;
    private VisorDeNumero segundos;
    private String stringVisor;    // simula o visor real

    /**
     * Construtor para objetos VisorDeRelogio. Este construtor
     * cria um novo relógio marcando 00:00.
     */
    public VisorDeRelogio()
    {
        horas = new VisorDeNumero(24);
        minutos = new VisorDeNumero(60);
        segundos = new VisorDeNumero(60);
        
        segundos.definirProximo(minutos);
        minutos.definirProximo(segundos);
        
        atualizarVisor();
    }

    /**
     * Construtor para objetos VisorDeRelogio. Este construtor
     * cria um novo relógio marcando as horas de acordo com 
     * os parâmetros recebidos.
     */
    public VisorDeRelogio(int hora, int minuto, int segundo)
    {
        horas = new VisorDeNumero(24);
        minutos = new VisorDeNumero(60);
        segundos = new VisorDeNumero(60);
        
        segundos.definirProximo(minutos);
        minutos.definirProximo(horas);

        definirHora(hora, minuto,segundo);
    }

    /**
     * Este método deveria ser chamado uma vez a cada minuto -
     * ele faz o visor do relógio passar um minuto.
     */
    public void tiqueTaque()
    {
        segundos.incrementar();

        atualizarVisor();
    }

    /**
     * Define a hora do visor de acordo com o valor de hora e
     * minuto recebidos por parâmetro.
     */
    public void definirHora(int hora, int minuto, int segundo)
    {
        horas.definirValor(hora);
        minutos.definirValor(minuto);
        segundos.definirValor(segundo);
        atualizarVisor();
    }

    /**
     * Retorna a hora atual do visor no formato HH:MM:SS
     */
    public String obterHora()
    {
        return stringVisor;
    }

    /**
     * Atualiza a string interna que representa o visor.
     */
    private void atualizarVisor()
    {
        stringVisor = horas.obterValorVisor() + ":" + 
        minutos.obterValorVisor() + ":" + segundos.obterValorVisor();
    }
}
