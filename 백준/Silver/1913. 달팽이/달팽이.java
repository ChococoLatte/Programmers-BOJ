import java.util.*;
import java.io.*;

class Main {
    static int N,V;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        Rotate();

        int x = 0;
        int y = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(arr[i][j]).append(" ");
                if(arr[i][j] == V){
                    x = i+1;
                    y = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(x+" "+y);
        System.out.println(sb);
    }

    static void Rotate() {
        int num = 1;
        int x = N / 2;  // 시작 위치는 배열의 중앙
        int y = N / 2;
        
        arr[x][y] = num; // 중앙부터 시작
    
        int step = 1; // 각 방향으로 이동할 거리
        while (num < N * N) { // 배열에 숫자 N*N까지 채울 때까지 반복
            for (int i = 0; i < 4; i++) { // 네 방향으로 반복
                for (int j = 0; j < step; j++) { // 현재 방향으로 step 만큼 이동
                    if (num >= N * N) return; // 숫자를 다 채우면 종료

                    x += dx[i];
                    y += dy[i];

                if (x >= 0 && y >= 0 && x < N && y < N) { // 배열의 범위를 넘지 않는 경우
                    arr[x][y] = ++num;
                }
            }
            if (i % 2 == 1) step++; // 두 방향 이동할 때마다 step을 1 증가시킴
            }
        }
    }
}