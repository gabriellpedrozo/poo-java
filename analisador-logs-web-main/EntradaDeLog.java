import java.util.Calendar;

/**
 * Armazena os dados de uma única linha de um
 * arquivo de log de servidor web.
 * Campos individuais ficam disponíveis por meio
 * de métodos de acesso como obterHora() e obterMinuto().
 * 
 * Traduzido por Julio César Alves - 2026-09-26
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class EntradaDeLog implements Comparable<EntradaDeLog>
{
    // Dados de uma única linha de log armazenados
    private final int ano;
    private final int mes;
    private final int dia;
    private final int hora;
    private final int minuto;

    // Objeto Calendar equivalente para o horário do log.
    private Calendar quando;
    
    /**
     * Cria uma EntradaDeLog a partir dos componentes individuais.
     * @param ano O ano
     * @param mes O mês (1-12)
     * @param dia O dia (1-31)
     * @param hora A hora (0-23)
     * @param minuto O minuto (0-59)
     */
    public EntradaDeLog(int ano, int mes, int dia, int hora, int minuto)
    {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
        definirQuando();
    }
    
    
    public int obterDiaDaSemana()
    {
      return quando.get(Calendar.DAY_OF_WEEK);    
    }
    
    /**
     * Retorna a hora.
     * @return O campo de hora da linha de log.
     */
    public int obterHora()
    {
        return hora;
    }

    /**
     * Retorna o minuto.
     * @return O campo de minuto da linha de log.
     */
    public int obterMinuto()
    {
        return minuto;
    }
    
    /**
     * Cria uma representação textual dos dados.
     * Ela não é necessariamente idêntica ao
     * texto da linha de log original.
     * @return Uma string representando os dados desta entrada.
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        incluirValor(buffer, ano);
        incluirValor(buffer, mes);
        incluirValor(buffer, dia);
        incluirValor(buffer, hora);
        incluirValor(buffer, minuto);
        // Remove eventual espaço à direita.
        return buffer.toString().trim();
    }

    private void incluirValor(StringBuffer buffer, int valor)    
    {
        if(valor < 10) {
            buffer.append('0');
        }
        buffer.append(valor);
        buffer.append(' ');
    }
    
    /**
     * Compara a combinação de data/hora desta entrada de log
     * com outra.
     * @param outraEntrada A outra entrada para comparação.
     * @return Valor negativo se esta entrada vier antes da outra.
     *         Valor positivo se esta entrada vier depois da outra.
     *         Zero se as entradas forem iguais.
     */
    public int compareTo(EntradaDeLog outraEntrada)
    {
        // Usa o método de comparação do Calendar equivalente.
        return quando.compareTo(outraEntrada.obterQuando());
    }
    
    /**
     * Retorna o objeto Calendar que representa este evento.
     * @return O Calendar deste evento.
     */
    private Calendar obterQuando()
    {
        return quando;
    }

    /**
     * Cria um objeto Calendar equivalente a partir dos valores de dados.
     */
    private void definirQuando()
    {
        quando = Calendar.getInstance();        
        quando.set(ano,
                   // Ajusta mês pois na classe Calendar, janeiro é o mês zero, 
                   // fevereiro é 1, e assim por diante.
                   mes - 1, 
                   dia, hora, minuto);
    }
    
}