N = int(input())
arr = list(map(int, input().split()))
max_val = max(arr)

tot = 0
for i in arr:
    if i !=0:
        tot += i/max_val*100

print(tot/N)