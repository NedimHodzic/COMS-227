package hw4;

import api.Expression;
import api.Scope;

/**
 * Node type representing a relational expression
 * with the "equals" operator.  If the two operands
 * evaluate the the same number, this expression evaluates
 * to 1; otherwise, it evaluates to zero.
 * <ul>
 *   <li>There are two children; the first is the left operand, and the second 
 *   is the right operand.
 *   <li>The getLabel() method returns the string "==".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Expression INTERFACE
// AND OVERRIDE THE toString METHOD
public class RopEqual extends AbstractExpression
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
  public RopEqual(Expression lhs, Expression rhs)
  {
	  super("==", 2, lhs, rhs, "");
	  this.lhs = lhs;
	  this.rhs = rhs;
  }
  
  /**
   * Returns 1 if the two children are equals, returns 0 if they are not
   */
  @Override
  public int eval(Scope env) {
	if(lhs.eval(env) == rhs.eval(env)) {
  		return 1;
  	}
  	else {
  		return 0;
  	}
  }

}