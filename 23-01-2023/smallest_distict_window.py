#User function Template for python3

class Solution:
    def findSubString(self, s):
        d={}
        for key in s:
            d[key] = d.get(key, 0)+1

        temp={}
        have=0
        need=len(d)
        res=[-1,-1]
        resLen =1000000000000000000

        #2 pointers(left and right)
        l = 0
        visited=set()
        for r in range(len(s)):
            curr = s[r]
            temp[curr] = 1 + temp.get(curr, 0)

            
            if curr not in visited:      
                if curr in d and temp[curr] >= 1:
                    have += 1
                
            visited.add(curr)
                        
            while have == need:
                # update our result
                if r - l + 1 < resLen:
                    resLen = r - l + 1
                    res = [l, r]      
                # pop from left of window
                temp[s[l]] -= 1
                if s[l] in d and temp[s[l]] < 1:
                    have -= 1
                    visited.remove(s[l])
                l += 1
                        
        l, r = res
        return resLen


        # Your code goes here
    


    
    
    


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def main():

    T = int(input())

    while(T > 0):
    	str = input()
    	ob=Solution()
    	print(ob.findSubString(str))
    	
    	T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends