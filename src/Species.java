/** The Species class contains the main method which serves as the entry point for the program. */

public class Species {                  //This class contains the method main.

    /** 
    * The main function is the entry point of the program. 
    * It initializes the Game object and starts the game by calling the run function. 
    * @param args the command-line arguments 
    * @throws Exception if an error occurs during the execution of the game 
    */

    public static void main(String[] args) throws Exception {

        Game game = new Game();
        game.run();
        
    }
    
}
