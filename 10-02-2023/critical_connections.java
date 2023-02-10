class Solution {
    ArrayList<ArrayList<Integer>>adjList;
    boolean [] visited;
    int [] low;
    int [] disc;
    int time=0;
    List<List<Integer>>res;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            int v1=connections.get(i).get(0);
            int v2=connections.get(i).get(1);
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        visited=new boolean[n];
        low=new int [n];
        disc=new int [n];
        res=new ArrayList<>();
        dfs(0,-1);
        return res;
    }
    public void dfs(int u,int parent){
        visited[u]=true;
        disc[u]=low[u]=time;
        time++;
        for(int v:adjList.get(u)){
            if(v==parent) continue;
            if(!visited[v]){
                dfs(v,u);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>disc[u])
                    res.add(Arrays.asList(u,v));
            }
            else{
                low[u]=Math.min(low[u],low[v]);
            }
        }
    }
}
