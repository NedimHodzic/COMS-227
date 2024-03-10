package hw4;

import java.util.ArrayList;

import api.Instruction;
import api.Scope;

/**
 * Compound instruction representing a sequence of instructions.  Execution
 * of a block iterates through the sequence, calling execute() on each
 * one. When initially constructed, the block contains no instructions.  
 * Instruction objects are added to the sequence using the method
 * <pre>
 *     public void addStatement(Instruction s)
 * </pre>
 * <ul>
 *   <li>The number of children is the number of statements in
 *       this block (possibly zero).
 *   <li>The getLabel() method returns the string "Block".
 *   <li>The getText() method returns an empty string
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Instruction INTERFACE
// AND OVERRIDE THE toString METHOD
public class BlockInstruction extends AbstractInstruction
{

	/**
	 * Instance variables
	 */
	private ArrayList<Instruction> block;
	
  /**
   * Constructs an empty sequence of instructions.
   */
  public BlockInstruction()
  {
	  super("Block", "");
	  block = new ArrayList<>();
  }

  /**
   * Adds an instruction to this block.  The instructions will be executed
   * in the order added.
   * @param s
   *   instruction to be added to this block
   */
  public void addStatement(Instruction s)
  {
	block.add(s);
	setNumChildren(block.size());
  }
  
  /**
   * Executes each member of the block
   */
  @Override
  public void execute(Scope env) {
  for(int i =0; i < block.size(); i++) {
      block.get(i).execute(env);
  }
  }
}
