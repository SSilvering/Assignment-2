package arithmetic;

import interfaces.Assignment;
import interfaces.Variable;

/**
 * This class incorporates an array of assignments.
 * 
 * @author Shai Hod, ID: 304800402
 * @see Assignments
 */

public class ArrayAssignments extends Assignments {
	protected Assignment[] arr;
	protected int size; // number of elements that existing in the array

	/**
	 * Default constructor to initializing an empty array of assignments.
	 */
	public ArrayAssignments() {
		arr = new Assignment[1]; // avoid null exception
		size = 0;
	}

	/**
	 * Constructor that gets an array of Assignment which constitutes the
	 * initial assignments.
	 * 
	 * @param assignments
	 *            gets an array of Assignment with initial assignments.
	 */
	public ArrayAssignments(Assignment[] assignments) {
		if (size != 0 && size < 100) {
			// allocating memory for new array
			Assignment[] tempArr = new Assignment[size];

			for (int i = 0; i < size; i++) {
				tempArr[i] = new ValueAssignment(
						((ValueAssignment) assignments[i]).getVar(),
						((ValueAssignment) assignments[i]).getValue());
			}
			arr = tempArr; // implementation new assignments array - tempArr to
							// assignments array
		}
	}

	/**
	 * This method return the value of a specific variable.
	 * 
	 * @param var
	 *            gets the name of the variable for search in the array.
	 * @return if the variable exists in the array it returns the value of the
	 *         variable, otherwise it returns 0.0 .
	 */
	@Override
	public double valueOf(Variable var) {
		for (int i = 0; i < size; i++) {
			if (var.getName() == ((ValueAssignment) arr[i]).getVar().getName()) {
				return ((ValueAssignment) arr[i]).getValue();
			}
		}
		return 0.0;
	}

	/**
	 * This method checks if the variable exists in assignments array. If
	 * exists, it updates the value of the variable to the new value, otherwise
	 * it adds new assignment to array.
	 * 
	 * @param assignment
	 *            gets new assignment.
	 */
	@Override
	public void addAssignment(Assignment assignment) {
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				if (((ValueAssignment) assignment).getVar() == ((ValueAssignment) arr[i])
						.getVar()) {
					// set new value for existing variable
					((ValueAssignment) arr[i])
							.setValue(((ValueAssignment) assignment).getValue());
					return; // break loop
				}
			}
		}
		// else
		Assignment[] tempArr = new Assignment[size + 1];// allocating memory
														// for the new array

		for (int i = 0; i < size; i++) {// copying the data from the old
										// array to new one
			tempArr[i] = new ValueAssignment(
					((ValueAssignment) arr[i]).getVar(),
					((ValueAssignment) arr[i]).getValue());
		}

		arr = tempArr; // implementation new assignments array

		arr[size] = new ValueAssignment(
				// adds the new assignment to assignment array
				((ValueAssignment) assignment).getVar(),
				((ValueAssignment) assignment).getValue());

		size += 1; // increment the counter of assignments
	}
}
