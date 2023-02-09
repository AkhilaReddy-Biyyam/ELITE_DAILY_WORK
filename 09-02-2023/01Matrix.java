class Pair{
    int row,col;
    Pair(){}
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair>queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j));
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        int [] offsetRow={-1,0,1,0};
        int [] offsetCol={0,1,0,-1};
        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            int r=curr.row;
            int c=curr.col;
            for(int i=0;i<4;i++){
                int newR=r+offsetRow[i];
                int newC=c+offsetCol[i];
                if(newR>=0 && newR<n && newC>=0 && newC<m && mat[newR][newC]==-1){
                    mat[newR][newC]=mat[r][c]+1;
                    queue.add(new Pair(newR,newC));
                }
            }
        }
        return mat;
    }
}

