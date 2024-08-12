import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            
            int move = 0;
            int[] sorted = new int[20];
            
            for (int i = 0; i < 20; i++) {
                boolean find = false;
                
                for (int j = 0; j < i; j++) {
                    if (sorted[j] > h[i]) {
                        find = true;
                        
                        for (int k = i - 1; k >= j; k--) {
                            sorted[k + 1] = sorted[k];
                            move++;
                        }
                        
                        sorted[j] = h[i];
                        break;
                    }
                }
                
                if (!find) {
                    sorted[i] = h[i];
                }
            }
            
            System.out.println(T + " " + move);
        }
        
    }
    
}