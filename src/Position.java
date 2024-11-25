/** 
* The Position class represents a single position within the grid.
* It contains the current state of the position, which can be free or occupied. 
*/
public class Position {                                     //Represents a single position within the grid. Contains the current state i.e. free or occupied.

    private char state;

    /** Constructor that initializes the position with a default state of '_'. */
    public Position(){
        this.state = '_';
    }

    /** 
    * Sets the state of the position. 
    * @param val the value to set the state to 
    */
    public void setState(char val){
        this.state = val;
    }

    /** 
    * Gets the current state of the position.
    * @return the current state of the position 
    */
    public char getState(){
        return this.state;
    }
    
}
