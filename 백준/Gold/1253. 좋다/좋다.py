import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
arr.sort()

def two_pointer(cur, M):
    flag = False
    left = 0;
    right = N-1
    
    while left < right:
        if left == cur:
            left +=1
            continue
        elif right == cur:
            right-=1
            continue
        sum = arr[left]+arr[right]
        
        if sum < M:
            left += 1
        elif sum > M:
            right -=1
        else:
            flag = True
            break
    
    return flag

ans = 0
for i in range(N):
    if two_pointer(i ,arr[i]):
        ans+=1
    
print(ans)
    
            