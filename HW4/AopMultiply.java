package hw4;

import api.DefaultNode;
import api.Expression;
import api.Scope;
import parser.ProgramNode;

/**
 * Node type representing an arithmetic expression 
 * with a multiplication operator.
 * <ul>
 *   <li>There are two children; the first is the left operand, and the second 
 *   is the right operand.
 *   <li>The getLabel() method returns the string "*".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
// TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Expression INTERFACE
// AND OVERRIDE THE toString METHOD
public class AopMultiply extends AbstractExpression
{
	/**
	 * Instance variables
	 */
	private Expression lhs;
	private Expression rhs;
	
  /**
   * Constructs an expression with the given left and right sides.
   * @param lhs
   *   expression for the left-hand-side operand
   * @param rhs
   *   expression for the left-hand-side operand
   */
  public AopMultiply(Expression lhs, Expression rhs)
  {
	  super("*", 2, lhs, rhs, "");
	  this.lhs = lhs;
	  this.rhs = rhs;
  }
  
  /**
   * Returns the 2 children multiplied together
   */
  @Override
  public int eval(Scope env) {
	  return lhs.eval(env) * rhs.eval(env);
  }
}
