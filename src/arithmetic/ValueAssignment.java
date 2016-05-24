package arithmetic;

import interfaces.Assignment;
import interfaces.Variable;

/**
 * The class represents assign a value to a variable.
 * 
 * @author Shai Hod, ID: 304800402
 * @see Assignment 
 * @see Variable
 */

public class ValueAssignment implements Assignment {

	protected Variable var;
	protected double value;

	/**
	 * Constructor assigns value to a variable.
	 * 
	 * @param var
	 *            gets the variable name.
	 * @param value
	 *            gets value of the variable.
	 */
	public ValueAssignment(Variable var, double value) {
		this.var = var;
		this.value = value;
	}

	/**
	 * This method checks if two assignment are equals.
	 * 
	 * @param obj
	 *            gets an another assignment
	 * @return true, if both names of the variables and the values are the same,
	 *         otherwise returns false.
	 */
	public boolean equals(ValueAssignment obj) {
		if (obj instanceof ValueAssignment) {// checks if instance of obj is
												// ValueAssignment
			if (this.var == obj.var && this.value == obj.value)
				return true;
		}

		return false;
	}

	/**
	 * This method returns an human readable string in form "x=5.5".

	 * @return a string of specific assignment.
	 */
	public String toString() {
		return getVar() + "=" + getValue();
	}

	/**
	 * This method returns the name of the variable.
	 */
	@Override
	public Variable getVar() {
		return var;
	}

	/**
	 * This method returns value of assignment.
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * This method updates the value of the specific variable.
	 */
	@Override
	public void setValue(double value) {
		this.value = value;
	};
}
