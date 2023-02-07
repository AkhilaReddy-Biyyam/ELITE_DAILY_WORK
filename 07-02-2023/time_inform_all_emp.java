class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dfs(i,manager,informTime));
        }
        return max;
    }
    public int dfs(int i,int[] manager, int[] informTime){
        if(manager[i]!=-1){
            informTime[i]+=dfs(manager[i],manager,informTime);
            manager[i]=-1;
        }
        return informTime[i];
    }
}

 
