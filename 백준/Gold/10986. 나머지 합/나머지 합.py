import sys
input = sys.stdin.readline

def calc(num):
    return num*(num-1)//2

N,M = map(int, input().split())
arr = list(map(int, input().split()))

pre_sum = [0]*M
prefix=0
for i in range(N):
    prefix+=arr[i]
    idx = prefix%M;
    pre_sum[idx]+=1

tot = 0
for i in range(M):
    tot+=calc(pre_sum[i])

print(tot+pre_sum[0])

    
    