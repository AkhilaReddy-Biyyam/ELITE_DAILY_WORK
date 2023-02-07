import java.util.ArrayList;
public class Solution {
  static ArrayList<ArrayList<Integer>>adjList;
  static boolean [] visited;
  static boolean [] predecessor;
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
    adjList=new ArrayList<>(n);
    for(int i=0;i<=n;i++){
        adjList.add(new ArrayList<Integer>());
    }
    for(int j=0;j<edges.size();j++){
      int vertex1=edges.get(j).get(0);
      int vertex2=edges.get(j).get(1);
      adjList.get(vertex1).add(vertex2);
    }
    visited=new boolean[n+1];
    predecessor=new boolean[n+1];
    for(int v=1;v<=n;v++){
      if(!visited[v]){
          if(hasCycle(v))
              return true;
      }
    }
    return false;
  }
  public static boolean hasCycle(int source){
    visited[source]=true;
    predecessor[source]=true;
    boolean result=false;
    for(int neighbour:adjList.get(source)){
      if(predecessor[neighbour])
        return true;
      if(!visited[neighbour])
        result=result||hasCycle(neighbour);
    }
    predecessor[source]=false;
    return result;
  }
}
