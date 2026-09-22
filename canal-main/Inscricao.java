/**
 * Guarda os detalhes de uma inscrição em um Canal.
 * 
 * Traduzido por Julio César Alves - 2024.10.22
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Inscricao
{
    // O nome do inscrito
    private String nome;
    // O mês no qual a inscrição foi feita (1: janeiro, 2: fevereiro, etc.)
    private int mes;
    // O ano no qual a inscrição foi feita
    private int ano;

    /**
     * Construtor para os objetos da classe Inscricao.
     * @param nome O nome do inscrito.
     * @param mes O mês no qual ele se inscreveu. (1 ... 12)
     * @param ano O ano no qual ele se escreveu.
     */
    public Inscricao(String nome, int mes, int ano)
    {
        if(mes < 1 || mes > 12) {
            System.out.println(
                "Mês " + mes + " é inválido! Deve ser um número entre 1 e 12");
        }
        this.nome = nome;
        this.mes = mes;
        this.ano = ano;
    }
    
    /**
     * @return O nome do inscrito.
     */
    public String obterNome()
    {
        return nome;
    }
    
    /**
     * @return O mês no qual a inscrição foi feita.
     *         Um valor entre 1 e 12.
     */
    public int obterMes()
    {
        return mes;
    }

    /**
     * @return O mês no qual a inscrição foi feita.
     */
    public int obterAno()
    {
        return ano;
    }

    /**
     * @return Uma representação como String de uma inscrição.
     */
    public String paraString()
    {
        return "Nome: " + nome + " solicitou incriçao no canal no mês " +
                mes + " de " + ano;
    }
}
