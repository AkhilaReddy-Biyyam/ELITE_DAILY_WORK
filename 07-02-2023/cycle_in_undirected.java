import java.util.*;
public class Solution {
    static ArrayList<ArrayList<Integer>>adjList;
    static boolean [] visited;
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        adjList=new ArrayList<>(n);
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int j=0;j<m;j++){
            int vertex1=edges[j][0];
            int vertex2=edges[j][1];
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }
        visited=new boolean[n+1];
        for(int v=1;v<=n;v++){
            if(!visited[v]){
                if(hasCycle(v,-1))
                    return "Yes";
            }
        }
        return "No";
    }
    public static boolean hasCycle(int source,int parent){
        visited[source]=true;
        boolean result=false;
        for(int neighbour:adjList.get(source)){
            if(visited[neighbour] && parent!=neighbour)
                return true;
            if(!visited[neighbour])
                result=result||hasCycle(neighbour,source);
        }
        return result;
    }
    
}
