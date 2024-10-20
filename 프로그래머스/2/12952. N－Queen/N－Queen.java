class Solution {
    static int answer;

    public int solution(int n) {
        answer = 0;
        boolean[] cols = new boolean[n]; // 열 체크
        boolean[] diag1 = new boolean[2 * n]; // 대각선 체크 (r - c + n)
        boolean[] diag2 = new boolean[2 * n]; // 반대 대각선 체크 (r + c)

        dfs(0, n, cols, diag1, diag2);
        return answer;
    }

    static void dfs(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diag1[row - col + n] && !diag2[row + col]) {
                cols[col] = true;
                diag1[row - col + n] = true;
                diag2[row + col] = true;

                dfs(row + 1, n, cols, diag1, diag2);

                // 백트래킹
                cols[col] = false;
                diag1[row - col + n] = false;
                diag2[row + col] = false;
            }
        }
    }
}