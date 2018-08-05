/**
 * Abstract class for evaluating arithmetic expressions.
 */
public abstract class Calculator {
	
	/**
	 * Defines the result of the last expression that was evaluated
	 */
	protected double currentResult;
	
	/**
	 * Initializes a newly created Calculator object and sets the currentResult value to 0.
	 */
	public Calculator() {
		currentResult = 0;
	}
	
	/**
	 * Computes the numerical value of the arithmetic expression represented by the String argument and stores it in currentResult.
	 * @param expr A String that represents an arithmetic expression.
	 * @throws ParseException if the given expression is not a valid arithmetic expression.
	 */
	public abstract void evaluate(String expr);
	
	/**
	 * Returns the result of the last expressions that was evaluated.
	 * Returns 0 in case no expressions was parsed.
	 * @return The result of the last arithmetic expression (or 0, if no expression was evaluated).
	 */
	public double getCurrentResult() {
		return currentResult;
	}
	
}
