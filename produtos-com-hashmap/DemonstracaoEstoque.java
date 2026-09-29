/**
 * Demonstra as classe GerenciadorDeEstoque e Produto.
 * A demonstração funciona corretamente se a classe
 * GerenciadorDeEstoque for completada.
 * 
 * Traduzido por Julio César Alves - 2023.10.10
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class DemonstracaoEstoque
{
    // O gerenciador de estoque.
    private GerenciadorDeEstoque gerenciador;

    /**
     * Cria um GerenciadorDeEstoque e o popula com alguns novos
     * produtos de exemplo.
     */
    public DemonstracaoEstoque()
    {
        gerenciador = new GerenciadorDeEstoque();
        gerenciador.adicionarProduto(new Produto(132, "Notebook"));
        gerenciador.adicionarProduto(new Produto(37,  "Smartphone"));
        gerenciador.adicionarProduto(new Produto(23,  "Forno Microondas"));
    }
    
    /**
     * Fornece uma demonstração muito simples de como um GerenciadorDeEstoque
     * pode ser usado. Detalhes de um produto são mostrados, o produto
     * é reposto no estoque, e então os detalhes são exibidos de novo.
     */
    public void demonstracao()
    {
        // Mostra os detalhes de todos os produtos.
        gerenciador.imprimirDetalhesDosProdutos();
        // Recebe a entrega de 5 itens de um dos produtos.
        gerenciador.receberEntrega(132, 5);
        gerenciador.imprimirDetalhesDosProdutos();
    }
    
    /**
     * Mostra os detalhes de um dado produto. Se encontrado,
     * seu nome e quantidade em estoque são exibidos.
     * @param id O identificador do produto a ser procurado.
     */
    public void mostrarDetalhes(int id)
    {
        Produto produto = obterProduto(id);
        if(produto != null) {
            System.out.println(produto.paraString());
        }
    }
    
    /**
     * Vende uma unidade do produto solicitado.
     * Mostra os detalhes do produto antes e depois da venda.
     * @param id O identificador do produto que está sendo vendido.
     */
    public void venderProduto(int id)
    {
        Produto produto = obterProduto(id);
        
        if(produto != null) {
            mostrarDetalhes(id);
            produto.venderUm();
            mostrarDetalhes(id);
        }
    }
    
    /**
     * Obtém do gerenciador o produto com o identificador passado.
     * Exibe uma mensagem de erro se o produto não for encontrado.
     * @param id O identificador do produto.
     * @return O produto, ou null se não for encontrado.
     */
    public Produto obterProduto(int id)
    {
        Produto produto = gerenciador.encontrarProduto(id);
        if(produto == null) {
            System.out.println("Produto com identificador: " + id +
                               " não encontrado!.");
        }
        return produto;
    }

    /**
     * @return O GerenciadorDeEstoque.
     */
    public GerenciadorDeEstoque obterGerenciador()
    {
        return gerenciador;
    }
}
