import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
class Pair implements Comparable<Pair>{
    int node,distance;
    Pair(){}
    Pair(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
    public int compareTo(Pair a){
        return distance-a.distance;
    }
}

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Write your code here.
        ArrayList<ArrayList<Pair>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int v1=g.get(i).get(0);
            int v2=g.get(i).get(1);
            int dis=g.get(i).get(2);
            adjList.get(v1-1).add(new Pair(v2-1,dis));
            adjList.get(v2-1).add(new Pair(v1-1,dis));
        }
        int src=0;
        PriorityQueue<Pair>queue=new PriorityQueue<>();
        queue.add(new Pair(src,0));
        ArrayList<Integer>weights=new ArrayList<>();
        ArrayList<Integer>parents=new ArrayList<>();
        boolean [] visited=new boolean[n];
        for(int i=0;i<n;i++){
            weights.add(Integer.MAX_VALUE);
            parents.add(-1);
        }
        weights.set(src,0);
        visited[src]=true;
        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            int u=curr.node;
            visited[u]=true;
            for(Pair neigh:adjList.get(u)){
                int v=neigh.node;
                int wt=neigh.distance;
                if(!visited[v] && weights.get(v)>wt){
                    weights.set(v,wt);
                    queue.add(new Pair(v,wt));
                    parents.set(v,u);
                }
            }
        }
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        for(int i=1;i<n;i++){
            res.add(new ArrayList<>());
            res.get(i-1).add(parents.get(i)+1);
            res.get(i-1).add(i+1);
            res.get(i-1).add(weights.get(i));
        }
        return res;
    }
}
