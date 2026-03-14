import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

arr = list(map(int, input().split()))
arr.sort()

left = 0
right = N-1
ans = 0

while left < right:
    sum = arr[left]+arr[right]
    
    if sum < M:
        left += 1
    elif sum > M:
        right -= 1
    else:
        ans += 1
        left += 1
        right -= 1

print(ans)
    