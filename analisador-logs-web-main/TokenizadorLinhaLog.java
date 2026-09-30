import java.util.Scanner;

/**
 * Quebra uma linha de um arquivo de log de servidor web
 * em seus campos separados.
 * Atualmente, assume-se que o arquivo de log contenha apenas
 * informações inteiras de data e hora.
 * 
 * Traduzido por Julio César Alves - 2026-09-26
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version    2016.02.29
 */
public class TokenizadorLinhaLog
{
    // Em qual índice de valoresDados os diferentes campos
    // de uma linha de log são armazenados.
    private static final int ANO = 0, MES = 1, DIA = 2,
                             HORA = 3, MINUTO = 4;
    
    // O número de campos. Se mais campos forem adicionados, ex.: para
    // segundos ou um código de status, este valor deve ser incrementado
    // para corresponder.
    private static final int NUMERO_DE_CAMPOS = 5;
    
    /**
     * Constrói um TokenizadorLinhaLog.
     */
    public TokenizadorLinhaLog()
    {
    }

    /**
     * Tokeniza uma linha de log. Coloca os valores inteiros
     * em um array. O número de tokens na linha
     * deve ser suficiente para preencher o array.
     *
     * @param linhaLog A linha a ser tokenizada.
     * @param linhaDados Onde armazenar os valores.
     */
    public EntradaDeLog tokenizar(String linhaLog)
    {
        int[] linhaDados = new int[NUMERO_DE_CAMPOS];
        try {
            // Examina a linha de log em busca de inteiros.
            Scanner tokenizador = new Scanner(linhaLog);
            for(int i = 0; i < linhaDados.length; i++) {
                linhaDados[i] = tokenizador.nextInt();
            }
            tokenizador.close();
            return new EntradaDeLog(linhaDados[ANO], 
                linhaDados[MES], linhaDados[DIA], linhaDados[HORA], linhaDados[MINUTO]);
        }
        catch(java.util.NoSuchElementException e) {
            System.out.println("Itens de dados insuficientes na linha de log: " + linhaLog);
            throw e;
        }
    }
}
