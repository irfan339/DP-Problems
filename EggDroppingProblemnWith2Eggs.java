import java.io.*;

class EggDroppingProblemnWith2Eggs
{
    static int twoEggDrop(int n)
    {
        return (int)Math.ceil((-1.0 +
                    Math.sqrt(1 + 8 * n)) / 2.0);
    }

    public static void main (String[] args)
    {
        int n = 30;
        System.out.println(twoEggDrop(n));
    }
}
