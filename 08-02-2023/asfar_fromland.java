class Pair{
    int row,col,val;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>queue=new LinkedList<>();
        int [][] visited=new int[n][m];
        int waterCells=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=grid[i][j];
                if(grid[i][j]==1){
                    queue.add(new Pair(i,j));
                }
                else if(grid[i][j]==0)
                    waterCells++;
            }
        }
        int distance=0;
        int [] offsetRow={-1,0,1,0};
        int [] offsetCol={0,1,0,-1};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int k=0;k<size;k++){
                Pair curr=queue.poll();
                int r=curr.row;
                int c=curr.col;
                for(int x=0;x<4;x++){
                    int nextR=r+offsetRow[x];
                    int nextC=c+offsetCol[x];
                    if(nextR>=0 && nextR<n && nextC>=0 && nextC<m && visited[nextR][nextC]==0){
                        visited[nextR][nextC]=1;
                        queue.add(new Pair(nextR,nextC));
                    }
                }
            }
            distance++;
        }
        if(waterCells==0)
            return -1;
        return distance-1;


    }
}

