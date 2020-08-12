import java.util.*;

/**
 * @author schandna created on 02/07/20
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums == null || nums.length==0 || k <= 0 || t < 0){
            return false;
        }

        if (k > nums.length) k = nums.length;

        for(int i=0; i<nums.length-1; i++){

            for(int j=i+1; j<=i+k && j<nums.length; j++){

                long diff = Math.abs((long)nums[i] - (long)nums[j]);
                if(diff<=t){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII cd = new ContainsDuplicateIII();

        System.out.println(cd.containsNearbyAlmostDuplicate(new int [] {1,2,3,1}, 3, 0));


        Map<Integer, int[]> neigh = new HashMap<>();
        neigh.put(1, new int []{6,8});
    }

}
