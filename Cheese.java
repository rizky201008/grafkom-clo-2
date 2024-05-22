import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Human here.
 * Link of image:https://www.pexels.com/photo/animal-cute-little-mouse-301448/
 */
public class Cheese extends Actor
{
    private int speed;
    /**
     * Constructor. Nothing to do so far.
     */
    public Cheese()
    {
        speed = Greenfoot.getRandomNumber(10)+1;

        //setRotation(Greenfoot.getRandomNumber(360));
    }

    /**
     * Float along the bloodstream, slowly rotating.
     */
    public void act() 
    {
        setLocation(getX()-speed, getY());
        checktouch();
        checkend();
        //turn(1);

        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }

    private void checkend()
    {
        if(getX() == 0)
        {
            ServerRoom serverRoom = (ServerRoom)getWorld();
            serverRoom.addScore(-100);
        }
    }

    private void checktouch()
    {
        if (isTouching(Orm.class))
        {
            Greenfoot.playSound("RawQuery Eat.wav");
            removeTouching(Orm.class);
            ServerRoom serverRoom = (ServerRoom)getWorld();
            serverRoom.addScore(-5);
        }
    }
}