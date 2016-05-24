package arithmetic;

import interfaces.Expression;
import interfaces.Variable;

/**
 * This class raising the mathematical expression a real power.
 * 
 * @author Shai Hod, ID: 304800402
 * @see Expression
 * @see Variable
 */

public class Power implements Expression {
	protected Expression base;
	protected double exponent;

	/**
	 * General Constructor.
	 * 
	 * @param base
	 *            gets the base of the power.
	 * @param exponent
	 *            gets the exponent of the power.
	 */
	public Power(Expression base, double exponent) {
		this.base = base;
		this.exponent = exponent;
	}

	/**
	 * This method checks if the two powers are equals.
	 * 
	 * @param obj
	 *            gets an another power.
	 * @return true, if the two powers are equals, otherwise returns false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Power)
			if (this.base == ((Power) obj).getBase()
					&& this.exponent == ((Power) obj).getPow())
				return true;
		return false;
	}

	/**
	 * This method that returns the first expression.
	 * 
	 * @return first expression.
	 */
	public Expression getBase() {
		return base;
	}

	/**
	 * This method that returns the second expression.
	 * 
	 * @return second expression.
	 */
	public double getPow() {
		return exponent;
	}

	/**
	 * This method returns an human readable string.
	 * 
	 * @return the expression in form of (base^(exponent)).
	 */
	@Override
	public String toString() {
		return "(" + base.toString() + "^" + exponent + ")";
	}

	/**
	 * This method calculates the result of power of expression.
	 * 
	 * @return the result of power of expression.
	 */
	@Override
	public double evaluate(Assignments assignments) {
		return Math.pow(base.evaluate(assignments), exponent);
	}

	/**
	 * This method returns the derivative expression by variable.
	 * 
	 * @param var
	 *            a variable which perform the derivation operation on the
	 *            variable.
	 * 
	 * @return the derivative expression.
	 */
	@Override
	public Expression derivative(Variable var) {
		if (var == null) // avoid null exception
			return null;

		double newExponent = exponent - 1;
		
		if(newExponent < 0)
			return new Constant(0);
		else {
			return new Multiplication(new Multiplication(
					new Constant(exponent), new Power(base, newExponent)),
					base.derivative(var));
		}
	}
}
