import java.util.*;

class Solution {
    static int max;
    static boolean flag;
    static int[] answer;
    
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        max = Integer.MIN_VALUE;
        int[] result = new int[11];
        dfs(0, n, info, result, 0);
        
        if (!flag) return new int[]{-1};
        return answer;
    }
    
    static void dfs(int cnt, int n, int[] info, int[] result, int start) {
        // 화살을 다 쏜 경우
        if (cnt == n) {
            int aScore = 0;
            int lScore = 0;
            
            // 점수 계산
            for (int i = 0; i < 11; i++) {
                if (info[i] == 0 && result[i] == 0) continue; // 둘 다 못 맞춘 경우
                
                if (info[i] >= result[i]) {
                    aScore += (10 - i); // 어피치가 점수를 가져감
                } else {
                    lScore += (10 - i); // 라이언이 점수를 가져감
                }
            }
            
            int diff = lScore - aScore;
            if (diff > 0) {
                flag = true;
                if (diff > max) {
                    max = diff;
                    answer = result.clone(); // 깊은 복사
                } else if (diff == max) {
                    // 더 낮은 점수를 많이 맞힌 경우가 우선
                    for (int i = 10; i >= 0; i--) {
                        if (result[i] > answer[i]) {
                            answer = result.clone(); // 깊은 복사
                            break;
                        } else if (result[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
            return;
        }
        
        // 가능한 모든 경우의 수 탐색
        for (int i = start; i < 11; i++) {
            // i점에서 어피치를 이기기 위해 필요한 최소 화살의 수
            int neededArrows = info[i] + 1;
            
            // 화살이 남은 경우에만 쏠 수 있음
            if (cnt + neededArrows <= n) {
                result[i] = neededArrows;
                dfs(cnt + neededArrows, n, info, result, i + 1);
                result[i] = 0; // 상태 복구
            }
        }
        
        // 남은 화살이 있는 경우, 0점에 몰아넣는 경우도 탐색
        if (cnt < n) {
            result[10] = n - cnt; // 남은 화살을 모두 0점에 할당
            dfs(n, n, info, result, 11); // 마지막 탐색
            result[10] = 0; // 상태 복구
        }
    }
}