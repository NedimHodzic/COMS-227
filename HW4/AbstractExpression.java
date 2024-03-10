package hw4;

import api.ArgList;
import api.DefaultNode;
import api.Expression;
import api.Function;
import api.Scope;
import parser.ProgramNode;


/**
 * Abstract class that implements Expression
 * @author Nedim
 *
 */
public abstract class AbstractExpression implements Expression {
	/**
	 * Instance Variables
	 */
	private Expression leftNum;
	private Expression rightNum;
	private String label;
	private String text;
	private int numChildren;
	private int value;
	private Function func;
	private ArgList argsList;
	
	/**
	 * Constructor for Expression Classes with 2 children
	 * @param givenLabel
	 * 		The given label
	 * @param givenNumChildren
	 * 		The given number of children
	 * @param lhs
	 * 		The left hand child
	 * @param rhs
	 * 		The right hand child
	 * @param givenText
	 * 		The given text
	 */
	public AbstractExpression(String givenLabel, int givenNumChildren, Expression lhs, Expression rhs, String givenText) {
		leftNum = lhs;
		rightNum = rhs;
		label = givenLabel;
		text = givenText;
		numChildren = givenNumChildren;
	}
	
	/**
	 * Constructor for Expression Classes with 1 child
	 * @param givenLabel
	 * 		The given label
	 * @param givenNumChildren
	 * 		The given number of children
	 * @param expr
	 * 		The given expression
	 * @param givenText
	 * 		The given text
	 */
	public AbstractExpression(String givenLabel, int givenNumChildren, Expression expr, String givenText) {
		label = givenLabel;
		text = givenText;
		leftNum = expr;
		numChildren = givenNumChildren;
	}
	
	/**
	 * Constructor for Literal and Identifier
	 * @param givenLabel
	 * 		The given label
	 * @param givenNumChildren
	 * 		The given number of children
	 * @param givenText
	 * 		The given text
	 */
	public AbstractExpression(String givenLabel, int givenNumChildren, String givenText) {
		label = givenLabel;
		text = givenText;
		numChildren = givenNumChildren;
	}
	
	/**
	 * Constructor for Call Expression
	 * @param givenLabel
	 * 		The given label
	 * @param givenNumChildren
	 * 		The given number of children
	 * @param f
	 * 		The given function
	 * @param args
	 * 		The given ArgList
	 */
	public AbstractExpression(String givenLabel, int givenNumChildren, Function f, ArgList args) {
		label = givenLabel;
		numChildren = givenNumChildren;
		func = f;
		argsList = args;
	}
	
	/**
	 * Returns the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * Returns the text
	 */
	public String getText() {
	    return text;
	}
	/**
	 * Returns the number of children
	 */
	public int getNumChildren(){
	    return numChildren;
	}
	/**
	 * Returns the makeString
	 */
	public String toString() {
	    return makeString();
	}
	/**
	 * Returns the child
	 */
	public ProgramNode getChild(int i) {
		if(numChildren > 0) {
			if (i == 0)
		    {
		      return leftNum;
		    }
		    else if (i == 1)
		    {
		      return rightNum;
		    }
		    else
		    {
		      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
		    }
		}
		else {
			return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
		}
	    
	}
}
