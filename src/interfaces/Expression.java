package interfaces;

import arithmetic.Assignments;

/**
 * This interface represents arithmetic expressions
 * 
 * @author Shai Hod, ID: 304800402
 *
 */
public interface Expression {
	/**
	 * This method performs a reevaluation of the expression
	 * 
	 * @param assignments
	 *            gets an expression for reevaluate
	 * @return the new value of the expression
	 */
	public double evaluate(Assignments assignments);

	/**
	 * This method derives the expression
	 * 
	 * @param var
	 *            gets the variable name.
	 * 
	 * @return the expression after derivative
	 */
	public Expression derivative(Variable var);
}
