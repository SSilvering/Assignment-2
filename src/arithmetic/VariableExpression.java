package arithmetic;

import interfaces.Expression;
import interfaces.Variable;

/**
 * This class implements the interfaces - Variable and Expression interface and
 * represents a real number type variable. The class represents assign a value
 * to variable.
 * 
 * @author Shai Hod, ID: 304800402
 * @see Variable
 * @see Expression
 */

public class VariableExpression implements Variable, Expression {
	protected char name; // represents the name of variable

	/**
	 * Constructor defines a variable name.
	 * 
	 * @param name
	 *            gets a name for the variable.
	 */
	public VariableExpression(char name) {
		this.name = name;
	}

	/**
	 * This method checks if two variable expression are equals.
	 * 
	 * @param obj
	 *            gets reference to another VariableExpression.
	 * @return true, if the name of the two variable is the same. Otherwise
	 *         returns false.
	 */
	public boolean equals(VariableExpression obj) {
		if (obj instanceof VariableExpression) {
			if (this.name == obj.name)
				return true;
		}

		return false;
	}

	/**
	 * This method returns the variable name.
	 * 
	 * @return the variable name.
	 */
	@Override
	public String toString() {
		return String.valueOf(name);
	}

	/**
	 * @param assignments
	 *            gets reference to specific assignment.
	 * @return value of variable in assignments. Otherwise if there is not an
	 *         existing assignment it returns 0.0 .
	 */
	@Override
	public double evaluate(Assignments assignments) {
		if (assignments.equals(null))
			return 0.0;
		return assignments.valueOf(this);
	}

	/**
	 * This method returns the derivative expression of variable.
	 * 
	 * @param var
	 *            gets a variable.
	 * @return the derivative expression of specific variable.
	 */
	@Override
	public Expression derivative(Variable var) {
		if (this.equals(var))
			return new Constant(1);
		else
			return new Constant(); // Constant of variable is 0.
	}

	/**
	 * This method returns the variable name.
	 */
	@Override
	public char getName() {
		return name;
	}

}
