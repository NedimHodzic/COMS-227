package hw4;

import api.Expression;
import api.Scope;

/**
 * Node type representing a logical expression 
 * with the "not" operator. If expr evaluates to zero, 
 * then this expression evaluates to 1; otherwise, this
 * expression evaluates to 0. 
 * <ul>
 *   <li>There is one child, the expression to be logically negated
 *   <li>The getLabel() method returns the string "!".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Expression INTERFACE
// AND OVERRIDE THE toString METHOD
public class LopNot extends AbstractExpression
{ 
	
	/**
	 * Instance variables
	 */
	private Expression expr;
	
  /**
   * Constructs a unary expression that represents the logical negation
   * of the given expression.  
   * @param expr
   *   the logical expression to be negated
   */
  public LopNot(Expression expr)
  {
	  super("!", 1, expr, "");
	  this.expr = expr;
  }
  
  /**
   * Returns 1 if the child is zero, returns 0 if its anything else
   */
  @Override
  public int eval(Scope env) {
	if(expr.eval(env) == 0) {
  		return 1;
  	}
  	else {
  		return 0;
  	}
  }

}
