/**
 * @author schandna created on 19/07/20
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        if(nums == null || nums.length ==0){
            return -1;
        }
        int min = nums[0];
        int start=0, end= nums.length;
        int mid;

        while (start<end) {
            mid = start + (end-start)/2;

            if (min > nums[mid]) {
                min = nums[mid];
            }

            if (nums[mid] > nums[end-1]) {
                start = mid+1;
            } else {
                end = mid;
            }

        }
        return min;
    }

    public static void main(String[] args) {

        FindMinimumInRotatedSortedArray sortedArray = new FindMinimumInRotatedSortedArray();

//        System.out.println(sortedArray.findMin(new int[] {5,1,2,3,4})); // 1

        System.out.println(sortedArray.findMin(new int[] {5,1}));
    }
}
