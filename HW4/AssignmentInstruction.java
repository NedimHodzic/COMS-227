package hw4;

import api.DefaultNode;
import api.Expression;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Implementation of Instruction that represents an assignment to a 
 * variable in the current scope.  Execution of an assignment instruction
 * causes the scope to be updated with the new value of the variable.
 * If the variable name is not already in the scope, it is added.
 * <ul>
 *   <li>There are two children; the first is the identifier, and the second 
 *   is the expression.
 *   <li>The getLabel() method returns the string "Assign".
 *   <li>The getText() method returns the getText() string of the identifier
 * </ul>
 */
//TODO: POSSIBLY REFACTOR THIS CLASS TO REDUCE CODE DUPLICATION
public class AssignmentInstruction extends AbstractInstruction
{
	
	/**
	 * Instance variables
	 */
	private Identifier v;
	private Expression e;
  
  /**
   * Constructs an assignment instruction representing v = e.
   * @param v
   *   the identifier
   * @param e
   *   the expression to be assigned
   */
  public AssignmentInstruction(Identifier v, Expression e)
  {
    super(v, e, "Assign", 2);
    this.v = v;
    this.e = e;
  }
  
  /**
   * Executes AssignmentInstruction
   */
  @Override
  public void execute(Scope env) {
	  env.put(v.getText(), e.eval(env));
  }

}
