import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and RawQueryInfo)

/**
 * Bacteria fload along in the bloodstream. They are bad. Best to destroy
 * them if you can.
 * image of the mouse:https://en.wikipedia.org/wiki/RawQuery#/media/File:%D0%9C%D1%8B%D1%88%D1%8C_2.jpg
 * sound file:http://soundbible.com/1421-Strange-Slip.html
 */
public class RawQuery extends Actor
{
    private int speed;
    /**
     * Constructor. Nothing to do so far.
     */
    public RawQuery()
    {
        speed = Greenfoot.getRandomNumber(4)+1;

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
            serverRoom.addScore(-20);
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