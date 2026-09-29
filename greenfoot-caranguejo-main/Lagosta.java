import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lagosta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lagosta extends Actor
{
    /**
     * Act - do whatever the Lagosta wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimentar();
        tentarComer();
    }

    private void movimentar(){
        move(4);
        if(Greenfoot.getRandomNumber(100) < 10){
            int angulo = Greenfoot.getRandomNumber(90) - 45;
            turn(angulo);
        }
        if(isAtEdge())
        {
        }
    }

    private void tentarComer()
    {
        Actor caranguejo = getOneIntersectingObject(Caranguejo.class);
        Actor peixe = getOneIntersectingObject(Peixe.class);
        if(caranguejo != null){
            World world = getWorld();
            world.removeObject(caranguejo);
            Greenfoot.playSound("lose.wav");

        }
        
        if(peixe != null){
            World world = getWorld();
            world.removeObject(peixe);
            Greenfoot.playSound("lose.wav");

        }
    }
}
