/**
 * This class is a subclass of the abstract Calculator class
 * that evaluates arithmetic expressions written in postfix notation.
 */
public class PostfixCalculator extends Calculator {
	
	/**
	 * Computes the numerical value of the arithmetic expression represented by the String argument and stores it.
	 * @param expr A String that represents an arithmetic expression in postfix notation.
	 * @throws ParseException if the given expression is not a valid arithmetic expression in postfix notation.
	 */
	public void evaluate(String expr) {
		StackAsArray stack = new StackAsArray();
		ExpTokenizer tokenizer = new ExpTokenizer(expr);
		// Make sure that the String is not empty.
		if (tokenizer.hasMoreElements()) {
			while (tokenizer.hasMoreElements()) {
				Object token = tokenizer.nextElement();
				if (token instanceof BinaryOp) {
					// Make sure that there are two tokens at the top of the stack before removing them.
					if (!stack.isEmpty()) {
						double right = ((ValueToken) stack.pop()).getValue();
						if (!stack.isEmpty()) {
							double left = ((ValueToken) stack.pop()).getValue();
							stack.push(new ValueToken(((BinaryOp) token).operate(left, right)));
						}
						else
							throw new ParseException("cannot perform operation " + token);
					}
					else
						throw new ParseException("cannot perform operation " + token);
				}
				else
					stack.push(token);
			}
			// Remove the final value of the expression from the stack and store it.
			currentResult = ((ValueToken) stack.pop()).getValue();
			// Make sure that the stack is empty after the final value of the expression has been removed removed.
			if (!stack.isEmpty())
				throw new ParseException("invalid expression");
		}
		else {
			throw new ParseException("invalid expression");
		}
	}
	
}
