import java.util.HashSet;
import java.util.Set;

/**
 * @author schandna created on 02/04/20
 */
public class HappyNumber {
    /*
    Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 0
     */

    public boolean isHappy(int n) {

        int sum = n;
        Set<Integer> s = new HashSet<>();

        while (sum != 1) {

            if (s.contains(sum)) {
                return false;
            }

            s.add(sum);

            sum = getDigitSum(sum);
        }

        if(sum == 1) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int n) {
        int temp=0;

        while(n>9) {
            int r = n%10;
            temp += r * r;
            n=n/10;
        }

        temp += n *n;
        return temp;
    }
}
