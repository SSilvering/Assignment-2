package arithmetic;

import interfaces.Expression;
import interfaces.Variable;

/**
 * This class performs subtracting the second mathematical expression from the
 * first mathematical expression.
 * 
 * @author Shai Hod, ID: 304800402
 * @see Expression
 * @see Variable
 */

public class Subtraction implements Expression {
	protected Expression exp1;
	protected Expression exp2;

	/**
	 * General Constructor.
	 * 
	 * @param exp1
	 *            gets the first expression.
	 * @param exp2
	 *            gets the second expression.
	 */
	public Subtraction(Expression exp1, Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	/**
	 * This method checks if two expression are equals.
	 * 
	 * @param obj
	 *            gets another expression.
	 * @return true, if the two expressions are equals, otherwise returns false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Subtraction)
			if (this.exp1 == ((Subtraction) obj).getExp1()
					&& this.exp2 == ((Subtraction) obj).getExp2())
				return true;
		return false;
	}

	/**
	 * This method that returns the first expression.
	 * 
	 * @return first expression.
	 */
	public Expression getExp1() {
		return exp1;
	}

	/**
	 * This method that returns the second expression.
	 * 
	 * @return second expression.
	 */
	public Expression getExp2() {
		return exp2;
	}

	/**
	 * This method returns an human readable string.
	 * 
	 * @return the expression in form of (exp1-exp2).
	 */
	public String toString() {
		return "(" + exp1.toString() + "-" + exp2.toString() + ")";
	}

	/**
	 * This method calculates the subtraction of the two expressions.
	 * 
	 * @return the result of subtraction of the two expressions.
	 */
	@Override
	public double evaluate(Assignments assignments) {
		return exp1.evaluate(assignments) - exp2.evaluate(assignments);
	}

	/**
	 * This method returns the derivative expression of variable.
	 * 
	 * @param var
	 *            a variable which perform the derivation operation on the
	 *            variable.
	 * 
	 * @return the derivative expression.
	 */
	@Override
	public Expression derivative(Variable var) {
		if (var != null)
			return new Subtraction(exp1.derivative(var), exp2.derivative(var));
		return null;
	}
}
