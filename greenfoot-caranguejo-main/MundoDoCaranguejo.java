import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Escreva aqui uma descrição da classe MundoDoCarganguejo.
 * 
 * @author (seu nome) 
 * @version (um número de versão ou uma data)
 */
public class MundoDoCaranguejo extends World
{
    private boolean jogoTerminou;
    private int pontos;

    /**
     * Construtor para objetos da classe MundoDoCaranguejo.
     * 
     */
    public MundoDoCaranguejo()
    {   
        super(1000, 800, 1); 
        prepare();
        showText("Jogo do Caranguejo" , 200, 20);
        jogoTerminou = false;
    }

    public void act()
    {
        if(!jogoTerminou){
            List<Larva> larvas = getObjects(Larva.class);
            List<Caranguejo> caranguejos = getObjects(Caranguejo.class);
            List<Peixe> peixes = getObjects(Peixe.class);
            if(larvas.size() == 0){
                showText("BOOYAH", 200, 300);
                jogoTerminou = true;
                Greenfoot.playSound("win.wav");
            }

            if(caranguejos.size() == 0 && peixes.size() == 0){
                showText("GAME OVER :(", 200, 300);
                jogoTerminou = true;
                Greenfoot.playSound("defeat.wav");
            }
        }
    }

    public void contarPontos()
    {
        pontos += 10;
        showText("Placar: " + pontos + " pontos", 200, 50);
    }

    public Larva buscarUmaLarva(){
        List<Larva> larvas = getObjects(Larva.class);
        if(larvas.size() > 0) {
            int posicao = Greenfoot.getRandomNumber(larvas.size());
            return larvas.get(posicao);
        }
        return null;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Caranguejo caranguejo = new Caranguejo();
        addObject(caranguejo,491,404);
        Larva larva = new Larva();
        addObject(larva,95,413);
        Larva larva2 = new Larva();
        addObject(larva2,106,260);
        Larva larva3 = new Larva();
        addObject(larva3,793,244);
        Larva larva4 = new Larva();
        addObject(larva4,797,466);
        Larva larva5 = new Larva();
        addObject(larva5,156,631);
        Larva larva6 = new Larva();
        addObject(larva6,336,354);
        Larva larva7 = new Larva();
        addObject(larva7,435,86);
        Larva larva8 = new Larva();
        addObject(larva8,829,83);
        Larva larva9 = new Larva();
        addObject(larva9,211,122);
        Larva larva10 = new Larva();
        addObject(larva10,749,679);
        Larva larva11 = new Larva();
        addObject(larva11,348,699);
        Larva larva12 = new Larva();
        addObject(larva12,602,611);
        Lagosta lagosta = new Lagosta();
        addObject(lagosta,56,564);
        Lagosta lagosta2 = new Lagosta();
        addObject(lagosta2,78,134);
        Aranha aranha = new Aranha();
        addObject(aranha,58,372);
        Peixe peixe = new Peixe();
        addObject(peixe,483,300);
    }
    
}
