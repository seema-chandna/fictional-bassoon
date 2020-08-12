import java.util.Arrays;

/**
 * @author schandna created on 18/07/20
 */
public class SumOfMutatedArrayClosestToTarget {

    public int findBestValueMine(int[] arr, int target) {
        int totalSum=0;
        int len = arr.length;
        int [] diffArr = new int [len];
        int minDiff=Integer.MAX_VALUE, minVal=-1;

        Arrays.sort(arr);

        for(int i=0; i<len; i++) {

            int sum = totalSum + arr[i]*(len-i);
            int diff = Math.abs(sum-target);
            diffArr[i] = diff;
            if(minDiff > diff){
                minDiff=diff;
                minVal=arr[i];
            }

            totalSum += arr[i];
        }

        if (minDiff > 0){
            int targVal = target/len;
            int tarDiff = Math.abs(target - targVal*len);

            if(minDiff > tarDiff) {
                minDiff=tarDiff;
                minVal=targVal;
            }

            tarDiff = Math.abs(target - (targVal+1)*len);

            if(minDiff > tarDiff) {
                minDiff=tarDiff;
                minVal=(targVal+1);
            }
        }


        return minVal;
    }

    public int findBestValue1(int[] arr, int target) { // 1ms -> 2ms
        int maxVal = 0;
        int sum = 0;
        for (int i : arr) {
            sum += i;
            maxVal = maxVal > i ? maxVal : i;
        }
        if(sum <= target) return maxVal;

        int mid = target / arr.length;
        sum = getSum(arr, mid);

        while(sum < target) {
            int newSum = getSum(arr, mid + 1);
            if(newSum >= target) {
                return (target - sum) <= (newSum - target) ? mid : mid + 1;
            }
            sum = newSum;
            mid++;
        }
        return 0;
    }

    public int getSum(int[] arr, int value) {
        int sum = 0;
        for (int i : arr) sum += i < value ? i : value;
        return sum;
    }



    public int findBestValue(int[] arr, int target) { // 2 ms -> 4ms
        int left = 0;
        int right = target;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int x : arr) {
            res = Math.max(res, x);
            sum += x;
        }
        int diff = Math.abs(sum - target);
        while (left < right) {
            int mid = left + (right - left) / 2;
            sum = getSum(arr, mid);

            int newDiff = Math.abs(sum - target);

            if (newDiff < diff) {
                diff = newDiff;
                res = mid;
            } else if (newDiff == diff) {
                res = Math.min(res, mid);
            }

            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        SumOfMutatedArrayClosestToTarget mut = new SumOfMutatedArrayClosestToTarget();

        System.out.println(mut.findBestValue(new int[] {4, 9, 3}, 10)); // 3

        System.out.println(mut.findBestValue(new int []{1547,83230,57084,93444,70879}, 71237)); // 17422
    }
}
