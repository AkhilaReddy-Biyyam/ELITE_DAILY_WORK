class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited=new boolean[rooms.size()];
        Stack<Integer>stack=new Stack<>();
        stack.push(0);
        visited[0]=true;
        while(!stack.isEmpty()){
            int curr=stack.pop();
            for(int neigh:rooms.get(curr)){
                if(!visited[neigh]){
                    visited[neigh]=true;
                    stack.push(neigh);
                }
            }
        }
        for(int i=0;i<rooms.size();i++){
            if(visited[i]==false)
                return false;
        }
        return true;
        
    }
}
