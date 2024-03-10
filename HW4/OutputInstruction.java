package hw4;

import api.Expression;
import api.Scope;

/**
 * Instruction type whose execution causes the value of an expression to
 * be printed to the console.
 * <ul>
 *   <li>There is one child, the expression whose value is to be printed.
 *   <li>The getLabel() method returns the string "Output".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Instruction INTERFACE
// AND OVERRIDE THE toString METHOD
public class OutputInstruction extends AbstractInstruction
{
  
	/**
	 * Instance variables
	 */
	private Expression expr;
	
  /**
   * Constructs an output statement for the given expression.
   * @param expr
   *   given expression
   */
  public OutputInstruction(Expression expr)
  {
	  super(expr, "Output", 1, "");
	  this.expr = expr;
  }
  
  /**
   * Causes the value of an expression to be printed out
   */
  @Override
  public void execute(Scope env) {
	  System.out.println(expr.eval(env));
  }

}
