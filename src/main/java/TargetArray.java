import java.util.LinkedList;
import java.util.List;

/**
 * @author schandna created on 02/04/20
 */
public class TargetArray {
    /*
    Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.



Example 1:

Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
Example 2:

Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
Explanation:
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]
Example 3:

Input: nums = [1], index = [0]
Output: [1]


Constraints:

1 <= nums.length, index.length <= 100
nums.length == index.length
0 <= nums[i] <= 100
0 <= index[i] <= i
     */

    public int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> tarList = new LinkedList<Integer>();
        if(nums.length == 1){
            return nums;
        }

        int[] target = new int[nums.length];
        for(int i=0; i<nums.length ; i++){
            tarList.add(index[i], nums[i]);
        }

        return tarList.stream().mapToInt(i->i).toArray();
    }

    public int[] createTargetArray2(int[] nums, int[] index) { // faster

        List<Integer> tarList = new LinkedList<Integer>();
        if(nums.length == 1){
            return nums;
        }

        int[] target = new int[nums.length];
        for(int i=0; i<nums.length ; i++){
            tarList.add(index[i], nums[i]);
        }

        for(int i=0; i<tarList.size() ; i++){
            target[i] = tarList.get(i);
        }

        return target;
    }

}
