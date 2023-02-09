class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] != 0)
                    max = Math.max(max, maxGold(grid,i,j,n,m));
            }
        }
        return max;
    }
        
    public int maxGold(int[][] grid,int r,int c,int n,int m){
        if(r < 0 || c < 0 || r == n || c == m || grid[r][c] == 0)
            return 0;
        int temp = grid[r][c];

        grid[r][c] = 0;
        int right = maxGold(grid,r,c+1,n,m);
        int left = maxGold(grid,r,c-1,n,m);
        int down = maxGold(grid,r+1,c,n,m);
        int up = maxGold(grid,r-1,c,n,m);
        grid[r][c] = temp;

        return temp + Math.max(right,Math.max(left,Math.max(down,up)));
    }
}
