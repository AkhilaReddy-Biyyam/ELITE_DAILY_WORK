class Pair implements Comparable<Pair>{
    int time,row,col;
    Pair(){}
    Pair(int time,int row,int col){
        this.time=time;
        this.row=row;
        this.col=col;
    }
    public int compareTo(Pair a){
        return time-a.time;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean [][]visited=new boolean [n][n];
        PriorityQueue<Pair>queue=new PriorityQueue<>();
        int res=Math.max(grid[0][0],grid[n-1][n-1]);
        if(res==0) return 0;
        queue.add(new Pair(res,0,0));
        int[] offsetRow={-1,0,1,0};
        int [] offsetCol={0,1,0,-1};
        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            int r=curr.row;
            int c=curr.col;
            res=Math.max(res,curr.time);
            for(int i=0;i<4;i++){
                int newR=r+offsetRow[i];
                int newC=c+offsetCol[i];
                if(newR>=0 && newR<n && newC>=0 && newC<n && visited[newR][newC]==false){
                    if(newR==n-1 && newC==n-1)
                        return res;
                    queue.add(new Pair(grid[newR][newC],newR,newC));
                    visited[newR][newC]=true;
                }
            }
        }
        return -1;

    }
}
