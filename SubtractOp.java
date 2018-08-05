/**
 * This class is a subclass of the abstract BinaryOp class
 * describing the subtraction operation.
 */
public class SubtractOp extends BinaryOp {
	
	/**
	 * Returns the result of subtracting the right operand from the left operand.
	 * @param left The left operand.
	 * @param right The right operand.
	 * @return The result of the subtraction.
	 */
	public double operate(double left, double right) {
		return left - right;
	}
	
	/**
	 * Returns the string representation of the subtraction operator (a minus sign).
	 * @return The string representation of the subtraction operator.
	 */
	public String toString() {
		return "-";
	}
	
}
