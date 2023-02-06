import java.util.* ;
import java.io.*; 
public class Solution {
	static ArrayList<ArrayList<Integer>>adjList;
	static boolean [] visited;
	static ArrayList<Integer>res=new ArrayList<>();
	public static ArrayList<Integer> BFS(int v, int edges[][]){
		// WRITE YOUR CODE HERE
		adjList=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges[0].length;i++){
            int vertex1=edges[0][i];
            int vertex2=edges[1][i];
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }
        visited=new boolean[v];
		for (int i=0;i<v;i++){
			if (!visited[i]){
				bfs(i);
			}
		}
		return res;

	}
	public static void bfs(int s){
		Queue<Integer>queue=new LinkedList<>();
		queue.add(s);
		res.add(s);
		visited[s]=true;
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0;i<size;i++){
				int curr=queue.poll();
				ArrayList<Integer>list=new ArrayList<Integer>();
				for(int neighbour:adjList.get(curr)){
					if(!visited[neighbour]){
						queue.add(neighbour);
						list.add(neighbour);
						visited[neighbour]=true;
					}
				}
				Collections.sort(list);
				res.addAll(list);
			}
		}
	}
}

