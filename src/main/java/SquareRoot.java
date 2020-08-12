import java.util.*;

/**
 * @author schandna created on 12/04/20
 */
public class SquareRoot {

//    int sqrt(int x) {
//        if (x == 0) return 0;
//        int start = 1, end = x, ans;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (mid <= x / mid) {
//                start = mid + 1;
//                ans = mid;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return ans;
//    }

    public static int sqrt(int a) {
        long low = 1;
        long high = a/2;
        while (low<=high) {
            long mid = (high + low) / 2;
            if (mid*mid == a) {
                return (int) mid;
            }
            if (mid*mid > a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }

    public long sqrtFastest(int x) {
        // long check  = mid*mid;
        // Base cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x;
        long ans = 0 ;

        while (start <= end)
        {
            long  mid = (start + end) / 2;
            long check = mid*mid;

            // If x is a perfect square
            if (check == x)
                return mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (check < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n ;
//        n = 9;
//        System.out.println("Ans " + sqrt(n));
//        System.out.println( (int) Math.floor(Math.sqrt(n)));
//
//        n = 0;
//        System.out.println("Ans " + sqrt(n));
//        System.out.println( (int) Math.floor(Math.sqrt(n)));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.add(3);

        System.out.println("MH " + maxHeap.poll());
        System.out.println("MH " + maxHeap.poll());
        System.out.println("MH " + maxHeap.poll());
        System.out.println("MH " + maxHeap.poll());
//
//        n = 81;
//        System.out.println("Ans " + sqrt(n));
//        System.out.println( (int) Math.floor(Math.sqrt(n)));
//
//        n = 281;
//        System.out.println("Ans " + sqrt(n));
//        System.out.println( (int) Math.floor(Math.sqrt(n)));
//
//        n = 286891;
//        System.out.println("Ans " + sqrt(n));
//        System.out.println( (int) Math.floor(Math.sqrt(n)));

        Set<Integer> s = new HashSet<>();


        Random rand = new Random();
        int randInt = rand.nextInt(2);
    }
}
