class Solution:
    def myAtoi(self, s: str) -> int:
        s=s.strip()
        sign=1
        i=0
        res=0
        if(len(s)==0):
            return 0
        if(s[0]=='-'):
            sign=-1
            i+=1
        if(s[0]=='+'):
            i+=1
        for j in range(i,len(s)):
            if not s[j].isdigit():
                break
            else:
                res=res*10+int(s[j])
        res*=sign
        if res>2**31-1:
            return 2**31-1
        elif res<-2**31:
            return -2**31
        else:
            return res
        