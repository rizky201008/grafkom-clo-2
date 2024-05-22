import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Orm here.
 * images:https://en.wikipedia.org/wiki/File:Orm.png
 */
public class Orm extends Actor
{
    private int speed;
    /**
     * Act - do whatever the Orm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Orm() 
    {
        speed = Greenfoot.getRandomNumber(2)+1;
    }    

    /**
     * Float along the bloodstream, slowly rotating.
     */
    public void act()
    {
        setLocation(getX()+speed, getY());
        //turn(1);

        if (getX() == 660) 
        {
            getWorld().removeObject(this);
        }
    }
}