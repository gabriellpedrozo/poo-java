/**
 * Uma classe que mantém informação de um livro.
 * Ela pode ser parte de uma aplicação mair como um sistema
 * de uma biblioteca, por exemplo.
 * 
 * @author (Digite seu nome aqui.)
 * @version (Insira o dia de hoje aqui.)
 *resposta 1.3 -- Sim, pois nao possui nenhum metodo que modifica o atributo
 *dos objetos
 */
class Livro
{
    // Os atributos.
    private String autor;
    private String titulo;
    private int paginas;
    private String numeroDeChamada;
    private int numeroEmprestimos;

    /**
     * Define os atributos autor e o título quando este
     * objeto é criado.
     */
    public Livro(String autorLivro, String tituloLivro, int numeropagina)
    {
        autor = autorLivro;
        titulo = tituloLivro;
        paginas = numeropagina;
        numeroDeChamada = ("");
        numeroEmprestimos = 0;
    }

    /**
      *Imprime o nome do autor no terminal
      */
    public void imprimirAutor ()
    {
        System.out.println(autor);
    }
    
    /**
      *Imprime o titulo do livro no terminal
      */
    public void imprimirTitulo()
    {
        System.out.println(titulo);
    }
    
    public int obterPagina()
    {
        return paginas;
    }
    
    public void imprimirDetalhes()
    {   
        System.out.println("###DETALHES###");
        System.out.println("#Titulo: " + titulo + ".");
        System.out.println("#Escrito por: " + autor + ".");
        System.out.println("#Pagina -" + paginas + "-");
        if(numeroDeChamada.length() > 0){
            System.out.println("#Numero de chamada: " + numeroDeChamada);
        }
        else{
            System.out.println("#Numero de chamada: NDEF");        
        }
        System.out.println("#Foi emprestado " + numeroEmprestimos + " vezes.");
    }
    
    
    public void definirNumeroDeChamada(String id)
    {
        if(id.length() < 3){
            System.out.println("Erro -  minimo 3 caracteres");
        }
        else{
            numeroDeChamada = id;
        }
    }
    
    public String obterNumeroDeChamada()
    {
        return numeroDeChamada;
    }
    
    public void emprestar()
    {
        numeroEmprestimos = numeroEmprestimos + 1;
    }
    
    public int obterEmprestimos()
    {
        return numeroEmprestimos;
    }
}
