/*
* Represents a two-dimensional squared map of colors.
*/
public class Map {
	
	// Map as a two-dimensional array of chars
	private char[][] map;
	
	/**
 	 * Constructs a Map of colors based on the given two-dimensional array.
	 * Each coordinate of the Map holds one of the letters of the alphabet as a variable of type char,
	 * based on the respective coordinate of the array passed as a parameter.
	 * If one of the array coordinates does not hold a letter of the alphabet,
	 * the respective coordinate in the Map will hold the letter 'z'.
	 * Every letter represents a different color.
	 * 'A' and 'a' stand for the same color etc.
	 */
	public Map(char[][] map) {
		this.map = map;
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				if (!isColor(this.map[i][j])) {
					this.map[i][j] = 'z';
				}
			}
		}
	}
	
	/**
	 * Checks if a given char is one of the letters of the alphabet
	 * (a-z or A-Z).
	 * Returns true if so, false otherwise.
	 */
	private boolean isColor(char color) {
		return (color >= 'a' && color <= 'z') || (color >= 'A' && color <= 'Z');
	}
	
	/**
	 * Checks if two char parameters represent the same color.
	 * Returns true if so, false otherwise.
	 */
	private boolean sameColor(char color1, char color2) {
		return color1 == color2 || color1 == color2 + 'A' - 'a' || color1 == color2 + 'a' - 'A';
	}
	
	/**
	 * Takes a Point object as a parameter.
	 * Returns true of the Point is within the map;
	 */
	private boolean isPointOnMap(Point p) {
		return map != null && p != null && p.getX() >= 0 &&
			   p.getX() < map.length && p.getY() >= 0 && p.getY() < map.length;
	}
	
	// Optimization method for the method bearing the same name below.
	private boolean around(Point p1, Point p2) {
		boolean ans;
		if (map != null) {
			boolean[][][][] table = new boolean[map.length][map.length][map.length][map.length];
			ans = around(table, p1, p2);
		} else {
			ans = false;
		}
		return ans;
	}
	
	/**
	 *  Takes two Point object, p1 and p2, as parameters.
	 * Checks if p2 is around p1, i.e.:
	 * both points are within the map and at least one of the following conditions is met:
	 *     (a) the points have the same coordinates; or
	 *     (b) the points are legal neighbors; or
	 *     (c) p2 is around one of p1's legal neighbors.
	 * Returns true if so, false otherwise.
	 */
	private boolean around(boolean[][][][] table, Point p1, Point p2) {
		boolean around;
		if (!isPointOnMap(p1) || !isPointOnMap(p2)) {
			around = false;
		} else {
			int x1 = p1.getX();
			int y1 = p1.getY();
			int x2 = p2.getX();
			int y2 = p2.getY();
			if ((x1 == x2 && y1 == y2) || legalNeighbor(p1, p2)) {
				around = true;
			} else {
				around = false;
				for (int i = 0; i < map.length && !around; i++) {
					for (int j = 0; j < map[i].length && !around; j++) {
						Point p3 = new Point(i, j);
						if (!table[x1][y1][i][j]) {
							table[x1][y1][i][j] = true;
							if (legalNeighbor(p1, p3)) {
								around = around(table, p3, p2);
							}
						}
					}
				}
			}
		}
		return around;
	}
	
	// Returns Map as a two-dimensional array.
	public char[][] getMap() {
		return map;
	}
	
	/*
	* Checks if a Map object that is passed as a parameter and this Map object are identical.
	* Returns true if they are, false otherwise.
	*/
	public boolean equals(Map map) {
		boolean ans = (this.map.length == map.map.length);
		for (int i = 0; i < this.map.length && ans; i++) {
			for (int j = 0; j < this.map[i].length && ans; j++) {
				ans = sameColor(this.map[i][j], map.map[i][j]);
			}
		}
		return ans;
	}
	
	// Returns the number of different colors in the map.
	public int numOfColors() {
		int count = 0;
		if (map != null) {
			int[] colors = new int[26];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
						colors[map[i][j]-'A']++;
					}
					else {
						colors[map[i][j]-'a']++;
					}
				}
			}
			for (int c = 0; c < colors.length; c++) {
				if (colors[c] > 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	/*
	* Takes a Point object p as a parameter.
	* Returns the number of different colors from the points neighboring p (p included).
	*/
	public int numOfColors(Point p) {
		int count = 0;
		if (isPointOnMap(p)) {
			int[] colors = new int[26];
			for (int i = p.getX()-1; i <= p.getX()+1; i++) {
				for (int j = p.getY()-1; j <= p.getY()+1; j++) {
					if (isPointOnMap(new Point(i, j))) {
						if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
							colors[map[i][j]-'A']++;
						}
						else {
							colors[map[i][j]-'a']++;
						}
					}
				}
			}
			for (int c = 0; c < colors.length; c++) {
				if (colors[c] > 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	/*
	* Takes two Point object as parameters and checks that both points:
	* (1) are within the map; and
	* (2) have different coordinates; and
	* (3) are each other's neighbors; and
	* (4) hold the same color.
	* Returns true if so, false otherwise.
	*/
	public boolean legalNeighbor(Point p1, Point p2) {
		boolean ans = (isPointOnMap(p1) && isPointOnMap(p2));
		if (ans) {
			int x1 = p1.getX();
			int y1 = p1.getY();
			int x2 = p2.getX();
			int y2 = p2.getY();
			if (x1 == x2 && y1 == y2) {
				ans = false;
			}
			else if (x1 - x2 > 1 || x2 - x1 > 1 || y1 - y2 > 1 || y2 - y1 > 1) {
				ans = false;
			}
			else if (!sameColor(map[x1][y1], map[x2][y2])) {
				ans = false;
			}
		}
		return ans;
	}
		
	/*
	* Takes a Point object and a char (representing a color) as parameters.
	* Changes the color of all points around the given point to the given color.
	*/
	public void fill(Point p,char color) {
		if (!isPointOnMap(p) || !isColor(color)) {
			System.out.println("invalid input");
		}
		else {
			Point[] pointsAround = new Point[map.length*map.length];
			int count = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					Point p2 = new Point(i, j);
					if (around(p, p2)) {
						pointsAround[count] = p2;
						count++;
					}
				}
			}
			for (int i = 0; i < count; i++) {
				map[pointsAround[i].getX()][pointsAround[i].getY()] = color;
			}
		}
	}
	
}
