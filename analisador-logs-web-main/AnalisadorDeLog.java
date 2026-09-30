/**
 * Lê dados de servidor web e analisa padrões de acesso por hora.
 * 
 * Traduzido por Julio César Alves - 2026-09-26
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class AnalisadorDeLog
{
    // Onde calcular as contagens de acesso por hora.
    private int[] contagensPorHora;
    // Usa um LeitorDeArquivoDeLog para acessar os dados.
    private LeitorDeArquivoDeLog leitor;
    private int[] contagensPorDia;

    /**
     * Cria um objeto para analisar acessos web por hora.
     */
    public AnalisadorDeLog()
    { 
        // Cria o objeto array para armazenar as
        // contagens de acesso por hora.
        contagensPorHora = new int[24];
        contagensPorDia = new int[8];
        // Cria o leitor para obter os dados.
        leitor = new LeitorDeArquivoDeLog();
    }

    public AnalisadorDeLog(String nomeDoArquivo)
    {
        contagensPorHora = new int[24];
        contagensPorDia = new int[8];
        leitor = new LeitorDeArquivoDeLog(nomeDoArquivo);
    }

    /**
     * Analisa os dados de acesso por hora do arquivo de log.
     */
    public void analisarDadosPorHora()
    {
        while(leitor.hasNext()) {
            EntradaDeLog entrada = leitor.next();
        
            int hora = entrada.obterHora();
            contagensPorHora[hora]++;
            
            int dia = entrada.obterDiaDaSemana();
            contagensPorDia[dia]++;
        }
    }

    /**
     * Imprime as contagens por hora.
     * Elas devem ter sido definidas com uma chamada
     * anterior de analisarDadosPorHora.
     */
    public void imprimirContagensPorHora()
    {
        System.out.println("Hora: Contagem");
        for(int hora = 0; hora < contagensPorHora.length; hora++) {
            System.out.println(hora + ": " + contagensPorHora[hora]);
        }
    }

    /**
     * Imprime as linhas de dados lidas pelo LeitorArquivoLog.
     */
    public void imprimirDados()
    {
        leitor.imprimirDados();
    }

    public int numeroDeAcessos()
    {
        int total = 0;
        for(int hora : contagensPorHora)
        {
            total += hora;
        }
        return total;
    }

    public int horaMaisOcupada()
    {
        int horaMaisOcupada = 0;
        for (int hora = 1; hora < contagensPorHora.length; hora++) {
            if (contagensPorHora[hora] > contagensPorHora[horaMaisOcupada]) {
                horaMaisOcupada = hora;
            }
        }
        return horaMaisOcupada;
    }

    public int horaMaisTranquila()
    {
        int horaMaisTranquila = 0;
        for (int hora = 1; hora < contagensPorHora.length; hora++) {
            if (contagensPorHora[hora] < contagensPorHora[horaMaisTranquila]) {
                horaMaisTranquila = hora;
            }
        }
        return horaMaisTranquila;
    }

    public int duasHorasSeguidasMaisOcupadas()
    {
        int horaInicio = 0;
        int maiorSoma = contagensPorHora[0] + contagensPorHora[1];
        for (int hora = 1; hora < contagensPorHora.length - 1; hora++) {

            int somaAtual = contagensPorHora[hora] + contagensPorHora[hora + 1];

            if (somaAtual > maiorSoma) {
                maiorSoma = somaAtual; 
                horaInicio = hora;
            }
        }
        return horaInicio;
    }
    
    public void imprimirContagensPorDia()
    {
        System.out.println("Dia da Semana: Contagem");
        
        for(int dia = 1; dia < contagensPorDia.length; dia++) {
            System.out.println(dia + ": " + contagensPorDia[dia]);
        }
    }

    public int diaMaisOcupado()
    {
        int diaMaisOcupado = 1; 
        for (int dia = 2; dia < contagensPorDia.length; dia++) {
            if (contagensPorDia[dia] > contagensPorDia[diaMaisOcupado]) {
                diaMaisOcupado = dia;
            }
        }
        return diaMaisOcupado;
    }

    
    public int diaMaisTranquilo()
    {
        int diaMaisTranquilo = 1;
        for (int dia = 2; dia < contagensPorDia.length; dia++) {
            if (contagensPorDia[dia] < contagensPorDia[diaMaisTranquilo]) {
                diaMaisTranquilo = dia;
            }
        }
        return diaMaisTranquilo;
    }
}

