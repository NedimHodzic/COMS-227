package hw4;

import api.Expression;
import api.Instruction;
import api.Scope;

/**
 * Instruction type representing a while-loop.  A loop has an
 * expression and an instruction.  If the expression evaluates to a 
 * nonzero value (i.e., "true"), the instruction is executed
 * and the expression is re-evaluated, and this process continues 
 * until the expression evaluates to 0 ("false").
 * <ul>
 *   <li>There are two children; the first is the expression, the second 
 *   is the instruction
 *   <li>The getLabel() method returns the string "While".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Instruction INTERFACE
// AND OVERRIDE THE toString METHOD
public class WhileInstruction extends AbstractInstruction
{
	
	/**
	 * Instance variables
	 */
	private Expression condition;
	private Instruction s;
  
  /**
   * Constructs a while statement from the given condition and body
   * @param condition
   *   expression for the loop condition
   * @param s
   *   instruction for the loop body
   */
  public WhileInstruction(Expression condition, Instruction s)
  {
	  super(condition, "While", 2, s, s, "");
	  this.condition = condition;
	  this.s = s;
  }
  
  /**
   * The the expression is non zero the instruction is executed and the expression is re-evaluated until its 0
   */
  @Override
  public void execute(Scope env) {
	  while(condition.eval(env) != 0) {
			s.execute(env);
			condition.eval(env);
	  }
  }
}
