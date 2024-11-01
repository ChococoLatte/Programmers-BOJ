import java.util.*;
import java.io.*;

class Main {
    static int[] m = {500,100,50,10,5,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        int change = 1000-v;

        int cnt = 0;
        int idx = 0;
        while(change!=0){

            if(change>=m[idx]){
                change-=m[idx];
                cnt++;
            }else idx++;
        }

        System.out.println(cnt);
    }
}