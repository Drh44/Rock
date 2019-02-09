 import java.util.* ;
 import java.util.Random ;
 
 /* Author: Dylan Hesser
 vers.1.0
 This program allows one to play a pick up game with the computer. 
 The player inputs a number of stones that are on the ground between the numbers of 10 to 50. The computer and the player then take turns picking between 1-3 stones at a time. 
 The winner is the person that picks up the last stone. */
 
 
 
 
  public class Rock {

   private static Scanner keyboard;
   private static String player1;
   private static String player2;
   
   public static void main(String[] args) {
/**This is where I declare the scanner and the computer player **/
        keyboard = new Scanner(System.in);
        boolean answer = false;

        player1 = " Vault Boy ";
        
        System.out.print("Hello, my name is " + player1 + ". What is yours?" );
        player2 = keyboard.next();
        System.out.println();
        
        System.out.printf("Hello " + player2 + ", let's play a game.%n");

        System.out.println("We are going to picture a pile of stones lying on the ground next to us.");
        
        do
        {
           playTheGame();
            
           System.out.print("Would you like to play again? (Y/N)");
           answer = answerToRepeatGameQuestion();
         
        }while (answer == true);
 

    }

    private static void playTheGame()
   /** This is the operation that plays the part that is the game. **/
    {
        Random dice = new Random();
        int number = 0;
        
        do
        {
           System.out.printf("How many stones (10-50), would you like to have in the pile? ");
           number = readLineInt();
          
        } while((number < 10) || (number > 50));
        
  
        int stones = number;
        int turn = 1;
        
        System.out.printf("Great" + player2 + "! we now have a pile of %d stones between us.%n",stones);

        
        do {


            if (turn % 2 == 1) {

                do
                {
                   System.out.print("How many stones (between 1 and 3) would you like to remove from the pile? ");
                   number = keyboard.nextInt();
                }while(number < 1 || number > 3);
                
                stones = stones - number;

                System.out.println("\nThe stone pile now has: " + stones + " stones.");
                if(stones > 0)
                   turn++;
                
            }

            if (turn % 2 == 0) {

                number = dice.nextInt(3) + 1;
                System.out.printf( player1 + " will now remove %d stones from the pile.%n", number);
                stones = stones - number;

                System.out.println("\nThe stone pile now has: " + stones + " stones.");
                if(stones > 0)
                   turn++;
             }


        } while (stones > 0);

 
        System.out.println();

        if (turn % 2 == 0) {

            System.out.printf("%s took the last stone from the pile, so that means that I win! Better luck next time.%n", player1);

        } else if (turn % 2 == 1) {

            System.out.printf("%s, you took the last stone from the pile, so you WIN!%n", player2);

        }
    
    
    }
    
    private static boolean answerToRepeatGameQuestion()
/** This receives the ansswer for if the person want to play the game a second time **/
    {
        String inputString = null;
        String response = "";
        boolean done = false;
        boolean answer = false;

        while (! done)
        {
            try
            {
                inputString = keyboard.next();
                inputString = inputString.trim();
                done = inputString.equalsIgnoreCase("Y") || inputString.equalsIgnoreCase("N");
                
                if(done == false)
                  System.out.print("Invalid input. Please enter either Y or N.");
                
            }
            catch (Exception e)
            {
                System.out.print("Invalid input. Please enter either Y or N.");
            }
        }
        
        answer = inputString.equalsIgnoreCase("Y");

        return answer;
    }
    
    private static int readLineInt()
    {
        String inputString = null;
        int number = -9999;
        
        boolean done = false;

        while (! done)
        {
            try
            {
                inputString = keyboard.next();
                inputString = inputString.trim();
                number = Integer.parseInt(inputString);
                done = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Your input number is not correct. Please try again.");
              
            }
        }

        return number;
    }


    
}