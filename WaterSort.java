
/**
 * Write a description of class qwerty here.
 *
 * @author ()
 * @version ()
 */
import java.util.Scanner;
import java.util.Random;

public class WaterSort {
    Character top = null;
    // create constants for colors
    static Character red = new Character('r');
    static Character blue = new Character('b');
    static Character yellow = new Character('g');
    // Bottles declaration

    public static void showAll(StackAsMyArrayList bottles[]) {
        for (int i = 0; i <= 4; i++) {
            System.out.println("Bottle " + i + ": " + bottles[i]);
        }
    }

    public static void main(String args[]) {
        int moves = 0;// number of moves to mix the water
        int source = 0; // number of bottle to pour FROM
        int target = 0; // number of bottle to pour TO
        int max = 4; // total number of items allowed per bottle
        Random randomNum = new Random();
        // Bottles declaration
        StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
        // You can do this with a for also
        bottles[0] = new StackAsMyArrayList<Character>();
        bottles[1] = new StackAsMyArrayList<Character>();
        bottles[2] = new StackAsMyArrayList<Character>();
        bottles[3] = new StackAsMyArrayList<Character>();
        bottles[4] = new StackAsMyArrayList<Character>();

        ////// STRATEGY #1
        while (moves < 4) // 4 moves per 3 colors = 12 moves required
        {
            // get source bottle
            target = randomNum.nextInt(max + 1);
            while (bottles[target].getStackSize() == 4)// target is full
            {
                target = randomNum.nextInt(max);
            }
            bottles[target].push(blue);
            target = randomNum.nextInt(max + 1);
            while (bottles[target].getStackSize() == 4)// target is full
            {
                target = randomNum.nextInt(max);
            }
            bottles[target].push(red);
            target = randomNum.nextInt(max + 1);
            while (bottles[target].getStackSize() == 4)// target is full
            {
                target = randomNum.nextInt(max);
            }
            bottles[target].push(yellow);
            // showAll(bottles);
            // increment valid moves
            moves++;
        }

        theGame(bottles);
        solved(bottles);
        // showAll(bottles);
    }

    // new method
    public static boolean solved(StackAsMyArrayList bottles[]) {
        boolean game = true;
        int counter = 0;

        for (int i = 0; i < bottles.length; i++) {
            if (bottles[i].getStackSize() == 4 && bottles[i].checkStackUniform()) {
                counter = counter + 1;
            }
        }

        if (counter != 3) {
            game = false;
        } else
            game = true;

        return game;
    }

    // try to play the game-noy solving it yet
    public static void theGame(StackAsMyArrayList bottles[]) {
        int source = 0;
        int target = 0;

        Scanner player = new Scanner(System.in);
        // System.out.print("Enter Y to play the game,N if not playng:");
        char play = player.next().charAt(0);

        // if the user don't want to play
        // while(play != Character.toLowerCase('n'))
        // {
        // System.out.println(" ");

        // }

        while (!solved(bottles)) {
            showAll(bottles);
            System.out.print("Enter the source bottle: ");
            source = player.nextInt();
            System.out.print("Enter the target bottle: ");
            target = player.nextInt();

            if (bottles[target].getStackSize() < 4 && bottles[source].getStackSize() != 0) {
                if (bottles[source].peek() == bottles[target].peek() || bottles[target].getStackSize() == 0) {
                    bottles[target].push(bottles[source].pop());
                }
            }

        }
        showAll(bottles);
    }

    // public static void getAdjacent(StackAsMyArrayList bottles[])
    // {
    // for(int i =0;i<bottles.length;i++)
    // {
    // if the same
    // if(((Comparable)bottles[0]).compareTo(bottles[i]) ==0)
    // {
    // bottles.push();
    // }
    // }

}