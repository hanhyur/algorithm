import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        Long sum = 0L;
        
        for (int i = 0; i < 3; i++) {
            sum += Long.parseLong(st.nextToken());
        }
        
        System.out.print(sum);
    }
}