import interfaces.Expression;
import arithmetic.Addition;
import arithmetic.ArrayAssignments;
import arithmetic.Assignments;
import arithmetic.ListAssignments;
import arithmetic.Multiplication;
import arithmetic.Polynomial;
import arithmetic.Power;
import arithmetic.Subtraction;
import arithmetic.ValueAssignment;
import arithmetic.VariableExpression;

@SuppressWarnings("unused")

public class ExpressionsTest {
	public static void main(String[] args) {
		VariableExpression x = new VariableExpression('x');
		VariableExpression y = new VariableExpression('y');
		VariableExpression z = new VariableExpression('z');
		
		System.out.println("we should see three Variables: x, y, z. You got : " + x.getName() + " " + y.getName() + " " + z.getName() );

        Assignments assignments = new ArrayAssignments(); // change the line with  "Assignments assignments = new ListAssignments();" and check yourself 
        assignments.addAssignment(new ValueAssignment(x, +1.0));
        assignments.addAssignment(new ValueAssignment(y, +2.5));
        assignments.addAssignment(new ValueAssignment(z, -3.4));

		Expression exp1 = new Addition(x, y);
		System.out.println("if exp1 = (x+y) then ok: " + exp1.toString());
		Expression exp2 = new Subtraction(y, z);
		System.out.println("if exp2 = (y-z) then ok: " + exp2.toString());
		Expression exp3 = new Multiplication(exp1, exp2);
		System.out.println("if exp3 = ((x+y)*(y-z)) then ok: " + exp3.toString());
		Expression exp4 = new Power(exp3, 4.2);
		System.out.println("if exp4 = (((x+y)*(y-z))^4.2) then ok: " + exp4.toString());
		double[] coefficients = {-2, 4.1, -0.32};
		Expression exp5 = new Polynomial(coefficients, x);
		System.out.println("if Polynimial exp5 = (-2.0+4.1x^1-0.32x^2) then ok: " + exp5.toString());
		Expression exp6 = exp5.derivative(x);
		System.out.println("if exp5 derivative is = (4.1-0.64x^1) then ok: " + exp6.toString());
		Expression exp7 = exp5.derivative(y);
		Expression exp8 = exp4.derivative(y);
		System.out.println("if exp4 derivative is = (4.1-0.64x^1) then ok: " + exp8.toString());
		Expression[] expressions = {
			exp1, exp2, exp3, 
			exp4, exp5, exp6,
			exp7, exp8
		};

		System.out.println("expressions:");
		System.out.println("for the next assignments: x = " + assignments.valueOf(x) + ", y = " + assignments.valueOf(y) + ", z = " + assignments.valueOf(z));
		printExpressionArray(expressions, assignments);
		
		Expression exp9 = new Addition(x, y);
		Expression exp10 = new Addition(y, x);  
		Expression exp11 = new Subtraction(x, y);
		
		System.out.println("\nBasic equality check:");

		System.out.println("\nFirst expression:" + exp1);
		System.out.println("Second expression:" + exp9);
		System.out.println("Is first equal to second? " + exp1.equals(exp9));

		System.out.println("\nFirst expression:" + exp1);
		System.out.println("Second expression:" + exp10);
		System.out.println("Is first equal to second? " + exp1.equals(exp10));
	
		System.out.println("\nFirst expression:" + exp1);
		System.out.println("Second expression:" + exp11);
		System.out.println("Is first equal to second? " + exp1.equals(exp11));
	}
	
	/**
	 * Prints an array of expressions to the screen.
	 * 
	 * @param expressions an array of expressions to be printed.
	 */
	private static void printExpressionArray(Expression[] expressions, Assignments assignments) {
		for (int i=0; i<expressions.length; i = i+1){
			printEvaluatedExpression(expressions[i], assignments);
		}
	}

	/**
	 * Prints an expression along with its evaluated value.
	 *  
	 * @param exp an expression to be printed.
	 */
	private static void printEvaluatedExpression(Expression exp, Assignments assignments){
		System.out.println(exp + " = " + exp.evaluate(assignments));
	}
}
