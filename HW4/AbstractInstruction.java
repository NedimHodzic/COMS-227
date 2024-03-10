package hw4;

import java.util.ArrayList;
import api.DefaultNode;
import api.Expression;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Abstract class the implements Instruction
 * @author Nedim
 *
 */
public abstract class AbstractInstruction implements Instruction {
	
	/**
	 * Instance Variables
	 */
	private Identifier variable;
	private Expression expression;
	private String label;
	private int numChildren;
	private Instruction i1;
	private Instruction i2;
	private String text;
	
	/**
	 * Constructor for AssigmentInstruction
	 * @param v
	 * 		The given Identifier
	 * @param e
	 * 		The given Expression
	 * @param givenLabel
	 * 		The given label
	 * @param givenNumChildren
	 * 		The given number of children
	 */
	public AbstractInstruction(Identifier v, Expression e, String givenLabel, int givenNumChildren) {
		variable = v;
		expression = e;
		label = givenLabel;
		numChildren = givenNumChildren;
	}
	
	/**
	 * Constructor for IfInstruction and WhileInstruction
	 * @param e
	 * 		The given Expression
	 * @param givenLabel
	 * 		The given label
	 * @param givenNumChildren
	 * 		The given number of children
	 * @param s0
	 * 		The first given instruction 
	 * @param s1
	 * 		The second given instruction
	 * @param givenText
	 * 		The given text
	 */
	public AbstractInstruction(Expression e, String givenLabel, int givenNumChildren, Instruction s0, Instruction s1, String givenText) {
		expression = e;
		label = givenLabel;
		numChildren = givenNumChildren;
		i1 = s0;
		i2 = s1;
		text = givenText;
	}
	
	/**
	 * Constructor for OutputInstruction
	 * @param e
	 * 		The given expression
	 * @param givenLabel
	 * 		The given label
	 * @param givenNumChildren
	 * 		The given number of children
	 * @param givenText
	 * 		The given text
	 */
	public AbstractInstruction(Expression e, String givenLabel, int givenNumChildren, String givenText) {
		expression = e;
		label = givenLabel;
		numChildren = givenNumChildren;
		text = givenText;
	}
	
	/**
	 * Constructor for BlockInstruction
	 * @param givenLabel
	 * 		The given label
	 * @param givenText
	 * 		The given text
	 */
	public AbstractInstruction(String givenLabel, String givenText) {
		label = givenLabel;
		text = givenText;
	}

	/**
	 * Returns the label
	 */
	public String getLabel()
	  {
	    return label;
	  }
	
	/**
	 * Returns the text, returns variable.getText() if the label is Assign
	 */
	public String getText()
	  {
		if(label.equals("Assign")) {
			return variable.getText();
		}
		else {
			return text;
		}
	  }
	
	/**
	 * Returns the child
	 */
	public ProgramNode getChild(int i)
	  {
	    if (i == 0)
	    {
	      return variable;
	    }
	    else if (i == 1)
	    {
	      return expression;
	    }
	    else
	    {
	      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());      
	    }
	  }
	
	/**
	 * Returns the number of children
	 */
	public int getNumChildren()
	  {
	    return numChildren;
	  }
	
	/**
	 * Returns the makeString
	 */
	public String toString()
	  {
	    return makeString();
	  }
	
	/**
	 * Added method, returns the number of children for the BlockInstruction class
	 * @param num
	 * 		The given number
	 */
	protected void setNumChildren(int num) {
		numChildren = num;
	}
}
