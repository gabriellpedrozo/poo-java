import java.util.HashMap;

/**
 * Gerencia o estoque de uma empresa.
 * Um estoque é formado por zero ou mais produtos.
 * 
 * Traduzido por Julio César Alves - 2023.10.10
 * 
 * @author Gabriel Pedrozo Ribeiro  
 * @version 30/09/2026
 * 
 * Resposta exercicio 3: 
 * Vantagens do HashMap:
 * 1. A busca por ID é muito mais rápida, pois usa 'estoque.get(id)' sem precisar de laço 'for'.
 * 2. Impede automaticamente que existam produtos com IDs duplicados.
 * 
 * Vale a pena usar desde o início?
 * Sim, porque como o ID é usado em quase todas as operações do sistema, o modelo de 
 * Chave -> Valor do HashMap se encaixa perfeitamente desde o começo.
 */
public class GerenciadorDeEstoque
{
    // Uma lista dos produtos.
    private HashMap<Integer,Produto> estoquePorId;
    private HashMap<String, Produto> estoquePorNome;

    /**
     * Inicializa o gerenciador de estoque.
     */
    public GerenciadorDeEstoque()
    {
        estoquePorId = new HashMap<>();
        estoquePorNome = new HashMap<>();
    }

    /**
     * Adiciona um produto à lista.
     * @param item O item a ser adicionado.
     */
    public void adicionarProduto(Produto item)
    {
       if (item != null) {
            boolean idExiste = estoquePorId.containsKey(item.obterID());
            boolean nomeExiste = estoquePorNome.containsKey(item.obterNome());
            
            // Garante que o produto só será inserido se nem o ID nem o Nome forem duplicados
            if (!idExiste && !nomeExiste) {
                estoquePorId.put(item.obterID(), item);
                estoquePorNome.put(item.obterNome(), item);
            }
        }
    }

    /**
     * Tenta encontrar um produto no estoque com o identificador passado.
     * @param id O identificador do produto.
     * @return O produto identificado, ou null se não há nenhum produto com o ID.
     */
    public Produto encontrarProduto(int id)
    {
        // O HashMap busca diretamente a chave 
        return estoquePorId.get(id);
    }
    
    public Produto encontrarProduto(String nome)
    {
        return estoquePorNome.get(nome);
    }


    /**
     * Recebe uma entrega de um produto particular.
     * Aumenta a quantidade do produto pela quantidade passada.
     * @param id O identificador do produto.
     * @param quantidade A quantidade a ser aumentada do produto.
     */
    public void receberEntrega(int id, int quantidade)
    {
        Produto produto = encontrarProduto(id);
        if(produto != null){
            produto.aumentarQuantidade(quantidade);
        }
    }

    /**
     * Localiza um produto com o identificador passado, e retorna
     * quantas unidades dele existem no estoque. Retorna zero
     * se não há nenhum produto com o identificador passado.
     * @param id O identificador do produto.
     * @return A quantidade do produto solicitado em estoque.
     */
    public int quantidadeEmEstoque(int id)
    {
        Produto produto = encontrarProduto(id);
        if(produto != null){
            produto.obterQuantidade();
        }
        return 0;
    }

    /**
     * Exibe os detalhes de todos os produtos.
     */
    public void imprimirDetalhesDosProdutos(int limite)
    {
        for(Produto produto : estoquePorId.values()) {
            System.out.println(produto.paraString());
        }
    }

    public void imprimirProdutosComEstoqueBaixo(int limite){
        for(Produto produto : estoquePorId.values()) {
            if(produto.obterQuantidade() < limite) {
                System.out.println(produto.paraString());
            }
        }
    }

}
