
class Solution {
    public int lengthOfSubString(String s,int start,int end,int k){
        if(end<k){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=start;i<end;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=start;i<end;i++){
            if(map.get(s.charAt(i))<k){
                return Math.max(lengthOfSubString(s,start,i,k),lengthOfSubString(s,i+1,end,k));
            }
        }
        return end-start;
        
    }
    public int longestSubstring(String s, int k) {
        return lengthOfSubString(s,0,s.length(),k);
    }
}