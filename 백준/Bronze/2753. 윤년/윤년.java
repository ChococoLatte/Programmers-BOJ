import java.io.*;
import java.util.*;

public class Main {
    
    static boolean LeapYear(int a){
        if(a%4 == 0){
            if(a%100!=0) return true;
            else if(a%400 == 0) return true;
        }
        return false;
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        if(LeapYear(a)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}