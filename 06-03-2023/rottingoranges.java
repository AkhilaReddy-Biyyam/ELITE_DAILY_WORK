class Pair{
    private int row,col,val;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
        val=2;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int fresh=0;
        Queue<Pair>queue=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2)
                    queue.add(new Pair(i,j));
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0)
            return 0;
        int time=0;
        int count=0;
        int [] offsetRow={-1,0,1,0};
        int [] offsetCol={0,1,0,-1};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=1;i<=size;i++){
                Pair temp=queue.poll();
                int r=temp.getRow();
                int c=temp.getCol();
                for(int j=0;j<4;j++){
                    int nextr=r+offsetRow[j];
                    int nextc=c+offsetCol[j];
                    if(nextr<0||nextr>=rows || nextc<0||nextc>=cols)
                        continue;
                    if(grid[nextr][nextc]==1){
                        queue.add(new Pair(nextr,nextc));
                        grid[nextr][nextc]=2;
                        count++;
                    }
                }
                
            }
            time++;
        }
        if(fresh==count)
            return time-1;
        return -1;
    }
}
