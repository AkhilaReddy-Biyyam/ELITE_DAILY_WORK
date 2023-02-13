import java.util.*;
public class Solution {

    static ArrayList<ArrayList<Integer>>adjList;
    static boolean [] visited;
    static boolean [] visited2;
    static Stack<Integer>stack;
    static ArrayList<ArrayList<Integer>>revGraph;
    static List<Integer>list;
    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            adjList.get(v1).add(v2);
        }
        visited=new boolean[n];
        stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        revGraph=new ArrayList<>();
        visited2=new boolean[n];
        for(int i=0;i<n;i++){
            revGraph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int adj:adjList.get(i))
                revGraph.get(adj).add(i);
        }
        List<List<Integer>>res=new ArrayList<>();
        while(!stack.isEmpty()){
            list=new ArrayList<>();
            int curr=stack.pop();
            if(!visited2[curr]){
                dfs2(curr);
                res.add(list);
            }
        }
        return res;


    }
    public static void dfs(int source){
        visited[source]=true;
        for(int neigh:adjList.get(source)){
            if(!visited[neigh])
                dfs(neigh);
        }
        stack.push(source);

    }
    public static void dfs2(int s){
        visited2[s]=true;
        list.add(s);
        for(int neig:revGraph.get(s)){
            if(!visited2[neig])
                dfs2(neig);
        }
    }
}
