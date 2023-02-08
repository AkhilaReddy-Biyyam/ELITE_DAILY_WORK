class Solution {
    static ArrayList<ArrayList<Integer>>adjList;
    static boolean [] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        adjList=new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int j=0;j<prerequisites.length;j++){
            int vertex1=prerequisites[j][0];
            int vertex2=prerequisites[j][1];
            adjList.get(vertex2).add(vertex1);
            indegree[vertex1]++;
        }
        visited=new boolean[numCourses+1];
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
        if(res.size()==numCourses)
            return true;
        return false;
    }
}
