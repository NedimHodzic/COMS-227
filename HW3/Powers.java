package hw3;
import java.util.ArrayList;
import java.util.Random;

import api.Descriptor;
import api.Direction;
import api.MoveResult;
import api.Shift;
import api.TilePosition;

/**
 * The Powers class contains the state and logic for an implementation of a game
 * similar to "2048".  The basic underlying state is an n by n grid of tiles, 
 * represented by integer values.  A zero in a cell is considered to be
 * "empty", and all other cells contain some power of two.  The game is played
 * by calling the method <code>shiftGrid()</code>, selecting one of the four
 * directions (LEFT, RIGHT, UP, DOWN). Each row or column is then collapsed
 * according to the algorithm described in the methods of <code>ShiftUtil</code>.
 * <p>
 * Whenever two cells are <em>merged</em>, the score is increased by the 
 * combined value of the two cells.
 * 
 * @author Nedim Hodzic
 */
public class Powers
{
  /**
   * Instance variables for the powers class, one for the game board, one for the score, one for the rand, and one for shitUtil
   */
	private int[][] gameArray;
	private int score;
	private Random rand;
	private ShiftUtil shiftUtil;
	
  /**
   * Constructs a game with a grid of the given size, using a default
   * random number generator.  Initially there should be two
   * nonempty cells in the grid selected by the method <code>generateTile()</code>.
   * @param givenSize
   *   size of the grid for this game
   * @param givenUtil
   *   instance of ShiftUtil to be used in this game
   */
  public Powers(int givenSize, ShiftUtil givenUtil)
  {
    gameArray = new int[givenSize][givenSize];
    score = 0;
    shiftUtil = givenUtil;
    generateTile(); //2 instances of generateTile() because the game starts with 2 tiles
    generateTile();
  }
  
  /**
   * Constructs a game with a grid of the given size, using the given
   * instance of <code>Random</code> for its random number generator.
   * Initially there should be two nonempty cells in the grid selected 
   * by the method <code>generateTile()</code>.
   * @param givenSize
   *   size of the grid for this game
   * @param givenUtil
   *   instance of ShiftUtil to be used in this game
   * @param givenRandom
   *   given instance of Random
   */
  public Powers(int givenSize, ShiftUtil givenUtil, Random givenRandom)
  {
	  gameArray = new int[givenSize][givenSize];
	  score = 0;
	  shiftUtil = givenUtil;
	  rand = givenRandom;
	  generateTile(); //2 instances of generateTile() because the game starts with 2 tiles
	  generateTile();
  }
  
  /**
   * Returns the value in the cell at the given row and column.
   * @param row
   *   given row
   * @param col
   *   given column
   * @return
   *   value in the cell at the given row and column
   */
  public int getTileValue(int row, int col)
  {
    return gameArray[row][col];
  }
  
  /**
   * Sets the value of the cell at the given row and column.
   * <em>NOTE: This method should not normally be used by clients outside
   * of a testing environment.</em>
   * @param row
   *   given row
   * @param col
   *   given col
   * @param value
   *   value to be set
   */
  public void setValue(int row, int col, int value)
  {
    gameArray[row][col] = value;
  }
  
  /**
   * Returns the size of this game's grid.
   * @return
   *   size of the grid
   */
  public int getSize()
  {
    return gameArray.length;
  }
  
  /**
   * Returns the current score.
   * @return
   *   score for this game
   */
  public int getScore()
  {
    return score;
  }
  
  /**
   * Copy a row or column from the grid into a new one-dimensional array.  
   * There are four possible actions depending on the given direction:
   * <ul>
   *   <li>LEFT - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array from left to right
   *   <li>RIGHT - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array in reverse (from right to left)
   *   <li>UP - the column indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array from top to bottom
   *   <li>DOWN - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array in reverse (from bottom to top)
   * </ul>
   * @param rowOrColumn
   *   index of the row or column
   * @param dir
   *   direction from which to begin copying
   * @return
   *   array containing the row or column
   */
  public int[] getRowOrColumn(int rowOrColumn, Direction dir)
  {
    int[] singleArray = new int[gameArray.length];
    if(dir == Direction.LEFT) { //Checks if the direction is left
    	for(int i = 0; i < singleArray.length; i++) { //loops through game board at the given row and adds the values into the temp array
    		singleArray[i] = gameArray[rowOrColumn][i];
    	}
    }
    else if(dir == Direction.RIGHT) { //Checks if the direction is right
    	for(int i = 0; i < singleArray.length; i++) { //loops through game board at the given row and adds the values into the temp array
    		singleArray[singleArray.length - 1 - i] = gameArray[rowOrColumn][i];
    	}
    }
    else if(dir == Direction.UP) { //Checks if the direction is up
    	for(int i = 0; i < singleArray.length; i++) { //loops through game board at the given column and adds the values into the temp array
    		singleArray[i] = gameArray[i][rowOrColumn];
    	}
    }
    else if(dir == Direction.DOWN) { //Checks if the direction is down
    	for(int i = 0; i < singleArray.length; i++) { //loops through game board at the given column and adds the values into the temp array
    		singleArray[singleArray.length - 1 - i] = gameArray[i][rowOrColumn];
    	}
    }
    return singleArray;
  }
  
  /**
   * Updates the grid by copying the given one-dimensional array into
   * a row or column of the grid.
   * There are four possible actions depending on the given direction:
   * <ul>
   *   <li>LEFT - the given array is copied into the the row indicated by the 
   *   index <code>rowOrColumn</code> from left to right
   *   <li>RIGHT - the given array is copied into the the row indicated by the 
   *   index <code>rowOrColumn</code> in reverse (from right to left)
   *   <li>UP - the given array is copied into the column indicated by the 
   *   index <code>rowOrColumn</code> from top to bottom
   *   <li>DOWN - the given array is copied into the column indicated by the 
   *   index <code>rowOrColumn</code> in reverse (from bottom to top)
   * </ul>
   * @param arr
   *   the array from which to copy
   * @param rowOrColumn
   *   index of the row or column
   * @param dir
   *   direction from which to begin copying
   */
  public void setRowOrColumn(int[] arr, int rowOrColumn, Direction dir)
  {
	  if(dir == Direction.LEFT) { //Checks if the direction is left
	    	for(int i = 0; i < arr.length; i++) { //runs through the given array adding the values to the given row of the game board
	    		gameArray[rowOrColumn][i] = arr[i];
	    	}
	    }
	    else if(dir == Direction.RIGHT) { //Checks if the direction is right
	    	for(int i = 0; i < arr.length; i++) { //runs through the given array adding the values to the given row of the game board
	    		gameArray[rowOrColumn][i] = arr[arr.length - 1 - i];
	    	}
	    }
	    else if(dir == Direction.UP) { //Checks if the direction is up
	    	for(int i = 0; i < arr.length; i++) { //runs through the given array adding the values to the given column of the game board
	    		gameArray[i][rowOrColumn] = arr[i];
	    	}
	    }
	    else if(dir == Direction.DOWN) { //Checks if the direction is down
	    	for(int i = 0; i < arr.length; i++) { //runs through the given array adding the values to the given column of the game board
	    		gameArray[i][rowOrColumn] = arr[arr.length - 1 - i];
	    	}
	    }
  }

  /**
   * Plays one step of the game by shifting the grid in the given direction.
   * Returns a <code>MoveResult</code> object containing a list of Descriptor 
   * objects describing all moves performed, and a <code>TilePosition</code> object describing
   * the position and value of a newly added tile, if any. 
   * If no tiles are actually moved, the returned <code>MoveResult</code> object contains an 
   * empty list and has a null value for the new <code>TilePosition</code>.
   * <p>
   * If any tiles are moved or merged, a new tile is selected according to the 
   * <code>generate()</code> method and is added to the grid.
   * <p>
   * The shifting of each individual row or column must be performed by the 
   * method <code>shiftAll</code> of <code>ShiftUtil</code>. 
   * 
   * @param dir
   *   direction in which to shift the grid
   * @return
   *   MoveResult object containing move descriptors and new tile position
   */
  public MoveResult doMove(Direction dir)
  {
    MoveResult moveBoard = new MoveResult();
    int[] board = new int[gameArray.length];
    boolean shiftTest = false;
    ArrayList<Shift> newBoard = new ArrayList<Shift>();
    
    for(int i = 0; i < gameArray.length; i++) {
    	board = getRowOrColumn(i, dir); //makes a new board to shift it
    	newBoard = shiftUtil.shiftAll(board); //sets newBoard to the row/column shifted the proper direction
    	setRowOrColumn(board, i, dir); //sets the game board to the new shifted one
    	
    	for(int j = 0; j < newBoard.size(); j++) {
    		//if a shift occured, sets shiftTest to true so it will add a new tile
    		if(newBoard != null) {
    			shiftTest = true;
    		}
    		Shift shift = newBoard.get(j);
    		
    		//increases the score if there is a merge
    		if(shift.isMerge()) {
    			score += shift.getValue() * 2;
    		}
    		
    		//describes movement of the shift
    		Descriptor shifter = new Descriptor(shift, i, dir);
    		moveBoard.addMove(shifter);
    	}
    	
    }
    
    if(shiftTest == true) {
        //adds a new tile if a shift is performed
    	TilePosition tile = generateTile();
    	if(tile != null) {
    		moveBoard.setNewTile(tile);
    		setValue(tile.getRow(), tile.getCol(), tile.getValue());
    	}
    }
    
    return moveBoard;
  }

  /**
   * Use this game's instance of <code>Random</code> to generate
   * a new tile.  The tile's row and column must be an empty cell
   * of the grid, and the tile's value is either 2 or 4. 
   * The tile is selected in such a way that
   * <ul>
   *   <li>All empty cells of the grid are equally likely
   *   <li>The tile's value is a 2 with 90% probability and a 4 with 10% probability
   * </ul>
   * This method does not modify the grid.  If the grid has no
   * empty cells, returns null.
   * @return
   *   a new TilePosition containing the row, column, and value of the
   *   selected new tile, or null if the grid has no empty cells
   */
  public TilePosition generateTile()
  {
	//Sets a rand number and if that rand number is 4 it will make value 4
	Random rand = new Random();
    int randomNum = rand.nextInt(10);
    int value = 2;
    if(randomNum == 4) {
    	value = 4;
    }
    
    //Runs through the game board and checks if there is any empty tiles, if there is it breaks the loop and sets full to false
    Boolean full = true;
    for(int i = 0; i < gameArray.length; i++) {
    	for(int j = 0; j < gameArray.length; j++) {
    		if(gameArray[i][j] == 0) {
    			full = false;
    			break;
    		}
    	}
    }
    
    //If the game board is full it will return null
    if(full == true) {
    	return null;
    }
    
    //generates a random row number and column number in the confides of the game size, then checks if the value at that 
    //part of the board is 0, if it is it sets that tile to whatever value was, if not it keeps looping until it finds an empty tile
    //once it finds an empty tile and fill it it breaks the loop
    TilePosition newTile = null;
    
    for(int i = 0; i < gameArray.length * gameArray.length; i++) {
    	int randRow = rand.nextInt(gameArray.length);
    	int randColumn = rand.nextInt(gameArray.length);
    	if(gameArray[randRow][randColumn] == 0) {
    		gameArray[randRow][randColumn] = value;
    		newTile = new TilePosition(randRow, randColumn, value);
    		break;
    	}
    }
    
    
    return newTile;
    
  }

}
  










