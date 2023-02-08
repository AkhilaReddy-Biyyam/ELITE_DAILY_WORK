//DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int startColor=image[sr][sc];
        if(startColor==color) return image;
        dfs(image,sr,sc,color,image.length,image[0].length,startColor);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color,int n,int m,int startColor){
        if(sr>=0 && sr<n && sc>=0 && sc<m && (image[sr][sc]==startColor)){
            image[sr][sc]=color;
            dfs(image,sr-1,sc,color,n,m,startColor);
            dfs(image,sr+1,sc,color,n,m,startColor);
            dfs(image,sr,sc-1,color,n,m,startColor);
            dfs(image,sr,sc+1,color,n,m,startColor);
        }
    }
}

//BFS
class Pair{
    int row,col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int startColor=image[sr][sc];
        if(startColor==color) return image;
        Queue<Pair>queue=new LinkedList<>();
        queue.add(new Pair(sr,sc));
        image[sr][sc]=color;
        int [] offsetRow={1,-1,0,0};
        int [] offsetCol={0,0,1,-1};
        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            int i=curr.row;
            int j=curr.col;
            for(int k=0;k<4;k++){
                int newRow=i+offsetRow[k];
                int newCol=j+offsetCol[k];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                    if(image[newRow][newCol]==startColor){
                        image[newRow][newCol]=color;
                        queue.add(new Pair(newRow,newCol));
                    }
                }

            }
        }
        return image;

    }
}
