package dk.cosby.model;

import dk.cosby.model.Cell;

public class Game {

    ////////////////////////////////////////// CONSTANTS /////////////////////////////////////////////////

    //grid size constants
    public static final int GRID_SIZE_X = 34;
    public static final int GRID_SIZE_Y = 20;


    /////////////////////////////////////// CLASS VARIABLES //////////////////////////////////////////////

    //initializing 2-dimentional Cell array
    private Cell[][] grid = new Cell[GRID_SIZE_X][GRID_SIZE_Y];


    //////////////////////////////////////// CONSTRUCTORS ////////////////////////////////////////////////

    //no-arg constructor
    public Game() {
        for (int i = 0; i < GRID_SIZE_X; i++) {
            for (int j = 0; j < GRID_SIZE_Y; j++) {
                if(i>9 && i<21 && j == 10){
                    grid[i][j] = new Cell(0,true);
                } else grid[i][j] = new Cell();
            }
        }
    }

    public Game(Cell[][] grid) {
        this.grid = grid;
    }

    ////////////////////////////////////////// METHODS //////////////////////////////////////////////////

    //changes the state (dead or alive) of a specific position in the Cell array
    public void changeStateOfCellByPosition(int xPosition, int yPosition) {

        if (xPosition >= 0 && xPosition < GRID_SIZE_X && yPosition >= 0 && yPosition < GRID_SIZE_Y) {
            if (grid[xPosition][yPosition].isAlive()) {
                grid[xPosition][yPosition].setAlive(false);
            } else grid[xPosition][yPosition].setAlive(true);
        }
    }

    public void updateGameGrid(){

        countNeighbors(grid);

        for (int i = 0; i < GRID_SIZE_X; i++) {
            for (int j = 0; j < GRID_SIZE_Y; j++) {
                grid[i][j].update();
            }
        }

    }


    //Counting neighbors of each cell in grid and sets livingNeighbors of the cell
    //This method is used by updateGrid(Cell[][] grid) Method
    public void countNeighbors(Cell[][] grid){

        int neighborCounter;

        boolean topLeft, topMiddle, topRight, middleLeft, middle, middleRight, bottomLeft, bottomMiddle, bottomRight = false;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //resetting neighborCounter each rotation
                neighborCounter = 0;

                //Checking available grid locations
                topLeft = withinGrid(i-1,j-1);
                topMiddle = withinGrid(i-1,j);
                topRight = withinGrid(i-1,j+1);
                middleLeft = withinGrid(i,j-1);
                middle = withinGrid(i,j);
                middleRight = withinGrid(i,j+1);
                bottomLeft = withinGrid(i+1,j-1);
                bottomMiddle = withinGrid(i+1,j);
                bottomRight = withinGrid(i+1,j+1);

                //if location has live cell on it, increment neighborCounter
                if(topLeft){
                    if (grid[i-1][j-1].isAlive()){
                        neighborCounter++;
                    }
                } if(topMiddle){
                    if (grid[i-1][j].isAlive()){
                        neighborCounter++;
                    }
                } if(topRight){
                    if (grid[i-1][j+1].isAlive()){
                        neighborCounter++;
                    }
                } if(middleLeft){
                    if (grid[i][j-1].isAlive()){
                        neighborCounter++;
                    }
                } if(middleRight){
                    if (grid[i][j+1].isAlive()){
                        neighborCounter++;
                    }
                } if(bottomLeft){
                    if (grid[i+1][j-1].isAlive()){
                        neighborCounter++;
                    }
                } if(bottomMiddle){
                    if (grid[i+1][j].isAlive()){
                        neighborCounter++;
                    }
                } if(bottomRight){
                    if (grid[i+1][j+1].isAlive()){
                        neighborCounter++;
                    }
                }

                //Assign neighborCounter value to the Cells livingNeighbors variable
                grid[i][j].setLivingNeighbors(neighborCounter);

            }
        }
        

    }

    //define if cell represented by gridX, gridY is inside grid
//function used by countNeighbours()
    private boolean withinGrid(int gridX, int gridY) {

        if((gridX < 0) || (gridY <0) ) {
            return false;    //false if row or col are negative
        }
        if((gridX >= GRID_SIZE_X) || (gridY >= GRID_SIZE_Y)) {
            return false;    //false if row or col are > 75
        }
        return true;
    }


    //////////////////////////////////////// GETTERS AND SETTERS ////////////////////////////////////////


    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }
}
