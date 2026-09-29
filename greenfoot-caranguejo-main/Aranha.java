import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aranha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aranha extends Actor
{
    /**
     * Act - do whatever the Aranha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Larva larvaAlvo;

    public void act()
    {
        move(2);
        tentarComer();
        if (larvaAlvo != null) {
            if (larvaAlvo.getWorld() != null) {
                turnTowards(larvaAlvo.getX(), larvaAlvo.getY());
            }
            else { 
                larvaAlvo = null;
            }
        }
        // se NÃO tem uma larva definida com o alvo
        if (larvaAlvo == null) {
            MundoDoCaranguejo mundoCaranguejo = getWorldOfType(MundoDoCaranguejo.class);
            larvaAlvo = mundoCaranguejo.buscarUmaLarva();
        }
    }

    private void movimentar()
    {
        move(2);
    }

    private void tentarComer()
    {
        Actor larva = getOneIntersectingObject(Larva.class);
        if (larva != null) {
            World world = getWorld();
            world.removeObject(larva);
            Greenfoot.playSound("comendo.wav");
        }
    }
}

