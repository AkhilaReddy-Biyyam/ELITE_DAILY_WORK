class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if(len(t)>len(s) or t==""):
            return ""

        t_dict={}
        for key in t:
            t_dict[key] = t_dict.get(key, 0)+1

        temp={}
        have=0
        need=len(t_dict)
        res=[-1,-1]
        resLen =1000000000000000000

        #2 pointers(left and right)
        l = 0
        
        for r in range(len(s)):
            curr = s[r]
            temp[curr] = 1 + temp.get(curr, 0)
                    
            if curr in t_dict and temp[curr] == t_dict[curr]:
                have += 1
                        
            while have == need:
                # update our result
                if r - l + 1 < resLen:
                    resLen = r - l + 1
                    res = [l, r]      
                # pop from left of window
                temp[s[l]] -= 1
                if s[l] in t_dict and temp[s[l]] < t_dict[s[l]]:
                    have -= 1       
                l += 1
                        
        l, r = res
        return(s[l:r+1])

