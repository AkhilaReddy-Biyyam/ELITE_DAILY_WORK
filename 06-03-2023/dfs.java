import java.util.ArrayList;

public class Solution {
    static ArrayList<ArrayList<Integer>>adjList;
    static boolean [] visited;
    static ArrayList<Integer>list;
    static ArrayList<ArrayList<Integer>>dfs_lists;
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        adjList=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<e;i++){
            int vertex1=edges.get(i).get(0);
            int vertex2=edges.get(i).get(1);
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }
        visited=new boolean[v+1];
        dfs_lists=new ArrayList<>();
        for(int vertex=0;vertex<v;vertex++){
            list=new ArrayList<>();
            if(!visited[vertex]){
                dfs(vertex);
                dfs_lists.add(list);
            }
        }
        return dfs_lists;

    }
    public static void dfs(int source_v){
        visited[source_v]=true;
        list.add(source_v);
        for(int neighbour:adjList.get(source_v)){
            if(!visited[neighbour])
                dfs(neighbour);

        }
    }
}
