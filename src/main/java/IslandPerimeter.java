/**
 * @author schandna created on 22/06/20
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) { // 6ms

        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;


        int perimeter=0;

        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                perimeter += directionsConnected(grid, i, j, m, n);
            }
        }
        return perimeter;
    }

    private int directionsConnected(int[][] grid, int i, int j, int m, int n) {
        int perimeter=0;

        if(grid[i][j] == 1) {
            perimeter=4;

            if(i+1<m && grid[i+1][j] ==1){
                perimeter -=1;
            }

            if(i-1>=0 && grid[i-1][j] ==1){
                perimeter -=1;
            }

            if(j+1<n && grid[i][j+1] ==1){
                perimeter -=1;
            }

            if(j-1>=0 && grid[i][j-1] ==1){
                perimeter -=1;
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter is = new IslandPerimeter();
        int[][] grid = new int [] [] {{1,1}};
//        System.out.println(is.islandPerimeter(grid));

        System.out.println(is.reverseInteger(2147483647));
    }

    public int islandPerimeter5ms(int[][] grid) { // 5 ms
        int[][] offset= new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        int peri=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) continue;
                peri+=4;
                if(i>0&&grid[i-1][j]==1) peri-=2;
                if(j>0&&grid[i][j-1]==1) peri-=2;
            }
        }
        return peri;

    }

    public int reverseInteger(int x) {

        int inp = x;
        long res = 0;
        boolean plus = false;

        if(inp>0) {
            inp = -inp;
            plus = true;
        }

        while (inp<0) {
            res = res*10 + (inp%10);
            inp /=10;

            if((plus && -res > Integer.MAX_VALUE) || res < Integer.MIN_VALUE)
                return 0;
        }

        res = plus ? -res : res;

        return (int)res;
    }
}
