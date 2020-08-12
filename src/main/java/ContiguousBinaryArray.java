import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author schandna created on 14/04/20
 */
public class ContiguousBinaryArray {

    public static int findMaxLength(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max=0;
        int count=0;
        int ending_index = -1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            count+=(nums[i]==1)?1:-1;

            if(count==0){
                max=i+1;
                ending_index =i;
            }
            if(map.containsKey(count)){

                if(i-map.get(count) > max){
                    max=i-map.get(count);
                    ending_index = i;
                }
            }
            else{
                map.put(count,i);
            }
        }

        int end = ending_index - max + 1;
        System.out.println("Result is from - " + end + " to " + ending_index);

        return max;
    }

    static int maxLen(int arr[]) {

        int n = arr.length;
        // Creates an empty hashMap hM

        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array

        for (int i = 0; i < n; i++) {
            // Add current element to sum

            sum += arr[i];

            // To handle sum=0 at last index

            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            // If this sum is seen before, then update max_len
            // if required

            if (hM.containsKey(sum + n)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            }
            else // Else put this sum in hash table
                hM.put(sum + n, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);

        return max_len;
    }

    public static void main(String[] args) {
//        System.out.println(findMaxLength(new int[] {0,1,0,1}));
//        System.out.println(findMaxLength(new int[] {0,1,0,1,0,1,1}));

//        System.out.println(findMaxLength(new int[] {0,1,1,0,1,1,1,0}));
//
//        System.out.println("maxLen - " + maxLen(new int[] {0,1,1,0,1,1,1,0}));

        System.out.println("maxLen - " + maxLen(new int[] {0, 0, 1, 1, 0}));

    }
}
