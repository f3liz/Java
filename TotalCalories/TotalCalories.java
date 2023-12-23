/*
This program will calculate average calories of any # of meals over 2 days
Author: Felix Chen
SDEV 218
Core topics: scanner and methods
*/

import java.util.*;

public class TotalCalories {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        calcCalories(console);
    }

    // This method contains all the other methods that will help calculate calories
    public static void calcCalories(Scanner console){
        // # of meals day 1
        int meals = dayOne(console);

        // calories for day 1
        int calories = getCalories(meals, console);

        // total calories day 1
        totalCalories(calories);

        // # of meals day 2
        int mealsTwo = dayTwo(console);

        // calories for day 2
        int caloriesTwo = getCalories(mealsTwo, console);

        // total calories day 2
        totalCalories(caloriesTwo);

        // average calories
        avgCalories(calories, caloriesTwo);
    }

    // receives the number of meals for day 1
    public static int dayOne(Scanner console){
        System.out.println("Information for Day #1:");
        System.out.print("\t\tHow many meals did you eat? ");
        return console.nextInt();
    }

    // receives number of meals for day 2
    public static int dayTwo(Scanner console){
        System.out.println("Information for Day #2:");
        System.out.print("\t\tHow many meals did you eat? ");
        return console.nextInt();
    }

    // adds all the calories for each meal together
    public static int getCalories(int meals, Scanner console){
        int calories = 0;
        for (int i = 1; i <= meals; i++){
            System.out.print("\t\t\tHow many calories consumed in meal " + i + "? ");
            calories += console.nextInt();
        }
        return calories;
    }

    // sums up the total calories for the day
    public static void totalCalories(int calories){
        System.out.println("\t\t-- Total calories = " + calories + " --");
    }

    // gives average calories of both days
    public static void avgCalories(int calories, int caloriesTwo){
        System.out.println("Average calories = " + ((calories + caloriesTwo)/2));
    }
}

/*
Information for Day #1:
		How many meals did you eat? 3
			How many calories consumed in meal 1? 351
			How many calories consumed in meal 2? 350
			How many calories consumed in meal 3? 600
		-- Total calories = 1301 --
Information for Day #2:
		How many meals did you eat? 5
			How many calories consumed in meal 1? 250
			How many calories consumed in meal 2? 180
			How many calories consumed in meal 3? 400
			How many calories consumed in meal 4? 250
			How many calories consumed in meal 5? 600
		-- Total calories = 1680 --
Average calories = 1490
*/

/*
What parts of the assignment were the easiest to complete?
I think it was all pretty simple
What are some things that went wrong when completing this assignment?
I was messing around with a nested loop, so I could ask how many
days and meals but ran into some problems
How did you deal with these setbacks?
I decided to just put it aside and do the 2 days instead
About how many hours did you spend working on this assignment?
maybe 1-2 hours
*/