import java.util.EmptyStackException;

/**
 * This class implements the Stack interface by using an
 * extendable array.
 */
public class StackAsArray implements Stack {

	/* Defines the initial capacity of a stack */
	private static final int INITIAL_CAPACITY = 5;
	/* Defines the capacity extension of a stack when it is full */
	private static final int CAPACITY_EXTENSION = 5;
	/* Defines the extendable array used as a stack */
	protected Object[] elements;
	/* Defines the number of objects actually stored in the stack (rather than its capacity) */
	protected int size;
	
	/**
	 * Creates a new stack.
	 */
	public StackAsArray() {
		elements = new Object[INITIAL_CAPACITY];
		size = 0;
	}

	/**
	 * Adds o to the top of this StackAsArray.
	 * Precondition: the stack is not full.
	 * @param o The object to be pushed.
	 */
	public void push(Object o) {
		// Make sure there is enough room in the array
		if (size >= elements.length) {
			extend();
		}
		
		elements[size] = o;
		size++;
	}
	 
	/**
	 * Removes and returns the top element of this StackAsArray.
	 * Precondition: the stack is not empty.
	 * @return The formerly top element of the stack.
	 * @throws EmptyStackException if trying to pop from an empty stack.
	 */
	public Object pop() {
		// If there are no elements, an exception is thrown
		if (size == 0)
			throw new EmptyStackException();
		
		size--;
		return elements[size];
	}

	/**
	 * Returns whether the stack is empty.
	 * @return true if and only if the stack is empty.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	
	/**
	 * Extends the size of the array by CAPACITY_EXTENSION.
	 */
	private void extend() {
		// Create a new array with the new size
		Object[] tmpArray = new Object[elements.length + CAPACITY_EXTENSION];
		
		// Copy the old elements to the new array
		for (int i = 0; i < elements.length; i++)
			tmpArray[i] = elements[i];
		
		// Replace the elements array with the new one
		elements = tmpArray;
	}

}
