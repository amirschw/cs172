/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// Each function here should test a different class.
		testValueToken();
		/* TODO - write a function for each class */
		testBinaryOp();
		testExpTokenizer();
		testPostfixCalculator();
		testParseException();
		
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;
		
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}
	
	/**
	 * Checks the ValueToken class.
	 */
	private static void testValueToken() {
		
		ValueToken t1 = new ValueToken(5.1);
		
		test(t1.getValue() == 5.1, "Value should be 5.1.");
		test(t1.toString().equals("5.1"), "Value toString should be 5.1.");
				
		/* TODO add more tests to the ValueToken class! */
		
		ValueToken t2 = new ValueToken(0);
		
		test(t2.getValue() == 0.0, "Value should be 0.0.");
		test(t2.toString().equals("0.0"), "Value toString should be 0.0.");

		ValueToken t3 = new ValueToken(-123456.7890123456);
		
		test(t3.getValue() == -123456.7890123456, "Value should be -123456.7890123456.");
		test(t3.toString().equals("-123456.7890123456"), "Value toString should be -123456.7890123456.");

	}

	/**
	 * Checks the BinaryOp class and subclasses.
	 */
	private static void testBinaryOp() {
		
		AddOp add = new AddOp();
		test(add.toString().equals("+"), "Operator toString should be +.");
		SubtractOp subtract = new SubtractOp();
		test(subtract.toString().equals("-"), "Operator toString should be -.");
		MultiplyOp multiply = new MultiplyOp();
		test(multiply.toString().equals("*"), "Operator toString should be *.");
		DivideOp divide = new DivideOp();
		test(divide.toString().equals("/"), "Operator toString should be /.");
		PowOp pow = new PowOp();
		test(pow.toString().equals("^"), "Operator toString should be ^.");
		
		double left = -4;
		double right = 0;
		test(add.operate(left, right) == -4.0, "Value should be -4.0");
		test(subtract.operate(left, right) == -4.0, "Value should be -4.0");
		test(multiply.operate(left, right) == 0.0, "Value should be 0.0");
		test(divide.operate(left, right) == Double.NEGATIVE_INFINITY, "Value should be Double.NEGATIVE_INFINITY");
		test(pow.operate(left, right) == 1.0, "Value should be 1.0");

		left = 7;
		right = -2;
		test(add.operate(left, right) == 5.0, "Value should be 5.0");
		test(subtract.operate(left, right) == 9.0, "Value should be 9.0");
		test(multiply.operate(left, right) == -14.0, "Value should be -14.0");
		test(divide.operate(left, right) == -3.5, "Value should be -3.5");
		test(pow.operate(left, right) == (double) 1/49, "Value should be (double) 1/49");
		
		left = 0.5;
		right = -4;
		test(add.operate(left, right) == -3.5, "Value should be -3.5");
		test(subtract.operate(left, right) == 4.5, "Value should be 4.5");
		test(multiply.operate(left, right) == -2.0, "Value should be -2.0");
		test(divide.operate(left, right) == (double) -1/8, "Value should be (double) -1/8");
		test(pow.operate(left, right) == 16.0, "Value should be 16.0");

		left = -127;
		right = -1;
		test(add.operate(left, right) == -128.0, "Value should be -128.0");
		test(subtract.operate(left, right) == -126.0, "Value should be -126.0");
		test(multiply.operate(left, right) == 127.0, "Value should be 127.0");
		test(divide.operate(left, right) == 127.0, "Value should be 127.0");
		test(pow.operate(left, right) == (double) -1/127, "Value should be double (1/127)");

		left = 0;
		right = 2;
		test(add.operate(left, right) == 2.0, "Value should be 2.0");
		test(subtract.operate(left, right) == -2.0, "Value should be -2.0");
		test(multiply.operate(left, right) == 0.0, "Value should be 0.0");
		test(divide.operate(left, right) == 0.0, "Value should be 0.0");
		test(pow.operate(left, right) == 0.0, "Value should be 0.0");

		left = 0;
		right = 0;
		test(add.operate(left, right) == 0.0, "Value should be 2.0");
		test(subtract.operate(left, right) == 0.0, "Value should be 0.0");
		test(multiply.operate(left, right) == 0.0, "Value should be 0.0");
		test(Double.isNaN(divide.operate(left, right)), "Value should be NaN");
		test(pow.operate(left, right) == 1.0, "Value should be 1.0");

	}

	/**
	 * Checks the ExpTokenizer nextElement method.
	 */
	private static void testExpTokenizer() {
		
		ExpTokenizer et = new ExpTokenizer("+ - * / ^ 1 1.0 0 0.0 -1 -1.0 .5 5. -.5 -5.");
		test(et.nextElement().toString().equals("+"), "Token toString should be +");
		test(et.nextElement().toString().equals("-"), "Token toString should be -");
		test(et.nextElement().toString().equals("*"), "Token toString should be *");
		test(et.nextElement().toString().equals("/"), "Token toString should be /");
		test(et.nextElement().toString().equals("^"), "Token toString should be ^");
		test(et.nextElement().toString().equals("1.0"), "Token toString should be 1.0");
		test(et.nextElement().toString().equals("1.0"), "Token toString should be 1.0");
		test(et.nextElement().toString().equals("0.0"), "Token toString should be 0.0");
		test(et.nextElement().toString().equals("0.0"), "Token toString should be 0.0");
		test(et.nextElement().toString().equals("-1.0"), "Token toString should be -1.0");
		test(et.nextElement().toString().equals("-1.0"), "Token toString should be -1.0");
		test(et.nextElement().toString().equals("0.5"), "Token toString should be 0.5");
		test(et.nextElement().toString().equals("5.0"), "Token toString should be 5.0");
		test(et.nextElement().toString().equals("-0.5"), "Token toString should be -0.5");
		test(et.nextElement().toString().equals("-5.0"), "Token toString should be -5.0");
				
	}
	
	/**
	 * Checks the PostfixCalculator class.
	 */
	private static void testPostfixCalculator() {
		
		/* TODO Go for it! write your tests here for the PostfixCalculator class! */
		PostfixCalculator c1 = new PostfixCalculator();
		
		test(c1.getCurrentResult() == 0.0, "Value should be 0.0");
		
		c1.evaluate("-127");
		test(c1.getCurrentResult() == -127.0, "Value should be -127.0");
				
		c1.evaluate("2 3 +");
		test(c1.getCurrentResult() == 5.0, "Value should be 5.0");
		
		c1.evaluate("3 5 -");
		test(c1.getCurrentResult() == -2.0, "Value should be -2.0");
		
		c1.evaluate("6 2 *");
		test(c1.getCurrentResult() == 12.0, "Value should be 12.0");
		
		c1.evaluate("10 4 /");
		test(c1.getCurrentResult() == 2.5, "Value should be 2.5");
		
		c1.evaluate("2 4 ^");
		test(c1.getCurrentResult() == 16.0, "Value should be 16.0");
		
		c1.evaluate("2 3 + 4 2 - *");
		test(c1.getCurrentResult() == 10.0, "Value should be 10.0");
		
		c1.evaluate("2 3 ^ 4 2 * / 7 -");
		test(c1.getCurrentResult() == -6.0, "Value should be -6.0");
		
		c1.evaluate("2 3 ^ 4 2 * / -7 -");
		test(c1.getCurrentResult() == 8.0, "Value should be 8.0");
		
		c1.evaluate("-1 3 ^");
		test(c1.getCurrentResult() == -1.0, "Value should be -1.0");
		
		c1.evaluate("-2 -2 ^");
		test(c1.getCurrentResult() == 0.25, "Value should be 0.25");
				
		c1.evaluate("12348978 0 ^");
		test(c1.getCurrentResult() == 1.0, "Value should be 1.0");
				
		c1.evaluate("5 0 /");
		test(c1.getCurrentResult() == Double.POSITIVE_INFINITY, "Value should be Double.POSITIVE_INFINITY");
		
		c1.evaluate("5 -0 /");
		test(c1.getCurrentResult() == Double.NEGATIVE_INFINITY, "Value should be Double.NEGATIVE_INFINITY");
		
		c1.evaluate("-5 0.5 ^");
		test(Double.isNaN(c1.getCurrentResult()), "Value should be NaN");
				
	}
	
	/**
	 * Checks the ParseException class.
	 */
	private static void testParseException() {
		
		ExpTokenizer et = new ExpTokenizer("");
		try {
			et.nextElement();
		}
		catch (ParseException e1) {
			test(e1.getMessage().equals("SYNTAX ERROR: invalid token "), "Error message should be invalid token ");
		}
		et = new ExpTokenizer("`");
		try {
			et.nextElement();
		}
		catch (ParseException e2) {
			test(e2.getMessage().equals("SYNTAX ERROR: invalid token `"), "Error message should be invalid token `");
		}
		et = new ExpTokenizer("@");
		try {
			et.nextElement();
		}
		catch (ParseException e3) {
			test(e3.getMessage().equals("SYNTAX ERROR: invalid token @"), "Error message should be invalid token @");
		}
		et = new ExpTokenizer("f");
		try {
			et.nextElement();
		}
		catch (ParseException e4) {
			test(e4.getMessage().equals("SYNTAX ERROR: invalid token f"), "Error message should be invalid token f");
		}
		et = new ExpTokenizer("7.0.1");
		try {
			et.nextElement();
		}
		catch (ParseException e6) {
			test(e6.getMessage().equals("SYNTAX ERROR: invalid token 7.0.1"), "Error message should be invalid token 7.0.1");
		}
		et = new ExpTokenizer("*+");
		try {
			et.nextElement();
		}
		catch (ParseException e7) {
			test(e7.getMessage().equals("SYNTAX ERROR: invalid token *+"), "Error message should be invalid token *+");
		}
		et = new ExpTokenizer("++");
		try {
			et.nextElement();
		}
		catch (ParseException e8) {
			test(e8.getMessage().equals("SYNTAX ERROR: invalid token ++"), "Error message should be invalid token ++");
		}
		et = new ExpTokenizer("1..");
		try {
			et.nextElement();
		}
		catch (ParseException e9) {
			test(e9.getMessage().equals("SYNTAX ERROR: invalid token 1.."), "Error message should be invalid token 1..");
		}
		
		PostfixCalculator c1 = new PostfixCalculator();
		try {
			c1.evaluate("4 5 $");
		}
		catch (ParseException e10) {
			test(e10.getMessage().equals("SYNTAX ERROR: invalid token $"), "Error message should be invalid token $");
		}
		try {
			c1.evaluate("7.0.1");
		}
		catch (ParseException e11) {
			test(e11.getMessage().equals("SYNTAX ERROR: invalid token 7.0.1"), "Error message should be invalid token 7.0.1");
		}
		try {
			c1.evaluate("5 6 7 4");
		}
		catch (ParseException e12) {
			test(e12.getMessage().equals("SYNTAX ERROR: invalid expression"), "Error message should be invalid expression");
		}
		try {
			c1.evaluate("*");
		}
		catch (ParseException e13) {
			test(e13.getMessage().equals("SYNTAX ERROR: cannot perform operation *"), "Error message should be cannot perform operation *");
		}
		try {
			c1.evaluate("2 *");
		}
		catch (ParseException e14) {
			test(e14.getMessage().equals("SYNTAX ERROR: cannot perform operation *"), "Error message should be cannot perform operation *");
		}
		try {
			c1.evaluate("5 6 * 4 2 * 1 2 *");
		}
		catch (ParseException e15) {
			test(e15.getMessage().equals("SYNTAX ERROR: invalid expression"), "Error message should be invalid expression");
		}
		try {
			c1.evaluate("2 3  +");
		}
		catch (ParseException e16) {
			test(e16.getMessage().equals("SYNTAX ERROR: invalid token "), "Error message should be invalid token ");
		}
		try {
			c1.evaluate("");
		}
		catch (ParseException e17) {
			test(e17.getMessage().equals("SYNTAX ERROR: invalid token "), "Error message should be invalid token ");
		}
		try {
			c1.evaluate(" ");
		}
		catch (ParseException e18) {
			test(e18.getMessage().equals("SYNTAX ERROR: invalid expression"), "Error message should be invalid expression");
		}
		try {
			c1.evaluate("  ");
		}
		catch (ParseException e19) {
			test(e19.getMessage().equals("SYNTAX ERROR: invalid expression"), "Error message should be invalid expression");
		}
		try {
			c1.evaluate("   ");
		}
		catch (ParseException e20) {
			test(e20.getMessage().equals("SYNTAX ERROR: invalid expression"), "Error message should be invalid expression");
		}
		try {
			c1.evaluate(".");
		}
		catch (ParseException e21) {
			test(e21.getMessage().equals("SYNTAX ERROR: invalid token ."), "Error message should be invalid token .");
		}

	}
}
