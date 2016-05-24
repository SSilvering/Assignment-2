package arithmetic;

import interfaces.Expression;
import interfaces.Variable;
import java.lang.Math;

/**
 * This class represents a single variable polynomial.
 * 
 * @author Shai Hod, ID: 304800402
 * @see Expression
 * @see Variable
 */

public class Polynomial implements Expression {
	protected Variable var;
	protected double[] coefficients;

	/**
	 * General Constructor.
	 * 
	 * @param coefficients
	 *            gets an array of polynomial coefficients.
	 * @param var
	 *            gets the variable of the polynomial.
	 */
	public Polynomial(double[] coefficients, Variable var) {
		this.var = var;
		this.coefficients = coefficients;
	}

	/**
	 * This method returns the coefficients of polynomial.
	 * 
	 * @return the coefficients of polynomial.
	 */
	public double[] getCoefficients() {
		return this.coefficients;
	}

	/**
	 * This method checks if the two polynomials are equals.
	 * 
	 * @param obj
	 *            gets another polynomial.
	 * @return true, if the two polynomials are equals, otherwise returns false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Multiplication)
			if (this.var.getName() == ((Variable) obj).getName())
				if (this.coefficients.length == ((Polynomial) obj)
						.getCoefficients().length) {
					for (int i = 0; i < this.coefficients.length; i++) {
						if (this.coefficients[i] != ((Polynomial) obj)
								.getCoefficients()[i])
							return false;
					}
					return true;
				}
		return false;
	}

	/**
	 * This method returns an human readable string.
	 * 
	 * @return the string of specific polynomial.
	 */
	@Override
	public String toString() {
		String temp;

		temp = "(";
		for (int i = 0; i < coefficients.length; i++) {
			if (i != 0 && coefficients[i] > 0)
				temp = temp.concat("+");
			temp = temp.concat(String.valueOf(coefficients[i]));
			if (i > 0) {
				temp = temp.concat(var.toString());
				temp = temp.concat("^" + i);
			}
		}
		temp = temp.concat(")");

		return temp;
	}

	/**
	 * This method calculates the result of polynomial.
	 * 
	 * @return the result of polynomial.
	 */
	@Override
	public double evaluate(Assignments assignments) {
		double res = 0.0;

		for (int i = 0; i < coefficients.length; i++) {
			res += coefficients[i] * Math.pow(assignments.valueOf(var), i);
		}

		return res;
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
		
		if(this.var != var) // if try to derivative variable differ from the variable of polynomial.
			return new Constant(0);

		if (coefficients.length <= 1) {
			return new Constant(0);
		} else {
			double[] newCoefArr = new double[coefficients.length - 1];

			for (int i = 1; i < coefficients.length; i++)
				newCoefArr[i - 1] = coefficients[i] * i;

			return new Polynomial(newCoefArr, this.var);
		}
	}
}
