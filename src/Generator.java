import java.util.Random;

/** 
* Generator class is responsible for managing the state of the grid. 
* It handles the generation of new grid states accorinding to set rules (overcrowding and hatching). 
* It also provides functionality to add elements randomly to the grid and reset the grid. 
*/
public class Generator {
    private Grid grid;
    private Grid tempGrid;
    private Random random;


    /** Constructor that initializes class variables */
    public Generator(){
        this.grid = new Grid();
        this.tempGrid = new Grid();
        this.random = new Random();
    }

    /** Generates a new grid state by applying the overcrowding and hatching rules. */
    public void generate(){             
        this.updateTempGrid();                  
        this.overcrowdingRule();            
        this.updateGrid();                      

        this.updateTempGrid();                  
        this.hatchingRule();               
        this.updateGrid();                      
    }

    /**  Applies the hatching rule to the grid. */
    public void hatchingRule(){
        for (int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++){
                if (this.grid.getValue(row, col) == '_'){   //if position is occupied
                    this.hatchingRuleHelper(row, col);
                }
            }
        }
    }

    /** 
    * Helper function for the hatching rule. Checks neighboring cells and hatches a new element if conditions are met.  
    * @param row the row index of the current cell 
    * @param col the column index of the current cell 
    */
    public void hatchingRuleHelper(int row, int col){                                                                       //n1 n2 n3
        char n1 = '_', n2 = '_', n3 = '_', n4 = '_', n5 = '_', n6 = '_', n7 = '_', n8 = '_';                                //n4 __ n5
                                                                                                                            //n6 n7 n8
        if (row-1 >= 0){n1 = this.grid.getValue(row-1, (col-1 + 10) % 10);}         //gets the values of each neighbour
        if (row-1 >= 0){n2 = this.grid.getValue(row-1, (col+0 + 10) % 10);}
        if (row-1 >= 0){n3 = this.grid.getValue(row-1, (col+1 + 10) % 10);}
                        n4 = this.grid.getValue(row,   (col-1 + 10) % 10);
                        n5 = this.grid.getValue(row,   (col+1 + 10) % 10);
        if (row+1 <= 9){n6 = this.grid.getValue(row+1, (col-1 + 10) % 10);}
        if (row+1 <= 9){n7 = this.grid.getValue(row+1, (col+0 + 10) % 10);}
        if (row+1 <= 9){n8 = this.grid.getValue(row+1, (col+1 + 10) % 10);}
            if(n4 == 'X' && n1 == 'X' && n2 == 'X'){        //corner 1
                this.tempGrid.setValue(row, col, 'X');
                return;
            }
            if(n2 == 'X' && n3 == 'X' && n5 == 'X'){        //corner 2
                this.tempGrid.setValue(row, col, 'X');
                return;
            }
            if(n5 == 'X' && n8 == 'X' && n7 == 'X'){        //corner 3
                this.tempGrid.setValue(row, col, 'X');
                return;
            }
            if(n7 == 'X' && n6 == 'X' && n4 == 'X'){        //corner 4
                this.tempGrid.setValue(row, col, 'X');
                return;
            }
    }

    /** Applies the overcrowding rule to the grid. * If a cell is occupied ('X') and has 5 or more adjacent occupied cells, it becomes empty. */
    public void overcrowdingRule(){
        for (int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++){
                if (this.grid.getValue(row, col) == 'X'){   //if position is occupied
                    this.overcrowdingRuleHelper(row, col);
                }
            }
        }
    }

    /** 
    * Helper function for the overcrowding rule. Counts adjacent occupied cells and updates the cell if needed. 
    * @param row the row index of the current cell 
    * @param col the column index of the current cell */
    public void overcrowdingRuleHelper(int row, int col){
        int adjacentSpecies = 0;

        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                if (i == 0 && j == 0){              //skip the middle cell
                    continue;
                }

                int rowWrap = row + i;
                int colWrap = (col+j + 10) % 10;

                if (rowWrap >=0 && rowWrap < 10){
                    if (this.grid.getValue(rowWrap, colWrap) == 'X'){ 
                        adjacentSpecies++;
                    }
                }
            }
        }

        if (adjacentSpecies >= 5){
            this.tempGrid.setValue(row, col, '_');
        }

        
    }

    /** 
    * Adds a specified number of elements randomly to the grid. 
    * @param count the number of random elements to add 
    */
    public void addRandom(int count){                   //add a member to a random grid space
        while(count > 0 && !this.grid.isFull()){             //will not try to add members more than 100 times
            int row = random.nextInt(10);
            int col = random.nextInt(10);

            if (this.grid.getValue(row, col) == '_'){
                this.grid.setValue(row, col, 'X');
                count--;
            }
        }
    }

    /** * Resets the grid to its initial state. */
    public void resetGrid(){                                //reset grid
        this.grid = new Grid();
    }

    /** 
    * Sets the grid to the specified grid. 
    * @param grid the grid to set 
    */
    public void setGrid(Grid grid){
        this.grid = grid;
    }

    /** 
    * Gets the current grid. 
    * @return the current grid 
    */
    public Grid getGrid(){
        return this.grid;
    }

    /** * Resets the temporary grid to its initial state. */
    public void resetTempGrid(){                                //reset grid
        this.tempGrid = new Grid();
    }

    /* Updates the temporary grid with the current values from the main grid. */
    public void updateTempGrid(){
        for (int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++){
                char temp = this.grid.getValue(row, col);
                this.tempGrid.setValue(row, col, temp);
            }
        }
    }

    /* Updates the main grid with the current values from the temporary grid. */
    public void updateGrid(){
        for (int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++){
                char temp = this.tempGrid.getValue(row, col);
                this.grid.setValue(row, col, temp);
            }
        }
    }
}
