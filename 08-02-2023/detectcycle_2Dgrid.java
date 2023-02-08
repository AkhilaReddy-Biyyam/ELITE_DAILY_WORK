
class Solution {
    boolean[][] visited;
    int[] offset_X = {1, -1, 0, 0};
    int[] offset_Y = {0, 0, 1, -1};
	
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        boolean hasCycle = false;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (!visited[i][j]) {
                    hasCycle |= dfs(i, j, -1, -1, n, m, grid);
                }
            }
        }
        return hasCycle;
    }

    public boolean dfs(int x, int y, int parentX, int parentY, int n, int m,char[][] grid) {
        visited[x][y] = true;
        boolean hasCycle = false;
        for (int i = 0; i < 4; ++i) {
            int newX = x+offset_X[i];
            int newY = y+offset_Y[i];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {//valid or not
                if (grid[newX][newY] ==grid[x][y]) { //both chars are same or not
                    if(!(newX==parentX && newY==parentY)){ //parent is not the last visited one
                        if (visited[newX][newY]) 
                            return true;
                        else
                            hasCycle=hasCycle|| dfs(newX, newY,x,y, n, m, grid);
                    }
                }
            }
        }
        return hasCycle;
    }
}
