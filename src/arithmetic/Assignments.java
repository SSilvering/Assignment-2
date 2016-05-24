package arithmetic;

import interfaces.Assignment;
import interfaces.Variable;

/**
 * This abstract class represents a collection of assigning. Class that inherit
 * Assignments, will store them in data structure.
 * 
 * @author Shai Hod, ID: 304800402
 * @see ArrayAssignments
 * @see ListAssignments
 */

public abstract class Assignments {

	/**
	 * Abstract method that returns the value of variable. Abstract classes
	 * inherit this class will have to implement this method.
	 * 
	 * @param var
	 *            gets a variable.
	 * @return the value of the variable.
	 */
	public abstract double valueOf(Variable var);

	/**
	 * Abstract method that adds a new assignment only if there is no assignment
	 * for the resulting variable. If there is an assignment for the variable it
	 * will be replaced by the new one. Abstract classes inherit this class will
	 * have to implement this method.
	 * 
	 * @param assignment
	 *            gets an assignment reference.
	 */
	public abstract void addAssignment(Assignment assignment);
}
