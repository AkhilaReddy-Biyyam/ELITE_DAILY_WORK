class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        def length(s,start,end,k):
            d={}
            if(end<k):
                return 0
            for i in range(start,end):
                d[s[i]]=d.get(s[i],0)+1
            for i in range(start,end):
                if(d[s[i]]<k):
                    return max(length(s,start,i,k),length(s,i+1,end,k))
            return end-start
        return length(s,0,len(s),k)
        