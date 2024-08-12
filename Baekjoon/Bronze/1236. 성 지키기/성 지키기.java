import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        
        String[] arr = new String[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        int needRowCount = 0;
        int needColCount = 0;
        
        for (int i = 0; i < N; i++) {
            if (!arr[i].contains("X")) {
                needRowCount++;
            }
        }
        
        for (int i = 0; i < M; i++) {
            boolean need = true;
            
            for (int j = 0; j < N; j++) {
                if (arr[j].charAt(i) == 'X') {
                    need = false;
                    
                    break;
                }
            }
            
            if (need) {
                needColCount++;
            }
        }
        
        System.out.println(Math.max(needRowCount, needColCount));
    }
    
}