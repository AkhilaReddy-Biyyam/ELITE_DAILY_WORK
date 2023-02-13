

class Solution
{
    //Function to return Breadth First Traversal of given graph.
    boolean [] visited;
    int [] low;
    int [] disc;
    int time=0;
    int [] res;
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>>adjList)
    {
        // Code here
        visited=new boolean[n];
        low=new int[n];
        disc=new int [n];
        res=new int [n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,-1,adjList);
            }
        }
        ArrayList<Integer>arti_points=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res[i]==1)
                arti_points.add(i);
        }
        if(arti_points.size()==0) arti_points.add(-1);
        return arti_points;
        
    }
    public void dfs(int u,int parent,ArrayList<ArrayList<Integer>>adjList){
        visited[u]=true;
        disc[u]=low[u]=time;
        time++;
        int child=0;
        for(int v:adjList.get(u)){
            if(v==parent) continue;
            if(!visited[v]){
                dfs(v,u,adjList);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>=disc[u] && parent!=-1)
                    res[u]=1;
                child++;
            }
            else{
                low[u]=Math.min(low[u],disc[v]);
            }
        }
        if(parent==-1 && child>1)
            res[u]=1;
    }
}
