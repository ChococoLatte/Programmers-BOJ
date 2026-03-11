import sys
input = sys.stdin.readline

N,M = map(int, input().split())
arr = [[0]*(N+1) for _ in range(N+1)]

for i in range(1, N+1):
    row = list(map(int, input().split()))
    for j in range(1, N+1):
        arr[i][j] = row[j-1]+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]

for _ in range(M):
    A,B,C,D = map(int, input().split())
    tot = arr[C][D]-arr[A-1][D]-arr[C][B-1]+arr[A-1][B-1]
    print(tot)