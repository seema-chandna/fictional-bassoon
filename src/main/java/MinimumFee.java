import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author schandna created on 09/07/20
 */
public class MinimumFee {

    PriorityQueue<Integer> res = new PriorityQueue<>();
    public static void main(String[] args) {
        int matrix[][] = new int[][] {{1,2,3},{4,5,6}, {7,8,9}};

        MinimumFee mf = new MinimumFee();
        System.out.println("1st => " + mf.getMinimumFee(matrix)); // 8

        System.out.println("2nd => " + mf.getMinimumFee(new int[][]{{1, 0},{6, 7}})); // 6
        System.out.println("3rd => " + mf.getMinimumFee(new int[][]{{2, 3},{1, 5}})); // 3
        System.out.println("4th => " + mf.getMinimumFee(new int[][]{{1, 1},{2, 2}})); // 1

        // sorting
        int mat[][] = new int[][] {{1,3},{8,6}, {2,10}, {9,9}, {15,18}};
        Arrays.sort(mat, (i1, i2) -> i1[0]-i2[0]);
        System.out.println(mat);

        int mat2[][] = new int[][] {{1,3},{8,6}, {2,10}, {9,9}, {15,18}};
        Arrays.sort(mat2, Comparator.comparingInt(i -> i[1]));
        System.out.println(mat2);

    }

    int getMinimumFee(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        if(m==1 && n==0){
            return 0;
        }

        res = new PriorityQueue<>();

        dfs(matrix, 0,0, 0, matrix[0][0]);

        System.out.println("queue: " + res);
        return res.isEmpty() ? 0 : res.peek();
    }

    void dfs (int[][] matrix, int i, int j, int fee, int first) {

        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]<0 ){
            return;
        }

        fee += getFee(first, matrix[i][j]);

        if(i==matrix.length-1 && j==matrix[0].length-1){
//            System.out.println(fee);
            res.add(fee);
            return;
        }

        int curr = matrix[i][j];
        matrix[i][j] *= -1;
        dfs(matrix, i+1, j, fee, curr);
        dfs(matrix, i-1, j, fee, curr);
        dfs(matrix, i, j+1, fee, curr);
        dfs(matrix, i, j-1, fee, curr);
        matrix[i][j] *= -1;
    }

    int getFee(int first, int second) {

        int fee =0;
        if (second > first) {
            fee = (second-first);
        }
//        System.out.println("Fee: " + fee + " first: " + first + " second: " + second);
        return fee;
    }

    int getMinFee(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        int dp[][] = new int [m] [n];

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }

        int minFee = getMinFee(matrix, matrix[0][0],0, visited, dp, 0,0,m,n);

        return (minFee == Integer.MAX_VALUE ? -1 : minFee);
    }

    int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};// left-right-up-down

    int getMinFee(int[][] matrix, int first, int diff, boolean[][] visited, int dp[][], int i, int j, int m, int n) {
        if(i==m-1 && j==n-1){
            System.out.println("getFee: " + diff + getFee(first, matrix[m-1][n-1]) + " i: " + i + " j: " + j + " matrix[i][j]: " + matrix[i][j] + " first: " + first);
            return diff + getFee(first, matrix[m-1][n-1]);
        }

        if (!isValid(i,j,m,n,visited)) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        visited[i][j] = true;

        int ans=Integer.MAX_VALUE;
        for (int d=0; d<dir.length; d++){
            int minFee = getMinFee(matrix, matrix[i][j], getFee(first, matrix[i][j]), visited, dp, i+dir[d][0],j+dir[d][1], m, n);
            minFee = minFee == Integer.MAX_VALUE ? minFee : minFee + getFee(first, matrix[i][j]);
            ans = Math.min(ans,minFee);
//            ans = ans == Integer.MAX_VALUE ? ans : ans + getFee(first, matrix[i][j]);
            System.out.println("ans: " + ans + " minFee: " + minFee + " i: " + i + " j: " + j + " matrix[i][j]: " + matrix[i][j]);
        }
        visited[i][j] = false;

        System.out.println("Final ans: " + ans + " i: " + i + " j: " + j + " matrix[i][j]: " + matrix[i][j]);
        System.out.println();

        return dp[i][j]=ans;
    }

    int minFee(int [][] matrix, int i, int j, int m, int n, boolean[][] visited) {

        int min = Integer.MAX_VALUE;

        if (isValid(i+1,j,m,n,visited)) {
            min = Math.min(min, getFee(matrix[i][j], matrix[i+1][j]));
        }

        if (isValid(i,j+1,m,n, visited)) {
            min = Math.min(min, getFee(matrix[i][j], matrix[i][j+1]));
        }

        if (isValid(i-1,j,m,n, visited)) {
            min = Math.min(min, getFee(matrix[i][j], matrix[i-1][j]));
        }

        if (isValid(i,j-1,m,n, visited)) {
            min = Math.min(min, getFee(matrix[i][j], matrix[i][j-1]));
        }
        return min;
    }

    boolean isValid(int i, int j, int m, int n, boolean[][] visited) {
        boolean status = false;
        if(i>=0 && i<m && j>=0 && j<n && !visited[i][j]){
            status = true;
            System.out.println("isValid-" + status +"  i: " + i + " j: " + j);
        }

        return status;
    }


    /*int getMinFee2(int[][] matrix) {
        // TODO: implement

        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int [m] [n];

        dp[0][0] = 0;

        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(i==0 && j==0) {
                    continue;
                }

                dp[i][j] = minFee(matrix, i, j, m, n);

            }
        }

        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(i==0 && j==0){
                    continue;
                }
                dp[i][j] += minFeeValue(dp, i, j, m, n);

            }
        }

        return dp[m-1][n-1];

    }

    int minFeeValue(int [][] matrix, int i, int j, int m, int n) {

        int min = Integer.MAX_VALUE;

        if (isValid(i+1,j,m,n)) {
            min = Math.min(min, matrix[i+1][j]);
        }

        if (isValid(i,j+1,m,n)) {
            min = Math.min(min, matrix[i][j+1]);
        }

        if (isValid(i-1,j,m,n)) {
            min = Math.min(min, matrix[i-1][j]);
        }

        if (isValid(i,j-1,m,n)) {
            min = Math.min(min, matrix[i][j-1]);
        }
        return min;
    }

    int minFee(int [][] matrix, int i, int j, int m, int n) {

        int min = Integer.MAX_VALUE;

        if (isValid(i+1,j,m,n)) {
            min = Math.min(min, getFee(matrix[i][j], matrix[i+1][j]));
        }

        if (isValid(i,j+1,m,n)) {
            min = Math.min(min, getFee(matrix[i][j], matrix[i][j+1]));
        }

        if (isValid(i-1,j,m,n)) {
            min = Math.min(min, getFee(matrix[i][j], matrix[i-1][j]));
        }

        if (isValid(i,j-1,m,n)) {
            min = Math.min(min, getFee(matrix[i][j], matrix[i][j-1]));
        }
        return min;
    }

    boolean isValid(int i, int j, int m, int n) {
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }

    int getFee(int first, int second) {

        if (second > first) {
            return (second -first);
        }
        return 0;
    }
*/

}
