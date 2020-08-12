import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author schandna created on 04/07/20
 */
public class KnightDialer {

    Map<Integer, int[]> neigh = new HashMap<>();
    int MOD = 1_000_000_007;

    // DP with less space
    public int knightDialer(int N) {
        neigh.put(0, new int []{4,6});
        neigh.put(1, new int []{6,8});
        neigh.put(2, new int []{7,9});
        neigh.put(3, new int []{4,8});
        neigh.put(4, new int []{3,9,0});
        neigh.put(5, new int []{});
        neigh.put(6, new int []{1,7,0});
        neigh.put(7, new int []{2,6});
        neigh.put(8, new int []{1,3});
        neigh.put(9, new int []{2,4});

        int count=0;

        int [][] dp = new int [N] [10];
        Arrays.fill(dp[0], 1);

        int hi = 0;
        for (int h=1; h<N; h++) {
            hi = h & 1;
            Arrays.fill(dp[hi], 0);
            for(int i=0; i<10; i++){

                int[] neighbours = neigh.get(i);
                for (int ng : neighbours) {

                    dp[hi][i] += dp[1-hi][ng];
                    dp[hi][i] = dp[hi][i]%MOD;
                }
            }
        }

        for(int i=0; i<10; i++){
            count += dp[hi][i];
            count = count%MOD;
        }

        return count;
    }

    // DP
    public int knightDialerDP(int N) {
        neigh.put(0, new int []{4,6});
        neigh.put(1, new int []{6,8});
        neigh.put(2, new int []{7,9});
        neigh.put(3, new int []{4,8});
        neigh.put(4, new int []{3,9,0});
        neigh.put(5, new int []{});
        neigh.put(6, new int []{1,7,0});
        neigh.put(7, new int []{2,6});
        neigh.put(8, new int []{1,3});
        neigh.put(9, new int []{2,4});

        int count=0;

        int [][] dp = new int [N] [10];
        // for (int i=0; i< N; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        Arrays.fill(dp[0], 1);

        for (int h=1; h<N; h++) {
            for(int i=0; i<10; i++){

                int[] neighbours = neigh.get(i);
                for (int ng : neighbours) {

                    dp[h][i] += dp[h-1][ng];
                    dp[h][i] = dp[h][i]%MOD;
                }
            }
        }

        for(int i=0; i<10; i++){
            count += dp[N-1][i];
            count %= MOD;
        }

        return count;
    }

    // DP
    /*public int knightDialer(int N) {
        neigh.put(0, new int []{4,6});
        neigh.put(1, new int []{6,8});
        neigh.put(2, new int []{7,9});
        neigh.put(3, new int []{4,8});
        neigh.put(4, new int []{3,9,0});
        neigh.put(5, new int []{});
        neigh.put(6, new int []{1,7,0});
        neigh.put(7, new int []{2,6});
        neigh.put(8, new int []{1,3});
        neigh.put(9, new int []{2,4});

        int count=0;

        int [][] dp = new int [N] [10];
        Arrays.fill(dp[0], 1);

        int hi = 0;
        for (int h=1; h<N; h++) {
            hi = h & 1;
            Arrays.fill(dp[hi], 0);
            for(int i=0; i<10; i++){

                int[] neighbours = neigh.get(i);
                for (int ng : neighbours) {

                    dp[hi][i] += dp[1-hi][ng];
                    dp[hi][i] = dp[hi][i]%MOD;
                }
            }
        }

        for(int i=0; i<10; i++){
            count += dp[hi][i];
            count = count%MOD;
        }

        return count;
    }*/

    // Memorization sol
    public int knightDialerMem(int N) {
        neigh.put(0, new int []{4,6});
        neigh.put(1, new int []{6,8});
        neigh.put(2, new int []{7,9});
        neigh.put(3, new int []{4,8});
        neigh.put(4, new int []{3,9,0});
        neigh.put(5, new int []{});
        neigh.put(6, new int []{1,7,0});
        neigh.put(7, new int []{2,6});
        neigh.put(8, new int []{1,3});
        neigh.put(9, new int []{2,4});

        int count=0;

        int [][] dp = new int [N] [10];
        for (int i=0; i< N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i=0; i<10; i++){
            count += knightDialerMem(N-1, i, dp);
            count = count%MOD;
        }

        return count;
    }
    public int knightDialerMem(int n, int num, int [][] dp) {

        if (n==0) {
            return dp[0][num] = 1;
        }

        if(dp[n][num] != -1){
            return dp[n][num];
        }

        int count=0;
        int[] neighbours = neigh.get(num);
        for (int ng : neighbours) {
            count += knightDialerMem(n-1, ng, dp);
            count = count%MOD;
        }
        return dp[n][num] = (count%MOD);
    }

    // Recursive Sol
    public int knightDialerRec(int N) {
        neigh.put(0, new int []{4,6});
        neigh.put(1, new int []{6,8});
        neigh.put(2, new int []{7,9});
        neigh.put(3, new int []{4,8});
        neigh.put(4, new int []{3,9,0});
        neigh.put(5, new int []{});
        neigh.put(6, new int []{1,7,0});
        neigh.put(7, new int []{2,6});
        neigh.put(8, new int []{1,3});
        neigh.put(9, new int []{2,4});

        int count=0;
        for(int i=0; i<10; i++){
            count += knightDialerRec(N-1, i);
        }
        return count;
    }

    public int knightDialerRec(int n, int num) {
        if (n==0) {
            return 1;
        }

        int count=0;
        int[] neighbours = neigh.get(num);
        for (int ng : neighbours) {
            count += knightDialerRec(n-1, ng);
        }
        return count;
    }

    public static void main(String[] args) {
        KnightDialer kd = new KnightDialer();
        System.out.println(kd.knightDialer(10));
        // 10 -> 14912
        int a = 569851332;
    }
}
