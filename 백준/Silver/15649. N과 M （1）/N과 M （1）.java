import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr,ans;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		isSelected =new boolean[N];
		
		perm(0);
		
	}
	
	private static void perm(int idx) {
		
		if(idx==M) {
			for(int i:ans) System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			ans[idx] = i+1;
			perm(idx+1);
			isSelected[i] = false;
		}
	}
}
