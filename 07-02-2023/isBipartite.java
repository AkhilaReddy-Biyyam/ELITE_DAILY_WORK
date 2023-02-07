class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int [] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(check(i,color,graph)==false)
                    return false;
            }
        }
        return true;
    }
    public boolean check(int i,int [] color,int[][] graph){
        Queue<Integer>queue=new LinkedList<>();
        queue.add(i);
        color[i]=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int neighbour:graph[curr]){
                if(color[neighbour]==-1){ 
                    color[neighbour]=1-color[curr];
                    queue.add(neighbour);
                }
                else if(color[neighbour]==color[curr])
                    return false;
            }
        }
        return true;
    }
}
