import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
   public NumberGuessingGame() {
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Random random = new Random();
      System.out.println("Welcome to the Number Guessing Game!");
      int score = 0;

      String playAgainInput;
      for(boolean playAgain = true; playAgain; playAgain = playAgainInput.equalsIgnoreCase("yes")) {
         int targetNumber = random.nextInt(100) + 1;
         int attempts = 0;
         int maxAttempts = 6;
         System.out.println("I have selected a number between 1 and 100. Can you guess it?");

         while(attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            scanner.nextLine();
            ++attempts;
            if (userGuess == targetNumber) {
               System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
               ++score;
               break;
            }

            if (userGuess < targetNumber) {
               System.out.println("Too low! Try again.");
            } else {
               System.out.println("Too high! Try again.");
            }
         }

         if (attempts >= maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
         }

         System.out.print("Do you want to play again? (yes/no): ");
         playAgainInput = scanner.nextLine();
      }

      System.out.println("Game over! Your score: " + score);
      scanner.close();
   }
}