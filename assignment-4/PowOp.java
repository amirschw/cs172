/**
 * This class is a subclass of the abstract BinaryOp class
 * describing the exponentiation operation.
 */
public class PowOp extends BinaryOp {
	
	/**
	 * Returns the result of raising the left operand to the the power of the right operand.
	 * @param left The left operand (the base).
	 * @param right The right operand (the exponent).
	 * @return The result of the exponentiation.
	 */
	public double operate(double left, double right) {
		return Math.pow(left, right);
	}
	
	/**
	 * Returns the string representation of the exponentiation operator (a caret).
	 * @return The string representation of the exponentiation operator.
	 */
	public String toString() {
		return "^";
	}
	
}
