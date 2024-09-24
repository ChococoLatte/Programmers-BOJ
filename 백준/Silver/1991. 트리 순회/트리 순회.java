import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb =new StringBuilder();
	static Map<Character,char[]>tree = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			char [] node = new char[3];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<3;j++) {
				node[j]=st.nextToken().charAt(0);
			}
			tree.put(node[0],node);
		}
		
		 	preOrder('A');
	        sb.append("\n");

	        inOrder('A');
	        sb.append("\n");

	        postOrder('A');
	        sb.append("\n");

	        System.out.println(sb.toString());

	        br.close();
	    }

	    private static void postOrder(char node) {
	        if(node == '.'){
	            return ;
	        }

	        postOrder(tree.get(node)[1]);
	        postOrder(tree.get(node)[2]);
	        sb.append(node);
	    }

	    private static void inOrder(char node) {
	        if(node == '.'){
	            return ;
	        }

	        inOrder(tree.get(node)[1]);
	        sb.append(node);
	        inOrder(tree.get(node)[2]);
	    }

	    private static void preOrder(char node) {
	        if(node == '.'){
	            return ;
	        }

	        sb.append(node);
	        preOrder(tree.get(node)[1]);
	        preOrder(tree.get(node)[2]);
	    }
}