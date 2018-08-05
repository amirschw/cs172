/**
 * This class is a subclass of the CalcToken class
 * describing tokens that represent numerical values.
 */
public class ValueToken extends CalcToken {
	
	/* Defines the number represented by the token */
	private double value;
	
	/**
	 * Initializes a newly created ValueToken object so that it represents the same numerical value as the argument.
	 * @param value The numerical value of the token.
	 */
	public ValueToken(double value) {
		this.value = value;
	}
	
	/**
	 * Returns the numerical value of this token.
	 * @return The value of this token.
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Returns the string representation of the number represented by this token.
	 * @return The string representation of the numerical value of this token.
	 */
	public String toString() {
		return Double.toString(value);
	}
	
}
