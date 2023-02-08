import java.util.* ;
import java.io.*; 

class Pair implements Comparable<Pair>{
	int distance,dest;
	Pair(){
		
	}
	Pair(int dest,int distance){
		this.dest=dest;
		this.distance=distance;
		
	}
	public int compareTo(Pair a){
		return distance-a.distance;
	}
} 
public class Solution {
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int v, int e, int source){
		// Write your code here.
		ArrayList<ArrayList<Pair>>adjList=new ArrayList<>(v);
        for(int i=0;i<=v;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int vertex1=vec.get(i).get(0);
            int vertex2=vec.get(i).get(1);
			int dis=vec.get(i).get(2);
            adjList.get(vertex1).add(new Pair(vertex2,dis));
            adjList.get(vertex2).add(new Pair(vertex1,dis));
        }
        boolean [] visited=new boolean[v+1];
		PriorityQueue<Pair>queue=new PriorityQueue<>();
		ArrayList<Integer>result=new ArrayList<>();
		for (int i=0;i<v;i++) {
            result.add(Integer.MAX_VALUE);
        }
		queue.offer(new Pair(source,0));
		result.set(source,0);
		while(!queue.isEmpty()){
			Pair curr=queue.poll();
			int u=curr.dest;
			visited[u]=true;
			for(Pair neigh:adjList.get(u)){
				int w=neigh.dest;
				int dis=neigh.distance;
				if(visited[w]==false && result.get(w)>result.get(u)+dis){
					result.set(w,result.get(u)+dis);
					queue.add(new Pair(w,result.get(w)));
				}
			}

		}
		return result;
	}
}
