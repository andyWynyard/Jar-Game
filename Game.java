import java.util.Random;
import java.util.Scanner;
import java.io.Console;


public class Game {
  public static void main(String[] args) {

    //Innitial Admin Setup for name of item and maximum capacity.
    
    boolean isRunning = true;
    String tryAgain = "";
  
    while (isRunning) {  
  
      System.out.println("----ADMIN SETUP FOR GAME----");       
      System.out.print("Enter an item: "); 
      Scanner scan = new Scanner(System.in);
      String itemName = scan.next();
      System.out.print("Enter the max number alowed:  "); //BUG: Negative number breaks the game
      int maxCapacity = scan.nextInt();
      System.out.print("Enter a user name:  ");
      String userName = scan.next(); 
      
      //Explain to the user what they have chosen above so everyone is clear.
      
      System.out.printf("%s has chosen %s as the item and %d as the max capacity.\n", userName, itemName, maxCapacity);
      System.out.println("----PLAY TIME----");
      
      //This is where the code for the game goes.
        
      Random random = new Random();
      int numberOfItems = random.nextInt(maxCapacity) + 1; // The plus one is cause its like arrays.
      int guess; //Gotta declare it first.
      int counter = 0;
      
      do {
      System.out.printf("It has taken you %d turns. Guess how many items in the jar: ", counter);
      guess = scan.nextInt();
      
        if (guess > numberOfItems) {
          System.out.printf("Sorry, %d was the wrong answer, you need to guess lower.\n", guess);
          counter ++;
        } else if (guess < numberOfItems) {
          System.out.printf("Sorry, %d was the wrong answer, you need to guess higher.\n", guess);      
          counter ++;
        } 
      } while (guess != numberOfItems);
       
      if (guess == numberOfItems) {
        System.out.printf("Congrats %s, %d was the right number of %s in the jar. It only took you %d turns.\n", userName, guess, itemName, counter);   
      }
    
      //Enable the game to repeat. It would have probs been here I would put the high score code, but I want to move on. 
      
      System.out.print("Would you like to play again (Y/N):  ");
      tryAgain = scan.next(); 
     
      if (tryAgain.equalsIgnoreCase("n")) isRunning = false;
      
    } 
      
      
      
      
      // The following is the innitial code that didnt tell if the guesser was higher or lower than the random value.
      /* 
      do {
        System.out.printf("It has taken you %d turns. Guess how many items: ", counter);
        guess = scan.nextInt();
        counter ++;
      } while (guess != numberOfItems);
      
      if (guess == numberOfItems) {
        System.out.printf("Congrats, %d was the right number %s in the jar. It only took you %d turns.\n", guess, itemName, counter); 
      } else if (guess > numberOfItems) {
        System.out.printf("Sorry, %d was the wrong answer for, you need to guess lower. It has taken you %d turns so far.\n", guess, counter);
      } else {
        System.out.printf("Sorry, %d was the wrong answer for, you need to guess higher. It has taken you %d turns so far.\n", guess, counter);
      }
        */
  
    
  }
}