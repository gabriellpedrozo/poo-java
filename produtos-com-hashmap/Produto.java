/**
 * Modela alguns detalhes de um produto vendido por uma empresa.
 * 
 * Traduzido por Julio César Alves - 2023.10.10
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Produto
{
    // Um número identificador para esse produto
    private int id;
    // O nome deste produto
    private String nome;
    // A quantidade deste produto em estoque
    private int quantidade;

    /**
     * Construtor para objetos da classe Produto.
     * A quantidade inicial de produto em estoque é zero.
     * @param id O número identificador do produto.
     * @param nome O nome do produto.
     */
    public Produto(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
        quantidade = 0;
    }

    /**
     * @return O identificador do produto.
     */
    public int obterID()
    {
        return id;
    }

    /**
     * @return O nome do produto.
     */
    public String obterNome()
    {
        return nome;
    }

    /**
     * @return A quantidade em estoque.
     */
    public int obterQuantidade()
    {
        return quantidade;
    }

    /**
     * @return O identificador, o nome e a quantidade
     */
    public String paraString()
    {
        return id + ": " +
               nome +
               " nível do estoque: " + quantidade;
    }

    /**
     * Repõe o estoque com a quantidade de produto passada.
     * A quantidade atual é incrementada pela quantidade passada.
     * @param quantidade O número de novos itens adicionados ao estoque.
     *               Deve ser maior que zero.
     */
    public void aumentarQuantidade(int quantidade)
    {
        if(quantidade > 0) {
            this.quantidade += quantidade;
        }
        else {
            System.out.println("Tentativa de repor " +
                               nome +
                               " com uma quantidade negativa: " +
                               quantidade);
        }
    }

    /**
     * Vende um destes produtos.
     * Um erro é reportado se não há produto no estoque.
     */
    public void venderUm()
    {
        if(quantidade > 0) {
            quantidade--;
        }
        else {
            System.out.println(
                "Tentativa de vender um item sem estoque: " + nome);
        }
    }
}
