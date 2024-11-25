public class Menu {                     //Displays and handles the system’s menu.

    /** Constructor that initializes class variables */
    public Menu(){
        
    }

    /** Displays the menu options to the user. */
    public void displayMenu(){
        System.out.println("\nMENU: ");
        System.out.println("display: displays one generation");
        System.out.println("random: add number of members randomly");
        System.out.println("skip: skips a number of generations");
        System.out.println("reset: resets the grid");
        System.out.println("stop: stops the program");
    }

}
