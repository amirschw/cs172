/**
 * This class is a subclass of the abstract BinaryOp class
 * describing the multiplication operation.
 */
public class MultiplyOp extends BinaryOp {
	
	/**
	 * Returns the result of multiplying two operands.
	 * @param left The left operand.
	 * @param right The right operand.
	 * @return The result of the multiplication.
	 */
	public double operate(double left, double right) {
		return left * right;
	}
	
	/**
	 * Returns the string representation of the multiplication operator (an asterisk).
	 * @return The string representation of the multiplication operator.
	 */
	public String toString() {
		return "*";
	}
	
}
