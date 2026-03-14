import sys
input = sys.stdin.readline

N = int(input())

left = 1
right = 1
sum = 1
ans = 1

while right < N:
    if sum < N:
        right += 1
        sum += right
    elif sum > N:
        sum -= left
        left += 1
    else:
        ans += 1
        right += 1
        sum += right
        
print(ans)
        
    

        
    