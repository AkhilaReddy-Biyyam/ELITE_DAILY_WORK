class Solution:
    def fourSum(self, arr: List[int], target: int) -> List[List[int]]:
        n=len(arr)
        if n<4:
            return []
        arr.sort()
        res=set([])
        for i in range(n-3):
            for j in range(i+1,n-2):
                left=j+1
                right=n-1
                while(left<right):
                    sum=arr[i]+arr[j]+arr[left]+arr[right]
                    if sum==target:
                        temp=(arr[i],arr[j],arr[left],arr[right])
                        if temp not in res:
                            res.add(temp)
                        left+=1
                        right-=1
                    elif sum<target:
                        left+=1
                    else:
                        right-=1
        return res
