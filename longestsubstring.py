class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s=="":
            return 0
        window=""
        maxx=-1
        for i in s:
            if i in window:
                window=window[window.index(i)+1:]
            window+=i
            maxx=max(len(window),maxx)
        return(maxx)
        