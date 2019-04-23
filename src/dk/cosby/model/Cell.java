package dk.cosby.model;

public class Cell {

    //////////////////////////////////////////// CLASS VARIABLES /////////////////////////////////////////////

    //class variables
    private int livingNeighbors = 0;
    private boolean alive = false;


    ////////////////////////////////////////////// CONSTRUCTORS //////////////////////////////////////////////

    //no-arg constructor
    public Cell() {
    }

    //constructor with parameters for all variables
    public Cell(int livingNeighbors, boolean alive) {
        this.livingNeighbors = livingNeighbors;
        this.alive = alive;
    }



    //////////////////////////////////////////////// METHODS /////////////////////////////////////////////////

    //sets the cells state (dead or alive) depending on the number of living neighbors.
    public void update(){

        if(!alive && livingNeighbors == 3){
            alive = true;
        } else alive = alive && livingNeighbors == 2 || livingNeighbors == 3;

    }



    ////////////////////////////////////////// GETTERS AND SETTERS ///////////////////////////////////////////

    public int getLivingNeighbors() {
        return livingNeighbors;
    }

    public void setLivingNeighbors(int livingNeighbors) {
        this.livingNeighbors = livingNeighbors;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
