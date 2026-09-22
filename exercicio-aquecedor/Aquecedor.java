
/**
 * Escreva uma descrição da classe Aquecedor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aquecedor
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private double temperatura;
    private double min;
    private double max;
    private double incremento;

    /**
     * Construtor para objetos da classe Aquecedor
     */
    public Aquecedor(double minimo, double maximo)
    {   
        temperatura = 20.0;
        min = minimo;
        max = maximo;
        incremento = 3.0;
    }

    public void esquentar()
    {   
        temperatura = temperatura + incremento;
        if(temperatura > max){
        temperatura = max;
        }
    }
    
    public void esfriar()
    {
        temperatura = temperatura - incremento;
        if(temperatura < min){
            temperatura = min;
        }
    } 
    
    public double obterTemperatura()
    {
        return temperatura;
    }

    public void mudarIncremento(double novoIncremento)
    {
        if(novoIncremento > 0){
            incremento = novoIncremento;
        }
    }
}