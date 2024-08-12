import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        
        char[][] map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            
            map[i] = row.toCharArray();
        }
        
        boolean[] isPresentInRow = new boolean[N];
        boolean[] isPresentInCol = new boolean[M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') {
                    isPresentInRow[i] = true;
                    isPresentInCol[j] = true;
                }
            }
        }
        
        int needRowCount = N;
        
        for (int i = 0; i < N; i++) {
            if (isPresentInRow[i]) {
                needRowCount--;
            }
        }
        
        int needColCount = M;
        
        for (int i = 0; i < M; i++) {
            if (isPresentInCol[i]) {
                needColCount--;
            }
        }
        
        System.out.println(Math.max(needRowCount, needColCount));
    }
    
}