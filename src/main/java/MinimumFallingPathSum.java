/**
 * @author schandna created on 05/07/20
 */
public class MinimumFallingPathSum {

    int [][] dirs = new int [] [] { {1,1}, {1, 0}, {1,-1} };

    /*public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0){
            return -1;
        }
        int m = A.length;
        int n = A[0].length;
        int [][] visited = new int [m][n];
        int minSum = Integer.MAX_VALUE;

        for (int j=0; j<n; j++) {
            visited[0][j] = A[0][j];
        }

        for (int i=0; i<m-1; i++) {
            for (int j=0; j<n; j++) {
                visited[i+1][j] = visited[i][j] + minFallingPathSum(A, i, j, m, n);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            min = Math.min(min, visited[m-1][j]);
        }
        return min;
    }*/

    public int minFallingPathSumExtraSpace(int[][] A) {
        if(A == null || A.length == 0){
            return -1;
        }
        int m = A.length;
        int n = A[0].length;

        int [][] visited = new int [m][n];

        for (int j=0; j<n; j++) {
            visited[m-1][j] = A[m-1][j];
        }

        for (int i=m-2; i>=0; i--) {
            for (int j=0; j<n; j++) {
                visited[i][j] = A[i][j] + minFallingPathSum(visited, i, j, m, n);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            min = Math.min(min, visited[0][j]);
        }
        return min;
    }

    public int minFallingPathSumAnother(int[][] A) {
        int N = A.length;
        for (int r = N-2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r+1][c];
                if (c > 0)
                    best = Math.min(best, A[r+1][c-1]);
                if (c+1 < N)
                    best = Math.min(best, A[r+1][c+1]);
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: A[0])
            ans = Math.min(ans, x);
        return ans;
    }

    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0){
            return -1;
        }
        int m = A.length;
        int n = A[0].length;

        for (int i=m-2; i>=0; i--) {
            for (int j=0; j<n; j++) {
                A[i][j] = A[i][j] + minFallingPathSum(A, i, j, m, n);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            min = Math.min(min, A[0][j]);
        }
        return min;
    }

    public int minFallingPathSum(int[][] arr, int i, int j, int m, int n) {

        int min;

        int a = getValidVal(arr, i+1, j+1, m, n);
        int b = getValidVal(arr, i+1, j, m, n);
        int c = getValidVal(arr, i+1, j-1, m, n);

        min = Math.min(Math.min(a,b), c);
        return min;
    }

    public int getValidVal(int[][] arr, int i, int j, int m, int n) {
        if (i>=0 && i<m && j>=0 && j<n){
            return arr[i][j];
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
//        int arr[][] = new int[][] {{1,2,3},{4,5,6},{7,8,9}}; // o/p => 12

        int arr[][] = new int[][] {{-51,-35,74},{-62,14,-53},{94,61,-10}}; // o/p => -98

        System.out.println(minimumFallingPathSum.minFallingPathSum(arr));
    }
}
