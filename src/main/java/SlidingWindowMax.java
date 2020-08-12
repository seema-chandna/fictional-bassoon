import java.util.Deque;
import java.util.LinkedList;

/**
 * @author schandna created on 10/04/20
 */
public class SlidingWindowMax {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int size = 0;
        if(nums.length == 1) {
            return nums;
        } else if (nums.length == 2) {
            size = 1;
        } else {
            size = nums.length-2;
        }

        int[] res = new int[size];
        Deque<Integer> q = new LinkedList<Integer>();
        int indx = 0;

        int i;
        for(i=0; i<k; i++){

            while(!q.isEmpty() && nums[i]>=nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }

        for(;i<nums.length;i++) {
            res[indx] = nums[q.peek()];

            while(!q.isEmpty() && q.peek() < i-k) {
                q.removeFirst();
            }

            while(!q.isEmpty() && nums[i]>=nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
            indx++;
        }
        res[indx] = nums[q.peek()];

        return res;
    }

    public static void main(String[] args) {
        maxSlidingWindow(new int [] {}, 2);
    }
}
