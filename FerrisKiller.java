import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 * image of the dog:https://en.wikipedia.org/wiki/FerrisKiller#/media/File:Collage_of_Nine_FerrisKillers.jpg
 */
public class FerrisKiller extends Actor
{
    /**
     * Act - do whatever the Virus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-4, getY());
        //speed = Greenfoot.getRandomNumber(0)+1;
        //turn(-1);
        checkeat();
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }
    private void checkeat()
    {
        if (isTouching(Orm.class))
        {
            removeTouching(Orm.class);
            ServerRoom serverRoom = (ServerRoom)getWorld();
            Greenfoot.playSound("glass.wav");
        }
    }
}
