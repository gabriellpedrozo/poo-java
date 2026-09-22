
/**
 * Fornece uma demonstração das classe Canal e Inscricao.
 * 
 * @author (seu nome)
 * @version (um número de versão ou uma data)
 */
public class DemonstracaoCanal
{
    // atributos - substitua o exemplo abaixo pelo seu próprio exemplo
    private Canal canal;

    /**
     * Construtor de objetos da classe DemonstracaoCanal
     */
    public DemonstracaoCanal()
    {
        canal = new Canal();
    }

    /**
     * Inscreve alguns membros no canal, e então mostra quantos eles são.
     * Outras chamadas podem ser acrescentadas se novas funcionalidades
     * fora implementadas na classe Canal.
     */
    public void demonstrar()
    {
        canal.inscrever(new Inscricao("Davi", 2, 2024));
        canal.inscrever(new Inscricao("Michel", 1, 2024));
        System.out.println("O canal tem " +
                           canal.quantidadeDeInscritos() +
                           " inscritos.");
    }
}
