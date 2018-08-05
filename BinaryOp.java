/**
 * Abstract class describing binary arithmetic operations.
 */
public abstract class BinaryOp extends CalcToken {

	/**
	 * Returns the result of this operation on its operands.
	 * @param left The left operand.
	 * @param right The right operand.
	 * @return The result of the operation.
	 */
	public abstract double operate(double left, double right);
	
}
