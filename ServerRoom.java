import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and RawQueryInfo)

/**
 * The bloodstream is the setting for our White Blood Cell scenario. 
 * It's a place where blood cells, bacteria and viruses float around.
 * images:https://en.wiktionary.org/wiki/ServerRoom#/media/File:Modern_ServerRoom.jpg
 */
public class ServerRoom extends World
{
    private int score;
    private int time;
    /**
     * Constructor: Set up the staring objects.
     */
    public ServerRoom()
    {    
        super(680, 510, 1); 
        prepare();
        setPaintOrder(ServerRack.class);
        score = 0;
        time = 3000;
        showScore();
        showTime();
    }

    /**
     * Create new floating objects at irregular intervals.
     */
    public void act()
    {
        if (Greenfoot.getRandomNumber(400) < 6)
        {
            addObject(new RawQuery(), 680, Greenfoot.getRandomNumber(510));
        }
        if (Greenfoot.getRandomNumber(400) < 2)
        {
            addObject(new FerrisKiller(), 680, Greenfoot.getRandomNumber(510));
        }
        if (Greenfoot.getRandomNumber(250) < 1)
        {
            addObject(new Orm(), 0, Greenfoot.getRandomNumber(510));
        }
        if (Greenfoot.getRandomNumber(2000) < 1)
        {
            addObject(new Cheese(), 680, Greenfoot.getRandomNumber(510));
        }
        countTime();
    }

    public void addScore(int points)
    {
        score = score + points;
        showScore();
        if (score < 0) 
        {
            Greenfoot.playSound("Lose.wav");
            Greenfoot.stop();
        }
    }

    private void showScore()
    {
        showText("Score: " + score, 80, 25);
    }

    /**
     * Prepare the world for the start of the program. In this case: Create
     * a white blood cell and the lining at the edge of the blood stream.
     */
    private void prepare()
    {
        PhpElephant phpElephant = new PhpElephant();
        addObject(phpElephant, 83, 300);
        ServerRack serverRack = new ServerRack();
        addObject(serverRack,50,255);
        setPaintOrder(ServerRack.class);

    }


    private void showTime()
    {
        showText("Time: " + time, 600, 25);
    }

    private void countTime()
    {
        time--;
        showTime();
        if (time <= 0)
        {
            showEndMessage();
            Greenfoot.stop();
        }
    }

    private void showEndMessage()
    {
        Greenfoot.playSound("Win.wav");
        showText("Time is up - you win!", 390, 150);
        showText("Your final score: " + score + " points", 390, 170);
    }
}
