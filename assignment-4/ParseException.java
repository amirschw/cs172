/**
 * Thrown when an invalid postfix expression has been parsed.
 */
public class ParseException extends RuntimeException {
	
	/**
	 * Constructs a ParseException with the specified detail message that caused the parsing exception,
	 * in the format "SYNTAX ERROR: message", where message is the String argument.
	 * @param message The error message.
	 */
	public ParseException(String message) {
		super("SYNTAX ERROR: " + message);
	}
	
}
