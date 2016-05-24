package arithmetic;

import interfaces.Assignment;
import interfaces.Variable;

import java.util.LinkedList;

/**
 * The class inherits - Assignments class. Class assembly an assignments, values
 * of type Assignment in a linked list.
 * 
 * @author Shai Hod, ID: 304800402
 * @see Assignments
 */

public class ListAssignments extends Assignments {
	protected LinkedList<Assignment> list;

	/**
	 * Default constructor that initialize empty list of assignments.
	 */
	public ListAssignments() {
		list = new LinkedList<Assignment>();
	}

	/**
	 * Constructor that gets an array of Assignment which constitutes the
	 * initial assignments.
	 * 
	 * @param assignments
	 *            gets an array of Assignment with initial assignments.
	 */
	public ListAssignments(Assignment[] assignments) {
		for (int i = 0; i < assignments.length; i++)
			list.add(assignments[i]);
	}

	/**
	 * This method return the value of a specific variable.
	 * 
	 * @param var
	 *            gets the name of the variable for search in the array.
	 * @return if the variable exists in the linked list it returns the value of
	 *         the variable, otherwise it returns 0.0 .
	 */
	@Override
	public double valueOf(Variable var) {
		for (int i = 0; i < list.size(); i++) {
			if (var == ((ValueAssignment) list.get(i)).getVar())
				return ((ValueAssignment) list.get(i)).getValue();
		}
		return 0.0;
	}

	/**
	 * This method checks if the variable exists in assignments linked list. If
	 * exists, it updates the value of the variable to the new value, otherwise
	 * it adds new assignment to the list.
	 * 
	 * @param assignment
	 *            gets new assignment.
	 */
	@Override
	public void addAssignment(Assignment assignment) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (((ValueAssignment) assignment).getVar() == ((ValueAssignment) list.get(i)).getVar())
					((ValueAssignment) list.get(i))
							.setValue(((ValueAssignment) assignment).getValue());
			}
		} else if (list == null) // avoid null exception - making new list
			list = new LinkedList<Assignment>();

		// adds the new assignment to assignment list
		list.add(new ValueAssignment(((ValueAssignment) assignment).getVar(),
				((ValueAssignment) assignment).getValue()));
	}	
}
