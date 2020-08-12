import java.util.*;

/**
 * @author schandna created on 03/04/20
 */
public class ThreeSum {

    public static void main(String[] args) {

    }


    public List<List<Integer>> threeSum(int[] nums) { // 224 ms

        Arrays.sort(nums);

        List<List<Integer> > pair = new ArrayList<>();
        TreeSet<String> set = new TreeSet<String>();
        List<Integer> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                if (nums[i] + nums[l] + nums[r] == 0) {

                    String str = nums[i] + ":" + nums[l] + ":" + nums[r];

                    if (!set.contains(str)) {

                        triplets.add(nums[i]);
                        triplets.add(nums[l]);
                        triplets.add(nums[r]);
                        pair.add(triplets);
                        triplets = new ArrayList<>();
                        set.add(str);
                    }

                    l++;
                    r--;

                } else if (nums[i] + nums[l] + nums[r] < 0)
                    l++;

                else // nums[i] + nums[j] + nums[k] > 0
                    r--;
            }
        }

        return pair;
    }

    public List<List<Integer>> threeSum1 (int[] nums) { // 14ms
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums.length<3) {
            //throw new IllegalArgumentException("Error Argument");
            return list;
        }
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++) {
            if (nums[i]>0) continue;
            if (i>0 && nums[i]==nums[i-1]) continue;
            int target = 0-nums[i];
            int beg=i+1;
            int end=nums.length-1;
            while (beg<end) {
                if (nums[beg]+nums[end]<target) beg++;
                else if (nums[beg]+nums[end]>target) end--;
                else {
                    list.add(Arrays.asList(nums[i],nums[beg],nums[end]));
                    while (nums[beg]==nums[beg+1] && beg<end-1) beg++;
                    beg++;
                    while (nums[end]==nums[end-1] && beg<end) end--;
                    end--;
                }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum2(int[] nums) { // 16 ms
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(len<3)
            return res;

        Arrays.sort(nums);
        for(int i=0; i<len-2; i++){
            if(nums[i]>0)
                break;
            if(i==0 || nums[i]>nums[i-1]){
                int target = 0 - nums[i];
                int start = i+1;
                int end = len-1;
                while(start<end){
                    if(nums[start]+nums[end] == target){
                        ArrayList<Integer> sol = new ArrayList<Integer>();
                        sol.add(nums[i]);
                        sol.add(nums[start]);
                        sol.add(nums[end]);
                        res.add(sol);
                        start++;
                        end--;

                        //Avoiding duplicates
                        while(start<end && nums[end+1]==nums[end]) end--;
                        while(start<end && nums[start-1]==nums[start]) start++;
                    } else if(nums[start]+nums[end]>target)
                        end--;
                    else
                        start++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum3(int[] nums) { // 20 ms
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
