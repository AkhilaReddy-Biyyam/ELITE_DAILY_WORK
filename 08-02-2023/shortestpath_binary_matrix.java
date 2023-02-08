class Pair{
    int length;
    int row;
    int col;
    Pair(int length,int row,int col){
        this.length=length;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0) return -1;
        int n=grid.length;
        int m=grid[0].length;
        if(n==1 && grid[0][0]==0) return 1;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        int offsetRow[]={1,-1,0,0,1,1,-1,-1};
        int offsetCol[]={0,0,1,-1,-1,1,-1,1};

        dist[0][0]=0;
        Queue<Pair>queue=new LinkedList<>();
        queue.add(new Pair(1,0,0));

        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            int currLength=curr.length;
            int currRow=curr.row;
            int currCol=curr.col;
            for(int i=0;i<8;i++){
                int nrow=currRow+offsetRow[i];
                int ncol=currCol+offsetCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){//valid cell or not
                    if(grid[nrow][ncol]==0 && currLength+1<dist[nrow][ncol]){ 
                        if(nrow==n-1 && ncol==n-1) 
                            return currLength+1;
                        queue.add(new Pair(currLength+1,nrow,ncol));
                        dist[nrow][ncol]=currLength+1;
                    }
                }
            }

        }
        return -1;
    }
}
