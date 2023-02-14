class Solution {
    List<List<Integer>>res=new ArrayList<>();
    List<Integer>curr=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src=0;
        int target=graph.length-1;
        curr.add(0);
        dfs(0,target,graph);
        return res;
    }
    public void dfs(int src,int target,int[][] graph){
        if(src==target){
            res.add(new ArrayList(curr));
            return;
        }
        for(int neigh:graph[src]){
            curr.add(neigh);
            dfs(neigh,target,graph);
            curr.remove(curr.size()-1);
        }
    }
}


