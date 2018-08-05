import java.util.Enumeration;
/**
 * This class is used to convert a string into a sequence of tokens.
 */
public class ExpTokenizer extends Object implements Enumeration<Object>  {

	/* Defines the array in which the tokens are stored */
	private String [] result;
	/* Defines the orientation of the tokenizer */
	private boolean direction;
	/* Defines the index of the next token of the array */
	private int index;
	
	/**
	 * Initializes a newly created ExpTokenizer object so that it represents the sequence of tokens currently contained in the String argument.
	 * Using this constructor, the tokenizer is set to go over the expression from left to right,
	 * and therefore the next token's index is set to 0 (first from the left).
	 * @param exp A String representing an arithmetic expression.
	 */
	public ExpTokenizer(String exp) {
		this.result = exp.split(" ");
		this.direction = true;
		this.index = 0;
	}
	
	/**
	 * Initializes a newly created ExpTokenizer object so that it represents the sequence of tokens currently contained in the String argument.
	 * If the boolean argument is true, the tokenizer will go over the expression from left to right, and the next token's index will be set to 0.
	 * Otherwise, the tokenizer will go over the expression from right to left, and the index will be set to that of the array's last element.
	 * @param exp A String that represents an arithmetic expression.
	 * @param direction The orientation of the tokenizer (true for left-to-right, false for right-to-left). 
	 */
	public ExpTokenizer(String exp,boolean direction) {
		result = exp.split(" ");
		this.direction = direction;
		if(!this.direction)
			this.index=result.length-1;
		else 
			this.index = 0;
	}
	
	/**
	 * Returns an Object that represents the next token stored in the array.
	 * Precondition: there is at least one more token in the array yet to be parsed.
	 * @return An Object that represents the next token.
	 * @throws ParseException in case the next token is invalid.
	 */
	public Object nextElement() {
		CalcToken resultToken = null;
		String token =  nextToken();
		if (token.equals("+"))
			resultToken =  new AddOp();
		else if (token.equals("*"))
			resultToken =  new MultiplyOp();
		else if (token.equals("-"))
			resultToken = new SubtractOp();
		else if (token.equals("/"))
			resultToken = new DivideOp();
		else if (token.equals("^"))
			resultToken = new PowOp();
		// Throw exception if the token does not contain a parsable double.
		else {
			try {
				resultToken = new ValueToken(Double.parseDouble(token));
			}
			catch (NumberFormatException e1) {
				throw new ParseException("invalid token " + token);
			}
		}
		
		return resultToken;	
	}

	/**
	 * Returns whether there are more elements in the array still yet to be parsed.
	 * @return true if and only if there are more elements yet to be parsed.
	 */
	public boolean hasMoreElements() {
		if(this.direction)
			return (this.index != this.result.length);
		else
			return (this.index >= 0);
	}
	
	/**
	 * Returns a String representation of the next token stored in the array.
	 * Precondition: there is at least one more token in the array yet to be parsed.
	 * @return A String that represents the next token.
	 */
	public String nextToken() {
		String ret;
		if(this.direction){
			ret= this.result[this.index];
			this.index++;
		}
			
		else{
			ret= this.result[this.index];
			this.index--;
		}
		return ret;
	}
	
	/**
	 * Returns whether there are more tokens, i.e. more elements in the array yet to be parsed.
	 * @return true if and only if there are more tokens.
	 */
	public boolean hasMoreTokens() {
		return hasMoreElements();
	}

	/**
	 * Returns the number of tokens yet to be parsed in the array.
	 * @return The number of tokens yet to be parsed.
	 */
	public int countTokens() {
		if(this.direction)
			return (this.result.length - this.index);
		else
			return (this.index+1);
	}
	
}
