import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Um modelo simples de um servidor de e-mail. O servidor 
 * consegue receber mensagens de e-mail para guardar e entregá-las
 * aos clientes sob demanda.
 *  
 * Traduzido por Julio César Alves. 2023.09.22
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class ServidorDeEmail
{
    // Guarda uma quantidade arbitrária de mensagens de e-mail
    private List<Email> emails;

    /**
     * Constrói um servidor de e-mail.
     */
    public ServidorDeEmail()
    {
        emails = new ArrayList<>();
    }

    /**
     * Retorna quantas mensagens de e-mail estão esperando
     * para serem coletadas por um usuário.
     * @param usuario O usuário destinatário das mensagens.
     * @return Quantas mensagens de e-mail existem.
     */
    public int quantosEmails(String usuario)
    {
        int contador = 0;
        for(Email email : emails) {
            if(email.obterDestinatario().equals(usuario)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Retorna a próxima mensagem de e-mail para um usuário ou
     * null se não há nenhuma.
     * @param usuario O usuário que está buscando sua próxima mensagem.
     * @return O próximo e-mail do usuário.
     */
    public Email obterProximoEmail(String usuario)
    {
        Iterator<Email> it = emails.iterator();
        while(it.hasNext()) {
            Email item = it.next();
            if(item.obterDestinatario().equals(usuario)) {
                it.remove();
                return item;
            }
        }
        return null;
    }

    /**
     * Adiciona a mensagem de e-mail passada na lista de mensagens.
     * @param email O e-mail a ser armazenado no servidor.
     */
    public void postar(Email email)
    {
        emails.add(email);
    }
}
