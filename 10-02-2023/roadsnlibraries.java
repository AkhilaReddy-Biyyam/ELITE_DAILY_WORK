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

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */
    static ArrayList<ArrayList<Integer>>adjList;
    static boolean [] visited;
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    // Write your code here
        adjList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<cities.size();i++){
            int vertex1=cities.get(i).get(0);
            int vertex2=cities.get(i).get(1);
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }
        visited=new boolean[n+1];
        long libraries=0;
        long roads=0;
        long cost=(long)n*c_lib;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                roads+=bfs(i);
                libraries=(long)n-roads;
                long temp_cost=roads*(long)c_road+libraries*(long)c_lib;
                cost=Math.min(cost,temp_cost);
            }
        }
        return cost;
    }
    public static long bfs(int source){
        long curr_roads=0;
        visited[source]=true;
        Queue<Integer>queue=new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int neigh:adjList.get(curr)){
                if(!visited[neigh]){ 
                    visited[neigh]=true;
                    queue.add(neigh);
                    curr_roads++;
                }
            }    
        }
        return curr_roads;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
