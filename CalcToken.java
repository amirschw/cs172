/**
 * Abstract "superclass" describing ALL tokens seen when evaluating
 * arithmetic expressions.
 */
public abstract class CalcToken {
 
	/**
	 * Returns the string representation of this token, whether a numerical value or a binary operator.
	 * @return The string representation of this token.
	 */
	public abstract String toString();
  
}
