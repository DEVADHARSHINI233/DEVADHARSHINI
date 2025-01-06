import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        System.out.println("Welcome to the Guess the Number Game!");
        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\n I have chosen a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == targetNumber) 
                {
                    guessedCorrectly = true;
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("You scored " + roundScore + " points this round.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
              if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + targetNumber + ".");
            }
            System.out.print("Would you like to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing! Your total score is " + totalScore + " points.");
            }
        }
        scanner.close();
    }
}
