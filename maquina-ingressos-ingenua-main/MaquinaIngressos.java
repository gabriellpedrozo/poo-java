/**
 * MaquinaIngressos modela uma máquina de ingressos ingênua que
 * emite ingressos de preço fixo.
 * O preço de um ingresso é definido através do construtor.
 * É uma máquina ingênua porque ela confia que os clientes
 * colocarão a quantidade de dinheiro suficiente antes de tentar
 * emitir um ingresso.
 * Ela também assume que os clientes colocarão quantidades
 * razoáveis.
 * 
 * Traduzido por Julio César Alves - 2023-08-31
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
import java.util.Locale;

public class MaquinaIngressos
{
    // O preço de um ingresso desta máquina
    private int preco;
    // A quantidade de dinheiro que o usuário colocou até o momento.
    private int saldo;
    // A quantidade total de dinheiro coletada pela máquina.
    private int total;
    // O nome da empresa que vende o ingresso.
    private String nomeEmpresa;
    // O nome do comprador do ingresso.
    private String nomeComprador;

    /**
     * Cria uma máquina que emite ingressos de um dado preço.
     * Note que o preço deve ser maior que zero, e não tem
     * nenhuma verificação para garantir isso.
     */
    public MaquinaIngressos(String empresa)
    {
        //Agora, quando cria uma maquina não é mais necessario informar o 
        //preco do ingresso, pois ele é fixo em 1000 centavos (R$10,00)
        preco = 1000;
        nomeEmpresa = empresa;
        saldo = 0;
        total = 0;
    }

        public MaquinaIngressos(int custoIngresso, String empresa)
    {
        /* Agora é possível criar a máquina de duas formas ou com valor fixo 
         * que é o padrão definido no construtor acima ou informando o valor 
         * neste construtor
         */
        preco = custoIngresso;
        nomeEmpresa = empresa;
        saldo = 0;
        total = 0;
    }
    
    /**
     * Retorna o preço do ingresso.
     */
    public int obterPreco()
    {
        return preco;
    }

    /**
     * Retorna a quantidade de dinheiro já inserida para o
     * próximo ingresso.
     */
    public int obterSaldo()
    {
        return saldo;
    }

    /**
     * Recebe uma quantidade de dinheiro de um cliente.
     */
    public void inserirDinheiro(int quantidade)
    {
        saldo = saldo + quantidade;
    }
    
    /**
     *Metodo de acesso, porque retorna o valor do atributo total 
     * nao modificando o conteudo 
     */
    public int obterTotal()
    {
        return total;
    }
    
    /**
     * Metodo modificador, pois altera o valor do total para zero
     * modifica o conteudo
     */
    public void esvaziar()
    {
        total = 0;
    }
    
    /**
     * Metodo de acesso, retorna o nome da empresa que vende os ingressos 
     * nao modifica o conteudo
     */
    public String obterNome()
    {
        return nomeEmpresa;
    }

    /**
     * Imprime um ingresso.
     * Atualiza o total coletado e reduz o saldo para zero.
     * Adiciona o nome do comprador no ingresso
     */
    public void imprimirIngresso(String nomeComprador)
    {
        // Simula a impressão de um ingresso
        System.out.println("##################");
        System.out.println("#" + nomeEmpresa + " ");
        System.out.println("#" + nomeComprador + " ");
        System.out.println("# Ingresso");
        System.out.printf(new Locale("pt", "BR"), "# R$ %.2f%n", preco/100.0);
        System.out.println("##################");
        System.out.println();

        // Atualiza o total coletado com o saldo
        total = total + saldo;
        // Zera o saldo
        saldo = 0;
    }
}
