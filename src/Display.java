/** 
* The Display class is responsible for displaying the grid information on the screen. 
* It contains function to get and set the grid, and to print the grid values.*/

public class Display {                                  //Displays the grid information on the screen.
    private Grid grid;

    /** Constructor that initializes grid to a new Grid */
    public Display(){
        this.grid = new Grid();
    }

    public void grid(){                                 //Displays the grid.

        /** * Displays the grid on the screen. It iterates through the grid and prints each value. */

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(this.grid.getValue(i, j) + " ");
            }
            System.out.println(" ");
        }
        return;
    }

    /** 
    * Gets the current grid. 
    * @return the current grid 
    */
    public Grid getGrid(){
        return this.grid;
    }

    /** 
    * Sets the grid to the provided grid. 
    * @param temp is the grid to be set 
    */
    public void setGrid(Grid temp){
        this.grid = temp;
    }
}
