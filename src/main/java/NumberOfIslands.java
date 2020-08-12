/**
 * @author schandna created on 11/04/20
 */
public class NumberOfIslands {

    /*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

     */

    int ROW, COL;

    public int numIslands(char[][] grid) { // 2ms

        int count = 0;
        if(grid == null || grid.length == 0 || grid[0].length==0){
            return count;
        }

        ROW = grid.length;
        COL = grid[0].length;
        boolean visited[][] = new boolean[ROW][COL];

        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (grid[i][j] == '1' && !visited[i][j]) {
                    DFS(grid, i, j, visited);
                    ++count;
                }

        return count;
    }

    boolean isSafe(char M[][], int row, int col,
                   boolean visited[][]) {

        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == '1' && !visited[row][col]);
    }

    void DFS(char M[][], int row, int col, boolean visited[][]) {

        int rowNbr[] = new int[] { -1, 0, 0, 1 };
        int colNbr[] = new int[] { 0, -1, 1, 0 };

        visited[row][col] = true;

        for (int k = 0; k < 4; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    public int numIslands2(char[][] grid) { // 1ms
        int ni = grid.length;
        if(ni==0) return 0;
        int nj = grid[0].length;
        boolean[][] seen = new boolean[ni][nj];
        int cnt = 0;
        for(int i=0;i<ni;i++){
            for(int j=0;j<nj;j++){
                if(!seen[i][j] && grid[i][j]=='1'){
                    explore(grid,i,j,seen);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void explore(char[][] grid, int i, int j, boolean[][] seen){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && !seen[i][j] && grid[i][j]=='1'){
            seen[i][j] = true;
            explore(grid,i+1,j,seen);
            explore(grid,i-1,j,seen);
            explore(grid,i,j+1,seen);
            explore(grid,i,j-1,seen);
        }
        else{
            return;
        }
    }

    public static void main(String[] args) {
        int A = 9;
        System.out.println(Math.sqrt(A));
        int res = (int) Math.floor(Math.sqrt(10));
        System.out.println( (int) Math.floor(Math.sqrt(10)));
        System.out.println( (int) Math.floor(Math.sqrt(0)));
    }
}
