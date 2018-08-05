/**
 * This class is a subclass of the abstract BinaryOp class
 * describing the additive operation.
 */
public class AddOp extends BinaryOp {
	
	/**
	 * Returns the result of adding two operands.
	 * @param left The left operand.
	 * @param right The right operand.
	 * @return The result of the addition.
	 */
	public double operate(double left, double right) {
		return left + right;
	}
	
	/**
	 * Returns the string representation of the additive operator (a plus sign).
	 * @return The string representation of the additive operator.
	 */
	public String toString() {
		return "+";
	}
	
}
