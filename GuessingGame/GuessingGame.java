/*
Felix Chen
SDEV 218

This program will contain 5 random numbers and asks the user to guess any of the 5 numbers.
Will also ask user if they want to play again and track statistics like games played and
guesses made, then shows average guesses per game.
 */
import java.util.*;


public class GuessingGame {

    public static void main(String[] args) {
        guessingGame();
    }

    // constant for the max a random number can be
    public static final int MAXNUM = 10;

    // makes 5 random numbers and puts it into an array
    public static int[] randomNums(int size) {

        // error check
        if (size < 0) {
            throw new IllegalArgumentException();
        }

        // new array
        int[] array = new int[size];

        // random num gen
        Random num = new Random();

        // loops through and adds num to array
        for (int i = 0; i < size; i++) {
            array[i] = num.nextInt(MAXNUM) + 1;
        }
        return array;
    }

    // loops to run the guessing game and counts number of guesses made and games played
    public static void guessingGame() {

        boolean continueGame = true;
        boolean match = false;
        int guesses = 0;
        int games = 0;
        String text = "";

        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of five numbers between 1 and " + MAXNUM);
        System.out.println("and will allow you to guess until you identify one of");
        System.out.println("the five numbers.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        while (continueGame) {
            int[] array = randomNums(5);
            int currentGuesses = 0;
//            System.out.println(Arrays.toString(array));
            System.out.println("I'm thinking of five numbers between 1 and " + MAXNUM + "...");
            do {
                System.out.print("Your guess? ");
                int num = console.nextInt();
                guesses++;
                currentGuesses++;

                for (int i = 0; i < array.length; i++) {
                    if (num == array[i]) {
                        System.out.println("You guessed correctly in " + currentGuesses + " guesses");
                        console.nextLine();
                        match = true;
                        break;
                    }
                }
                if (!match) {
                    System.out.println("That's incorrect.");
                }
            } while (!match);
            games++;
            System.out.print("Do you want to play again? ");
            text = console.nextLine();
            if (text.equalsIgnoreCase("no")) {
                continueGame = false;
            }
            else if (text.equalsIgnoreCase("yes")) {
                match = false;
            }
        }
        double dblGuesses = guesses;
        double dblGames = games;
        double avg = guesses/games;

        System.out.println("Game Statistics: ");
        System.out.println("\t Total games = " + games);
        System.out.println("\t Total guesses = " + guesses);
        System.out.println("\t Average guesses per game = " + avg);
    }
}

/*
What parts of the assignment were the easiest to complete?
Making the random number method

What are some things that went wrong when completing this assignment?
Trial and error with loops to make the game keep going

How did you deal with these setbacks?
Google and youtube and trial and error

About how many hours did you spend working on this assignment?
1.5 hours
 */

/* OUTPUT!!!!!!!
This program allows you to play a guessing game.
I will think of five numbers between 1 and 10
and will allow you to guess until you identify one of
the five numbers.

I'm thinking of five numbers between 1 and 10...
Your guess? 2
You guessed correctly in 1 guesses
Do you want to play again? yes
I'm thinking of five numbers between 1 and 10...
Your guess? 5
You guessed correctly in 1 guesses
Do you want to play again? no
Game Statistics:
	 Total games = 2
	 Total guesses = 2
	 Average guesses per game = 1.0
 */