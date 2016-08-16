public class KnightDriver
{
    public static void main(String[] args)
    {
        Knight myKnight = new Knight();
        Stars myStars = new Stars();
        myKnight.Input();
        myStars.Input();
        myKnight.Output();
        myStars.createSky();
    }
}