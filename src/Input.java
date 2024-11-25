import java.util.Scanner;

/** The Input class is responsible for obtaining all user inputs.*/
public class Input {                                                //Obtains all user input.
    private Scanner userInput;

    /** Constructor that initializes class variables */
    public Input(){
        this.userInput = new Scanner(System.in);
    }

    /** 
    * Obtains a string input from the user. 
    * @return the input string provided by the user 
    */
    public String getInput(){                                       //function to obtain input
        String action = userInput.nextLine();
        return action;
    }

    /** 
    * Obtains a numerical input from the user.  
    * @return the numerical input provided by the user 
    */
    public int getNum(){                                            //gets a numerical input from user
        int num = 0;
        
        while (userInput.hasNext()){

            if (userInput.hasNextInt()){

                num = userInput.nextInt();
                userInput.nextLine();                               //consumes left over input after calling nextInt
                break;
            }else{

                System.out.println("Must be integer value: " + userInput.next());
            }
        }
        return num;
    }
}
