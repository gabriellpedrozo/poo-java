import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Caranguejo extends Actor
{
    /**
     * Act - faz o que o Caranguejo queira fazer.
     * Este método é chamado sempre que o botão 'Executar' ou
     * 'Executar uma vez' é chamado no ambiente.
     */
    public void act() 
    {
        movimentar();
        tentarComer();
    }    

    private void movimentar()
    {
        move(4);
        if(Greenfoot.isKeyDown("left")){
            turn(3);
        }
        if(Greenfoot.isKeyDown("right")){
            turn(-3);
        }
    }

    private void tentarComer()
    {
        Actor larva = getOneIntersectingObject(Larva.class);
        if (larva != null) {
            World world = getWorld();
            world.removeObject(larva);
            Greenfoot.playSound("comendo.wav");
            
            MundoDoCaranguejo mundo = (MundoDoCaranguejo) world;
            if (mundo != null) {
                mundo.contarPontos();
            }
        }
    }
}

