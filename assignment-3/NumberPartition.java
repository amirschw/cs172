/*
* Creates characteristic strings that define a partition of numbers 1...n in a specific way.
*/
public class NumberPartition{

    /**
	 * Check if a characteristic string defines a partition
     * of the numbers 1...n  such that:
     * (1) both sides are of equal length
     * (2) both sides are of equal sum
     * (3) both sides have equal sums of squared elements.
     * returns false if arguments are null / "incorrect"
	 */
    public static boolean isNumberPartition(int n, String s) {

        boolean ans;
        if (s == null || n != s.length() || n%2 != 0) {
        	ans = false;
        } else {
            ans = true;
        	int zerosCount = 0;
            int zerosSum = 0;
            int onesSum = 0;
            int zerosSquaredSum = 0;
            int onesSquaredSum = 0;

            for (int i = 0; i < n && ans; i++) {
            	if (s.charAt(i) != '0' && s.charAt(i) != '1') {
            		ans = false;
            	} else if (s.charAt(i) == '0') {
            		zerosCount++;
            		zerosSum += i+1;
            		zerosSquaredSum += (i+1)*(i+1);
            	} else {
            		onesSum += i+1;
            		onesSquaredSum += (i+1)*(i+1);
            	}
            }
            if (zerosCount != s.length()/2 || zerosSum != onesSum || zerosSquaredSum != onesSquaredSum) {
            	ans = false;
            }
        }
        return ans;
    }

	/**
	 * A wrapper method for the recursive method bearing the same name below.
	 * Prints all characteristic strings of length n that meet the conditions of the isNumberPartition method above.
	 */
    public static void numberPartition(int n) {
		if (n > 0) {
			numberPartition(n, "");
		}
    }
	
	/**
	 * A recursive method called by the wrapper.
	 * The accumulator string is initialized to an empty string
	 * and the different combinations of one and zero are recursively concatenated to it
	 * until it reaches the length of n.
	 * At that point, a combination is printed if it meets the conditions of the isNumberPartition method.
	 */
    private static void numberPartition(int n, String acc) {
        if (acc.length() >= n) {
        	if (isNumberPartition(n, acc)) {
        		System.out.println(acc);
        	}
        }
        else {
        	numberPartition(n, acc + "00");
        	numberPartition(n, acc + "01");
        	numberPartition(n, acc + "10");
        	numberPartition(n, acc + "11");
        }
    }

}
