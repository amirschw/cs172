/**
 * Interface describing a standard Stack ADT.
 */
public interface Stack {
  
	/**
	 * Adds o to the top of this Stack.
	 * Precondition: the stack is not full.
	 * @param o The object to be pushed.
	 */
	public void push(Object o);
	 
	/**
	 * Removes and returns the top element of this Stack.
	 * Precondition: the stack is not empty.
	 * @return The formerly top element of the stack.
	 * @throws EmptyStackException if trying to pop from an empty stack.
	 */
	public Object pop();

	/**
	 * Returns whether the stack is empty.
	 * @return true if and only if the stack is empty.
	 */
	public boolean isEmpty();

}
