import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and RawQueryInfo)

/**
 * This is a white blood cell. This kind of cell has the job to catch 
 * bacteria and remove them from the blood.
 * image of the cat:https://en.wikipedia.org/wiki/Cat#/media/File:Cat_poster_1.jpg
 * sound files:
 * http://soundbible.com/2194-Doberman-Pinscher.html
 * http://soundbible.com/1687-TomCat.html
 * http://soundbible.com/1744-Shooting-Star.html
 * http://soundbible.com/1948-Slap.html
 * http://soundbible.com/2084-Glass-Ping.html
 */
public class PhpElephant extends Actor
{
    private int score;
    private int point;
    /**
     * Act: move up and down when cursor keys are pressed.
     */
    public void act() 
    {
        checkKeyPress();
        checkCollision();
    }

    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-5);
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+5);
        }
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-5, getY());
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+5, getY());
        }
        if (Greenfoot.isKeyDown("w")) 
        {
            setLocation(getX(), getY()-5);
        }
        if (Greenfoot.isKeyDown("s")) 
        {
            setLocation(getX(), getY()+5);
        }
        if (Greenfoot.isKeyDown("a")) 
        {
            setLocation(getX()-5, getY());
        }
        if (Greenfoot.isKeyDown("d")) 
        {
            setLocation(getX()+5, getY());
        }
    }

    private void checkCollision()
    {
        if (isTouching(RawQuery.class))
        {
            Greenfoot.playSound("RawQuery Eat.wav");
            removeTouching(RawQuery.class);
            ServerRoom serverRoom = (ServerRoom)getWorld();
            serverRoom.addScore(30);
        }
        if (isTouching(FerrisKiller.class))
        {
            removeTouching(FerrisKiller.class);
            Greenfoot.playSound("Dog Bark.wav");
            ServerRoom serverRoom = (ServerRoom)getWorld();
            serverRoom.addScore(-30);   
        }
        if (isTouching(Orm.class))
        {
            removeTouching(Orm.class);
            ServerRoom serverRoom = (ServerRoom)getWorld();
            serverRoom.addScore(10);
            Greenfoot.playSound("glass.wav");
        }
        if (isTouching(Cheese.class))
        {
            Greenfoot.playSound("Slap.wav");
            removeTouching(Cheese.class);
            ServerRoom serverRoom = (ServerRoom)getWorld();
            serverRoom.addScore(100);
        }
    }
}