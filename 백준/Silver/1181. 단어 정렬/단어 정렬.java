import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length()-o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append("\n");
        for(int i=1;i<arr.length;i++){
            if(!arr[i-1].equals(arr[i])) sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}