package hw4;

import api.DefaultNode;
import api.Expression;
import api.Scope;
import parser.ProgramNode;

/**
 * Node type representing an arithmetic expression 
 * with an addition operator.
 * <ul>
 *   <li>There are two children; the first is the left operand, and the second 
 *   is the right operand.
 *   <li>The getLabel() method returns the string "+".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: POSSIBLY REFACTOR THIS CLASS TO REDUCE CODE DUPLICATION
public class AopAdd extends AbstractExpression
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
  public AopAdd(Expression lhs, Expression rhs)
  {
	  super("+", 2, lhs, rhs, "");
	  this.lhs = lhs;
	  this.rhs = rhs;
  }
  /**
   * Returns 2 expressions added together
   */
  @Override
  public int eval(Scope env) {
	  return lhs.eval(env) + rhs.eval(env);
  }
}
