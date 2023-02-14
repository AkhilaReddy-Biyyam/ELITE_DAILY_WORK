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
class Solution{
    static int [] parent;
    static int [] rank;
    static int [] size;
	static int spanningTree(int V, int e, int edges[][]){
	    List<Edge>edgesList=new ArrayList<>();
	    // Code Here. 
	    parent=new int[V];
	    rank=new int[V];
	    size=new int[V];
	    int summ=0;
	    for(int i=0;i<V;i++){
	        parent[i]=i;
	        size[i]=1;
	    }
	    for(int i=0;i<e;i++){
	        edgesList.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
	    }
	    Collections.sort(edgesList);
	    for(int i=0;i<e;i++){
	        int u=edgesList.get(i).src;
	        int v=edgesList.get(i).dest;
	        int dist=edgesList.get(i).wt;
	        int x=find(u);
	        int y=find(v);
	        if(x!=y){
	            summ+=dist;
	            unionByRank(x,y);
	        }
	    }
	    return summ;
	    
	}
	static int find(int i){
	    if(i==parent[i])
	        return parent[i];
	    parent[i]=find(parent[i]);
	    return parent[i];
	}
	static void unionByRank(int x,int y){
	    int rootX=find(x);
	    int rootY=find(y);
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
	static void unionBySize(int x,int y){
	    int rootX=find(x);
	    int rootY=find(y);
	    if(rootX==rootY) return;
	    if(size[rootX]<size[rootY]){
	        parent[rootX]=rootY;
	        size[rootY]=size[rootY]+size[rootX];
	    }
	    else{
	        parent[rootY]=rootX;
	        size[rootX]=size[rootX]+size[rootY];
	    }
	}
	
}
