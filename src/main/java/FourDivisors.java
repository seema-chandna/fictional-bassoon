/**
 * @author schandna created on 02/04/20
 */
public class FourDivisors {

    /*

    Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.

If there is no such integer in the array, return 0.



Example 1:

Input: nums = [21,4,7]
Output: 32
Explanation:
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.


Constraints:

1 <= nums.length <= 10^4
1 <= nums[i] <= 10^5
     */

    public int sumFourDivisors(int[] nums) { // 2705 ms
        int sum =0 ;
        for(int i=0; i< nums.length; i++){
            sum += divSum(nums[i]);
        }
        return sum;
    }

    private int divSum(int n){

        int count = 0;
        int sum = 0;
        for (int i=1;i<=n;i++) {
            if (n%i==0) {
                sum += i;
                count++;
                if(count > 4) {
                    return 0;
                }
            }
        }
        if(count <= 3) {
            return 0;
        }
        return sum;
    }

    public int sumFourDivisors2(int[] nums) { // sample 14 ms submission
        int res=0;
        for(int num : nums) {
            int lres=0, c=0;
            for(int i=1; i*i<=num; i++) {
                if(num%i == 0) {
                    lres += i + num/i;
                    c += i == num/i ? 1 : 2;
                }
                if(c > 4)
                    break;
            }

            if(c == 4)
                res += lres;
        }

        return res;
    }

    public int sumFourDivisors3(int[] nums) { // sample 12 ms submission
        int sum=0;
        for(int num:nums){
            int sqrt=(int)Math.sqrt(num);
            if(sqrt*sqrt==num) continue;
            int tmp=num+1;
            int c=0;
            for(int i=2;i<=sqrt;i++){
                if(num%i==0){
                    c++;
                    if(c>1) break;
                    tmp+=(i+num/i);
                }
            }
            if(c==1) sum+=tmp;
        }
        return sum;
    }
}
