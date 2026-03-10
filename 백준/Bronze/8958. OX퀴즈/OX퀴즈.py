num = int(input())

for _ in range(num):
    ans = list(input())
    
    tot = 0
    plus_score = 0
    for i in ans:
        if i == 'O':
            plus_score += 1
            tot = tot+plus_score
        else:
            plus_score = 0
    print(tot)
        
        
      

    