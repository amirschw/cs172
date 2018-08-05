/**
 * This class is a subclass of the abstract BinaryOp class
 * describing the division operation.
 */
public class DivideOp extends BinaryOp {
	
	/**
	 * Returns the result of dividing the left operand by the right operand.
	 * @param left The left operand (the dividend).
	 * @param right The right operand (the divisor).
	 * @return The result of the division.
	 */
	public double operate(double left, double right) {
		return left / right;
	}
	
	/**
	 * Returns the string representation of the division operator (a division slash).
	 * @return The string representation of the division operator.
	 */
	public String toString() {
		return "/";
	}
	
}
