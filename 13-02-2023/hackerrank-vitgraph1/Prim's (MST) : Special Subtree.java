import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


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

class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    public static int prims(int n, List<List<Integer>>g, int start) {
    // Write your code here
        ArrayList<ArrayList<Pair>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<g.size();i++){
            int v1=g.get(i).get(0);
            int v2=g.get(i).get(1);
            int dis=g.get(i).get(2);
            adjList.get(v1-1).add(new Pair(v2-1,dis));
            adjList.get(v2-1).add(new Pair(v1-1,dis));
        }
        int src=start-1;
        PriorityQueue<Pair>queue=new PriorityQueue<>();
        queue.add(new Pair(src,0));
        ArrayList<Integer>weights=new ArrayList<>();
        boolean [] visited=new boolean[n];
        for(int i=0;i<n;i++){
            weights.add(Integer.MAX_VALUE);
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
                }
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            res+=weights.get(i);
        }
        return res;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
