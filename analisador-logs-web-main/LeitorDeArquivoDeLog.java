import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Classe para ler informações de um arquivo de log de acessos a um servidor web.
 * Atualmente, assume-se que o arquivo de log contenha apenas
 * informações de data e hora no formato:
 *
 *    ano mes dia hora minuto
 * As entradas de log são ordenadas em ordem crescente de data.
 * 
 * Traduzido por Julio César Alves - 2026-09-26
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LeitorDeArquivoDeLog implements Iterator<EntradaDeLog>
{
    // O formato de dados no arquivo de log.
    private String formato;
    // Onde o conteúdo do arquivo é armazenado na forma
    // de objetos LogEntry.
    private ArrayList<EntradaDeLog> entradas;
    // Iterador sobre as entradas.
    private Iterator<EntradaDeLog> iteradorDados;
    
    /**
     * Cria um LeitorDeArquivoDeLog para fornecer dados de um arquivo padrão.
     */
    public LeitorDeArquivoDeLog()
    {
        this("weblog.txt");
    }
    
    /**
     * Cria um LeitorDeArquivoDeLog que fornecerá dados
     * de um arquivo de log específico.
     * @param nomeArquivo O arquivo de dados de log.
     */
    public LeitorDeArquivoDeLog(String nomeArquivo)
    {
        // Formato dos dados.
        formato = "Ano Mes(1-12) Dia Hora Minuto";
        // Onde armazenar os dados.
        entradas = new ArrayList<>();
        TokenizadorLinhaLog tokenizador = new TokenizadorLinhaLog();        
        
        // Tenta ler o conjunto completo de dados do arquivo.
        boolean dadosLidos;
        try{
            // Localiza o arquivo no ambiente atual.
            URL urlArquivo = getClass().getClassLoader().getResource(nomeArquivo);
            if(urlArquivo == null) {
                throw new FileNotFoundException(nomeArquivo);
            }
            Scanner arquivoLog = new Scanner(new File(urlArquivo.toURI()));
            // Lê as linhas de dados até o fim do arquivo.
            while(arquivoLog.hasNextLine()) {
                String linhaLog = arquivoLog.nextLine();
                // Quebra a linha, cria uma entrada de log e a adiciona à lista de entradas.
                EntradaDeLog entrada = tokenizador.tokenizar(linhaLog);
                entradas.add(entrada);
            }
            arquivoLog.close();
            dadosLidos = true;
        }
        catch(FileNotFoundException | URISyntaxException e) {
            System.out.println("Problema encontrado: " + e);
            dadosLidos = false;
        }
        // Se não foi possível ler o arquivo de log, usa dados simulados.
        if(!dadosLidos) {
            System.out.println("Falha ao ler o arquivo de dados: " + nomeArquivo);
            System.out.println("Usando dados simulados no lugar.");
            criarDadosSimulados(entradas);
        }
        // Ordena as entradas em ordem crescente.
        Collections.sort(entradas);
        reiniciar();
    }
    
    /**
     * O leitor possui mais dados para fornecer?
     * @return true se houver mais dados disponíveis,
     *         false caso contrário.
     */
    public boolean hasNext()
    {
        return iteradorDados.hasNext();
    }
    
    /**
     * Analisa a próxima linha do arquivo de log e
     * a disponibiliza por meio de um objeto LogEntry.
     * 
     * @return Uma LogEntry contendo os dados da
     *         próxima linha de log.
     */
    public EntradaDeLog next()
    {
        return iteradorDados.next();
    }
    
    /**
     * Remove uma entrada.
     * Esta operação não é permitida.
     */
    public void remove()
    {
        System.err.println("Não é permitido remover entradas.");
    }
    
    /**
     * @return String que explica o formato dos dados
     *         no arquivo de log.
     */
    public String obterFormato()
    {
        return formato;
    }
    
    /**
     * Configura um iterador novo para fornecer acesso aos dados.
     * Isso permite processar um único arquivo de dados
     * mais de uma vez.
     */
    public void reiniciar()
    {
        iteradorDados = entradas.iterator();
    }

    /**
     * Imprime os dados.
     */    
    public void imprimirDados()
    {
        for(EntradaDeLog entrada : entradas) {
            System.out.println(entrada);
        }
    }

    /**
     * Fornece uma amostra de dados simulados.
     * Obs.: Para simplificar a criação destes dados, nenhum
     * dia após o 28º de um mês é gerado.
     * @param dados Onde armazenar os objetos LogEntry simulados.
     */
    private void criarDadosSimulados(ArrayList<EntradaDeLog> dados)
    {
        GeradorArquivoDeLog gerador = new GeradorArquivoDeLog();
        // Quantidade de entradas simuladas desejada.
        int numeroEntradas = 100;
        for(int i = 0; i < numeroEntradas; i++) {
            dados.add(gerador.criarEntrada());
        }
    }
}
