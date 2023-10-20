
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Game!");

        while (true) {
            int targetNumber = random.nextInt(maxRange) + minRange;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    score += (maxAttempts - attempts) * 10;
                    roundWon = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (roundWon) {
                roundsWon++;
            }

            if (attempts == maxAttempts) {
                System.out.println("You've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score: " + score);
            System.out.println("Rounds won: " + roundsWon);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over!");
        System.out.println("Total Score: " + score);
        System.out.println("Rounds won: " + roundsWon);
    }
}
