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

class Edge implements Comparable<Edge>{
    int src,dest,wt;
    Edge(){}
    Edge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
    public int compareTo(Edge a){
        return wt-a.wt;
    }
}
class Result {
    public static int kruskals(int V, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int e=gFrom.size();
        List<Edge>edgesList=new ArrayList<>();
        int [] parent=new int[V];
        int [] rank=new int[V];
        int summ=0;
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        for(int i=0;i<e;i++){
            edgesList.add(new Edge(gFrom.get(i)-1,gTo.get(i)-1,gWeight.get(i)));
        }
        Collections.sort(edgesList);
        for(int i=0;i<e;i++){
            int u=edgesList.get(i).src;
            int v=edgesList.get(i).dest;
            int dist=edgesList.get(i).wt;
            int x=find(u,parent);
            int y=find(v,parent);
          

            if(x!=y){
                summ+=dist;
                unionByRank(x,y,parent,rank);
            }
        }
        return summ;
    }
    public static int find(int i,int [] parent){
        if(i==parent[i])
            return parent[i];
        parent[i]=find(parent[i],parent);
        return parent[i];
    }
    public static void unionByRank(int x,int y,int [] parent, int [] rank){
        int rootX=find(x,parent);
        int rootY=find(y,parent);
        if(rank[rootX]<rank[rootY]){
            parent[rootX]=rootY;
        }
        else if(rank[rootX]>rank[rootY]){
            parent[rootY]=rootX;
        }
        else{
            parent[rootY]=rootX;
            rank[rootX]+=1;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));

        bufferedReader.close();
        bufferedWriter.close();
    }
}
