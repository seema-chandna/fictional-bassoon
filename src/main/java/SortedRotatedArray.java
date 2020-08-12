import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author schandna created on 20/04/20
 */
public class SortedRotatedArray {
    //  Search in Rotated Sorted Array

    int index = -1;
    public int search(int[] nums, int target) {

        index = -1;
        if(nums==null || nums.length ==0){
            return -1;
        }

        int start=0, end=nums.length-1;
        int mid = 0;

        while(start<nums.length && end >= 0 && start<=end){
            mid = (start+end)/2;

            if(nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                if(nums[start] < target || nums[end] >= target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if(nums[mid] >= nums[start] && (nums[mid] <= nums[end] || nums[start] <= target)) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        SortedRotatedArray obj = new SortedRotatedArray();

        int [] data;
        int target;

//        data = new int[] {4,5,6,7,8,1,2,3};
//        target = 8;
//        System.out.println("4 " + obj.search(data, target)); // 4
//
//        data = new int[] {5,1,3};
//        target = 3;
//        System.out.println("2 " + obj.search(data, target)); // 2
//
//        data = new int[] {4,5,6,7,0,1,2,3};
//        target = 1;
//        System.out.println("5 " + obj.search(data, target)); // 5
//
//        data = new int[] {4,5,6,7,0,1,2};
//        target = 3;
//        System.out.println("-1 " + obj.search(data, target)); // -1
//
//        data = new int[] {4,5,6,7,0,1,2};
//        target = 5;
//        System.out.println("1 " + obj.search(data, target)); // 1

        data = new int[] {5,1,2,3,4};
        target = 1;
        System.out.println("1 " + obj.search(data, target)); // 1
    }

    public String bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }

        int [] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);

        return "buildTree(preorder, inorder)";
    }
}
