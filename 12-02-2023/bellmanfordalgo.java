

// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int [] dist=new int [n];
        for(int i=0;i<n;i++){
            dist[i]=(int)1e8;
        }
        dist[S]=0;
        //n-1 iterations
        for(int i=0;i<n-1;i++){
            for(ArrayList<Integer>list:edges){
                int u=list.get(0);
                int v=list.get(1);
                int weight=list.get(2);
                if(dist[u]!=1e8 && dist[v]>dist[u]+weight)
                    dist[v]=dist[u]+weight;
            }
        }
        //checks for negative cycle
        for(ArrayList<Integer>list:edges){
            int u=list.get(0);
            int v=list.get(1);
            int weight=list.get(2);
            if(dist[u]!=1e8 && dist[v]>dist[u]+weight){ 
                int [] res={-1};
                return res;
            }
        }
        return dist;
    }
}
