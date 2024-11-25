/**@author Ashauria Scotland 
 * @author Nazir Nizam
 * @author Azari Gittens
*/



/** 
* The Game class manages the entire game, including interacting with the user. 
* It handles the game loop, menus, processes user actions, and the game grid. 
*/

public class Game {                                         
    
    private Input input;
    private Menu menu;
    private Grid grid;
    private Generator generator;
    private Display display;

    private String action;

    /** Constructor that initializes class variables */
    public Game(){
        this.input = new Input();
        this.menu = new Menu();
        this.grid = new Grid();
        this.generator = new Generator();
        this.display = new Display();

        this.action = new String();
    }

/** 
* Runs the program. Displays the menu and processes user actions in a loop until the user chooses to stop. 
*/
    public void run(){                                      
        do{
            this.menu.displayMenu();                    //show menu
            this.action = this.input.getInput();       //get menu action

            this.generator.setGrid(this.grid);               //send grid to generator

            switch(action){
                case "display":                                                     //displays one generation
                    this.generate();
                    break;
                case "random":                                                      //randomly adds number of inputs
                    int numRandom = this.input.getNum();
                    this.addRandom(numRandom);
                    break;
                case "skip":                                                        //skips a number of generations
                    int numSkip = this.input.getNum();
                    while (numSkip != 0){
                        this.generate();
                        numSkip--;
                    }
                    break;
                case "reset":                                                       //resets the grid
                    this.reset();
                    break;
                case "stop":                                                        //stops the program
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("\nUnrecognized Command\n");
                
            }

            this.grid = this.generator.getGrid();       //retrieve grid from generator

            this.displayGrid();

        }while (!this.action.equals("stop"));


    }

    /** * Displays the current grid. */
    public void displayGrid(){
        this.display.setGrid(this.grid);
        this.display.grid();
    }

    /** * Resets the grid. */
    public void reset(){
        this.grid.reset();
    }

    /** * Calls the generate function in the Generator class. */
    public void generate(){ 
        this.generator.generate();
        return;
    }

    /** 
    * Adds a random number of inputs to the grid.  
    * @param numRandom the # of inputs to add 
    */
    public void addRandom(int numRandom){   
        this.generator.addRandom(numRandom);
        return;
    }

    /** 
    * Sets the value at the specified row and column in the grid. 
    * @param row the row index 
    * @param col the column index 
    * @param value the value to set 
    */
    public void setValue(int row, int col, char value){     //Calls the setValue method in the Grid class.
        this.grid.setValue(row, col, value);
        return;
    }

    /** 
    * Gets the value at the specified row and column in the grid. 
    * @param row the row index 
    * @param col the column index 
    * @return the value at the specified position 
    */
    public char getValue(int row, int col){                 //Calls the getvalue method in the Grid class.
        char value = this.grid.getValue(row, col);
        return value;
    }

}
