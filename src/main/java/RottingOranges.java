import javafx.util.Pair;

import java.util.*;

/**
 * @author schandna created on 23/07/20
 */
public class RottingOranges {

    int maxMin;
    int count;
    int dp[][];

    // Mine 3 ms
    public int orangesRottingBfs(int[][] grid) {

        if(grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        maxMin = 0;
        count = 0;
        dp = new int [m][n];

        int freshOranges=0;
        LinkedList<Pair<int[],Integer>> rottenList = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
//                    dp[i][j] = 1;
                    rottenList.add(new Pair(new int []{i,j}, 1));
                } else if (grid[i][j] == 0) {
                    dp[i][j] = -1;
                } else {
                    freshOranges++;
                }
            }
        }

        if (freshOranges==0) {
            return 0;
        } else if (rottenList.isEmpty()){
            return -1;
        }

        while (!rottenList.isEmpty()) {
            Pair<int[],Integer> node = rottenList.pop();
            int i = node.getKey()[0];
            int j = node.getKey()[1];
            Integer min = node.getValue();

            if (dp[i][j] == 0) {
                if (min > 1) count++;

                dp[i][j] = min;

                if (i+1<dp.length && dp[i+1][j]==0) rottenList.add(new Pair(new int[] {i+1, j}, min+1));
                if (i-1>=0 && dp[i-1][j]==0) rottenList.add(new Pair(new int[] {i-1, j}, min+1));
                if (j+1<dp[0].length && dp[i][j+1]==0) rottenList.add(new Pair(new int[] {i, j+1}, min+1));
                if (j-1>=0 && dp[i][j-1]==0) rottenList.add(new Pair(new int[] {i, j-1}, min+1));
            }

        }

        if(count != freshOranges){
            return -1;
        } else {

            for(int i=0; i<m; i++) {
                for (int j = 0; j < n; j++) {
                    if(maxMin < dp[i][j]){
                        maxMin = dp[i][j];
                    }
                }
            }
            return maxMin-1;
        }
    }

    // Leet 3ms
    public int orangesRottingBfsLeet(int[][] grid) {

        Queue<Pair<Integer,Integer>> queue=new ArrayDeque();

        int freshOranges=0;
        int ROWS=grid.length, COLS=grid[0].length;

        for(int r=0;r<ROWS;++r){
            for(int c=0;c<COLS;++c){
                if(grid[r][c]==2){
                    queue.offer(new Pair(r,c));
                }else if(grid[r][c]==1){
                    freshOranges++;
                }
            }
        }

        queue.offer(new Pair(-1,-1));

        int minutesElapsed=-1;
        int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};

        while(!queue.isEmpty()){
            Pair<Integer,Integer> p=queue.poll();
            int row=p.getKey();
            int col=p.getValue();
            if(row==-1){
                minutesElapsed++;

                if(!queue.isEmpty()){
                    queue.offer(new Pair(-1,-1));
                }
            } else{
                for(int[]d:dirs){
                    int neighborRow=row+d[0];
                    int neighborCol=col+d[1];
                    if(neighborRow>=0&&neighborRow<ROWS&&neighborCol>=0&&neighborCol<COLS){
                        if(grid[neighborRow][neighborCol]==1){
                            grid[neighborRow][neighborCol]=2;
                            freshOranges--;
                            queue.offer(new Pair(neighborRow,neighborCol));
                        }
                    }
                }
            }
        }
        return freshOranges==0?minutesElapsed:-1;

    }

    // Leet 2ms
    public int orangesRotting(int[][] grid) {
        int count = 0;
        List<Point> rottenOrangeList = new ArrayList();
        boolean haveFreshOrnage = false;

        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == 2) {
                    rottenOrangeList.add(new Point(r, c));
                }

                if(grid[r][c] == 1) {
                    haveFreshOrnage = true;
                }
            }
        }

        if(!haveFreshOrnage) {
            return 0;
        }

        while(rottenOrangeList.size() > 0) {
            ArrayList<Point> current = new ArrayList();
            int num = 0;
            for(int i=0; i<rottenOrangeList.size(); i++) {
                num += rottenOranges(current, grid, rottenOrangeList.get(i).r, rottenOrangeList.get(i).c);
            }
            rottenOrangeList = current;
            if(num > 0) {
                count++;
            }
        }


        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    public int rottenOranges(List<Point>rottenOrangeList, int[][] grid, int r, int c) {
        int count = 0;
        if(r-1 >= 0 && grid[r-1][c] == 1) {
            grid[r-1][c] = 2;
            rottenOrangeList.add(new Point(r-1, c));
            count++;
        }

        if(r+1 < grid.length && grid[r+1][c] == 1) {
            grid[r+1][c] = 2;
            rottenOrangeList.add(new Point(r+1, c));
            count++;
        }

        if(c-1 >= 0 && grid[r][c-1] == 1) {
            grid[r][c-1] = 2;
            rottenOrangeList.add(new Point(r, c-1));
            count++;
        }

        if(c+1 < grid[0].length && grid[r][c+1] == 1) {
            grid[r][c+1] = 2;
            rottenOrangeList.add(new Point(r, c+1));
            count++;
        }

        return count > 0 ? 1 : 0;
    }

    public class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int orangesRottingDfs(int[][] grid) {

        if(grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        maxMin = 0;
        count = 0;
        dp = new int [m][n];

        // for(int i=1; i<m; i++) {
        //     if(grid[i][0] == 0) {
        //         dp[i][0] = -1;
        //     } else if (grid[i][0] == 2) {
        //         dp[i][0] = 1;
        //     } else {
        //         dp[i][0] = dp[i-1][0] != -1 ? dp[i-1][0] + 1 : -1;
        //     }
        // }

        int count=0;
        List<int[]> rottenList = new ArrayList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    dp[i][j] = 1;
                    rottenList.add(new int []{i,j});
                } else if (grid[i][j] == 0) {
                    dp[i][j] = -1;
                } else {
                    count++;
                }
            }
        }

        if (count==0) {
            return 0;
        } else if (rottenList.isEmpty()){
            return -1;
        }

        for (int[] rotten : rottenList) {
            dfs(1, rotten[0], rotten[1]);
        }

        if(this.count != count){
            return -1;
        } else {

            for(int i=0; i<m; i++) {
                for (int j = 0; j < n; j++) {
                    if(maxMin < dp[i][j]){
                        maxMin = dp[i][j];
                    }
                }
            }
            return maxMin-1;
        }
    }

    void dfs(int min, int i, int j) {

        if(dp[i][j]==-1 || (dp[i][j]>1 && dp[i][j]<min)){
            return;
        }

        if (dp[i][j] == 0 && min > 1) {
            count++;
        }
        dp[i][j] = min;

        if (i+1<dp.length && dp[i+1][j] != 1) dfs(min+1, i+1, j);
        if (i-1>=0 && dp[i-1][j] != 1) dfs(min+1, i-1, j);
        if (j+1<dp[0].length && dp[i][j+1] != 1) dfs(min+1, i, j+1);
        if (j-1>=0 && dp[i][j-1] != 1) dfs(min+1, i, j-1);
    }

    public static void main(String[] args) {
        RottingOranges oranges = new RottingOranges();
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("orangesRotting");
        System.out.println(oranges.orangesRottingDfs(grid)); // 4
        System.out.println(oranges.orangesRottingBfs(grid)); // 4

        grid = new int[][] {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println("orangesRotting");
        System.out.println(oranges.orangesRottingDfs(grid)); // -1
        System.out.println(oranges.orangesRottingBfs(grid)); // -1

        grid = new int[][] {{0,2}};
        System.out.println("orangesRotting");
        System.out.println(oranges.orangesRottingDfs(grid)); // 0
        System.out.println(oranges.orangesRottingBfs(grid)); // 0

        grid = new int[][] {{1}, {2}, {2}};
        System.out.println("orangesRotting");
        System.out.println(oranges.orangesRottingDfs(grid)); // 1
        System.out.println(oranges.orangesRottingBfs(grid)); // 1

        grid = new int[][] {{2}, {1}, {1}, {1}, {2}, {1}, {1}};
        System.out.println("orangesRotting");
        System.out.println(oranges.orangesRottingDfs(grid)); // 2
        System.out.println(oranges.orangesRottingBfs(grid)); // 2

        grid = new int[][] {{2,2}, {1,1}, {0,0}, {2,0}};
        System.out.println("orangesRotting");
        System.out.println(oranges.orangesRottingDfs(grid)); // 1
        System.out.println(oranges.orangesRottingBfs(grid)); // 1

    }
}
