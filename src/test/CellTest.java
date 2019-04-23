package test;

import dk.cosby.model.Cell;
import org.junit.Test;
import static org.junit.Assert.*;


public class CellTest {


    @Test
    public void lifeCellWithNoNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(0,true);

        //getting outcome after update
        cell.update();

         final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void deadCellWithNoNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(0,false);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void lifeCellWithNegativeNeighbors1() {
        //initializing new Cell
        Cell cell = new Cell(-1,true);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void deadCellWithNegativeNeighbors1() {
        //initializing new Cell
        Cell cell = new Cell(-1,false);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void lifeCellWithNegativeNeighbors2() {
        //initializing new Cell
        Cell cell = new Cell(-3,true);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void deadCellWithNegativeNeighbors2() {
        //initializing new Cell
        Cell cell = new Cell(-3,false);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }


    @Test
    public void lifeCellWithOneNeighbor() {
        //initializing new Cell
        Cell cell = new Cell(1,true);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void deadCellWithOneNeighbor() {
        //initializing new Cell
        Cell cell = new Cell(1,false);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void lifeCellWithTwoNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(2,true);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertTrue(expected);
    }

    @Test
    public void deadCellWithTwoNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(2,false);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void lifeCellWithThreeNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(3,true);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertTrue(expected);
    }

    @Test
    public void deadCellWithThreeNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(3,false);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertTrue(expected);
    }

    @Test
    public void lifeCellWithFourNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(4,true);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void deadCellWithFourNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(4,false);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void lifeCellWithManyNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(50,true);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }

    @Test
    public void deadCellWithManyNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(50,false);

        //getting outcome after update
        cell.update();

        final boolean expected = cell.isAlive();

        //testing if cell is alive
        assertFalse(expected);
    }




    @Test
    public void getLivingNeighbors() {
        //initializing new Cell
        Cell cell = new Cell(5,false);

        //defining expectation
        final int expected = 5;
        final int actual = cell.getLivingNeighbors();

        //testing
        assertEquals(expected, actual);
    }



    @Test
    public void setLivingNeighbors() {
        //initializing new Cell
        Cell cell = new Cell();

        //setting cell's amount of neighbors
        cell.setLivingNeighbors(5);

        //defining expectation
        final int expected = 5;
        final int actual = cell.getLivingNeighbors();

        //testing
        assertEquals(expected, actual);
    }



    @Test
    public void isAlive() {
        //initializing new Cell
        Cell cell = new Cell(0,true);

        //defining expectation
        final boolean expected = cell.isAlive();

        //testing
        assertTrue(expected);
    }



    @Test
    public void setAlive() {
        //initializing new Cell
        Cell cell = new Cell();

        //setting cell's amount of neighbors
        cell.setAlive(true);

        //defining expectation
        final boolean expected = cell.isAlive();

        //testing
        assertTrue(expected);
    }

}