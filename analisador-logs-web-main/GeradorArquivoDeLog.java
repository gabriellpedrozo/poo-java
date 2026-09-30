import java.io.*;
import java.util.*;

/**
 * Uma classe para criar arquivos de log com dados aleatórios.
 * 
 * Traduzido por Julio César Alves - 2026-09-26
 * 
 * @author David J. Barnes and Michael Kölling
 * @version    2016.02.29
 */
public class GeradorArquivoDeLog
{
    private Random aleatorio;

    /**
     * Cria arquivos de log.
     */
    public GeradorArquivoDeLog()
    {
        aleatorio = new Random();
    }
    
    /**
     * Cria um arquivo de entradas de log aleatórias.
     * @param nomeArquivo O arquivo para escrita.
     * @param numeroEntradas Quantidade de entradas.
     * @return true em caso de sucesso, false caso contrário.
     */
    public boolean criarArquivo(String nomeArquivo, int numeroEntradas)
    {
        boolean sucesso = false;
        
        if(numeroEntradas > 0) {
            try (FileWriter gravador = new FileWriter(nomeArquivo)) {
                EntradaDeLog[] entradas = new EntradaDeLog[numeroEntradas];
                for(int i = 0; i < numeroEntradas; i++) {
                    entradas[i] = criarEntrada();
                }
                Arrays.sort(entradas);
                for(int i = 0; i < numeroEntradas; i++) {
                    gravador.write(entradas[i].toString());
                    gravador.write('\n');
                }
                
                sucesso = true;
            }
            catch(IOException e) {
                System.err.println("Houve um problema ao escrever em " + nomeArquivo);
            }
                
        }
        return sucesso;
    }
    
    /**
     * Cria uma única entrada (aleatória) para um arquivo de log.
     * @return Uma entrada de log contendo dados aleatórios.
     */
    public EntradaDeLog criarEntrada()
    {
        int ano = 2026;
        int mes = 1 + aleatorio.nextInt(12);
        // Evita as complexidades da quantidade de dias por mês.
        int dia = 1 + aleatorio.nextInt(28);
        int hora = aleatorio.nextInt(24);
        int minuto = aleatorio.nextInt(60);
        return new EntradaDeLog(ano, mes, dia, hora, minuto);
    }

}
