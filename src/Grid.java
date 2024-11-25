/** 
* The Grid class contains the grid information and provides functions to interact with the grid. 
* It includes functions to set and get values in the grid, reset the grid, and check if the grid is full.*/

public class Grid {                                             //Contains the grid information.
    private Position field[][];

    /** Constructor that initializes a 10x10 array of Position objects. */
    public Grid(){
        field = new Position[10][10];

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                field[i][j] = new Position();
            }
        }
    }

    /** 
    * Sets the value at the given row and column in the grid.
    * @param row the row index * @param col the column index 
    * @param value the value to set 
    */
    public void setValue(int row, int col, char value){         //set value at given row and coloumn
        this.field[row][col].setState(value);
        return;
    }

    /** 
    * Gets the value at the given row and column in the grid. 
    * @param row the row index * @param col the column index 
    * @return the value at the specified position */
    public char getValue(int row, int col){                     //get value at given row and column
        return this.field[row][col].getState();
    }

    /** Resets the grid by setting all positions to the default value '_'. */
    public void reset(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.setValue(i, j, '_');
            }
        }
        return;
    }

    /** 
    * Checks if the grid is full. 
    * @return true if the grid is full, false otherwise 
    */
    public boolean isFull(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (this.field[i][j].getState() == '_'){
                    return false;
                }
            }
        }
        return true;
    }
}

