import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr =  new int[9][9];
        for(int i=0;i<9;i++){
            String s = br.readLine();
            for(int j=0;j<9;j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        list = new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(arr[i][j] == 0){
                    list.add(new int[] {i,j});
                }
            }
        }

        insertNumber(0);
        
    }

    static void insertNumber(int cnt){
        if(cnt == list.size()){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }
        
        boolean[] visited = new boolean[10];

        int x = list.get(cnt)[0];
        int y = list.get(cnt)[1];

        for(int i=0;i<9;i++){
            if(arr[x][i]!=0) visited[arr[x][i]] = true;
            if(arr[i][y]!=0) visited[arr[i][y]] = true;
        }

        int rx = (x/3)*3;
        int ry = (y/3)*3;

        for(int i=rx;i<rx+3;i++){
            for(int j=ry;j<ry+3;j++){
                if(arr[i][j]!=0) visited[arr[i][j]] = true;
            }
        }

        for(int i=1;i<=9;i++){
            if(!visited[i]){
                arr[x][y] = i;
                insertNumber(cnt+1);
                arr[x][y] = 0;
            }
        }

    }
}