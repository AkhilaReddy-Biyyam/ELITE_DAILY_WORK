class Solution {
    public ArrayList<ArrayList<Integer>>adjList;
    boolean [] visited;
    public int findCircleNum(int[][] isConnected) {
        adjList=new ArrayList<>();
        int n=isConnected.length;
        int m=isConnected[0].length;
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j && isConnected[i][j]==1){
                    adjList.get(i).add(j);
                }
            }
        }
        visited=new boolean[n+1];
        int provinces=0;
        for (int i=0;i<n;i++){
			if (!visited[i]){
                provinces++;
				dfs(i);
			}
		}
        return provinces;
        
        
    }
    public void dfs(int source_v){
        visited[source_v]=true;
        for(int neighbour:adjList.get(source_v)){
            if(!visited[neighbour])
                dfs(neighbour);
        }
    }
}
