import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int P = Integer.parseInt(br.readLine());
        
        while (P-- > 0) {
            String[] input = br.readLine().split(" ");
            
            int T = Integer.parseInt(input[0]);
            int[] h = new int[20];
            
            for (int i = 0; i < 20; i++) {
                h[i] = Integer.parseInt(input[i + 1]);
            }
            
            int[] sorted = new int[20];
            int move = 0;
            
            for (int i = 0; i < 20; i++) {
                int current = h[i];
                int pos = Arrays.binarySearch(sorted, 0, i, current);
                
                if (pos < 0) {
                    pos = -pos - 1;
                }
                
                move += i - pos;
                
                System.arraycopy(sorted, pos, sorted, pos + 1, i - pos);
                sorted[pos] = current;
            }
            
            System.out.println(T + " " + move);
        }
    }
}