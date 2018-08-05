/*
* Represents a point in two-dimensional space.
*/
public class Point {

	// Point's coordinates
	private int x;
	private int y;

    /**
     * Constructs a Point with (x, y) coordinates.
     * @param x x-coordinate of Point
     * @param y y-coordinate of Point
     */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

    /**
     * Returns the value of the x-coordinate.
     * @return x-coordinate value
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the value of the y-coordinate.
     * @return y-coordinate value
     */
	public int getY() {
		return y;
	}

}
