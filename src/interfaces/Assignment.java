package interfaces;

/**
 * This interface represents assignment for variable
 * 
 * @author Shai Hod, ID: 304800402
 *
 */

public interface Assignment {
	/**
	 * This method returns pointer to variable
	 * 
	 * @return pointer to the variable
	 */
	public Variable getVar();

	/**
	 * This method returns variable value
	 * 
	 * @return the variable value
	 */
	public double getValue();

	/**
	 * This method changes the value of a variable
	 * 
	 * @param value
	 *            gets the new value for the variable
	 */
	public void setValue(double value);
}
