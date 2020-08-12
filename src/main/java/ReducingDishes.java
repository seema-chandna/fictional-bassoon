import java.util.Arrays;

/**
 * @author schandna created on 04/07/20
 */
public class ReducingDishes {

    public int maxSatisfactionMine(int[] satisfaction) { // 3ms
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        int max = 0;
        int count = 0;

        for(int i=1; i<=n; i++){
            count = 0;
            int start = n-i;
            for(int j=1; j<=i; j++){
                count += satisfaction[start++] * j;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    public int maxSatisfaction(int[] satisfaction) { // DP 1ms
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int sum =0;
        int csum[] = new int[n];
        csum[n-1] = satisfaction[n-1];
        for(int i=n-2;i>=0;i--){
            csum[i] = csum[i+1]+satisfaction[i];
        }
        if(sum<csum[n-1]){
            sum = csum[n-1];
        }
        for(int i=n-2;i>=0;i--){
            if(sum<csum[i]+csum[i+1]){
                sum = csum[i]+csum[i+1];
            }
            csum[i]+=csum[i+1];
        }
        return sum;
    }

    public int maxSatisfaction2(int[] nums) { // 2ms
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int base = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            base += nums[i];
            if (base < 0) {
                break;
            }
            res += base;
        }
        return res;
    }

}
