class Solution {
    public int findCenter(int[][] edges) {
        int res=edges[0][0];
        if(edges[1][0]==res || edges[1][1]==res)
            return res;
        return edges[0][1];
    }
}
