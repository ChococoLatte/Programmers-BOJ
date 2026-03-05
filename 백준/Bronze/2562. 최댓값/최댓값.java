import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=1;i<=9;i++){
            int a = Integer.parseInt(br.readLine());
            
            if(max<a){
                max = a;
                maxIndex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }
}