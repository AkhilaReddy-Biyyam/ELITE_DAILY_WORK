import java.util.* ;
import java.io.*; 
public class Solution 
{
    static ArrayList<ArrayList<Integer>>adjList;
    static boolean [] visited;
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        int indegree[] = new int[v];
        adjList=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int j=0;j<e;j++){
            int vertex1=edges.get(j).get(0);
            int vertex2=edges.get(j).get(1);
            adjList.get(vertex1).add(vertex2);
            indegree[vertex2]++;
        }
        visited=new boolean[v+1];
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        ArrayList<Integer>res=new ArrayList<>();
        while(!queue.isEmpty()){
            int curr=queue.poll();
            res.add(curr);
            for(int neighbour:adjList.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        return res;
    }
}
