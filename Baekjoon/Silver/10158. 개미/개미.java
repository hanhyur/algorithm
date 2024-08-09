import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] size = br.readLine().split(" ");
        String[] startPoint = br.readLine().split(" ");
        int t = Integer.parseInt(br.readLine());
        
        int w = Integer.parseInt(size[0]);
        int h = Integer.parseInt(size[1]);
        
        int p = Integer.parseInt(startPoint[0]);
        int q = Integer.parseInt(startPoint[1]);
        
        int x = getCoordinatesAfterTime(w, p, t);
        int y = getCoordinatesAfterTime(h, q, t);
        
        System.out.println(x + " " + y);
    }
    
    private static int getCoordinatesAfterTime(int size, int point, int time) {
        int vector = 1;
        int moduleTime = time % (2 * size);
        
        while (moduleTime-- > 0) {
            if (point == size) {
                vector = -1;
            } else if (point == 0) {
                vector = 1;
            }
            
            point += vector;
        }
        
        return point;
    }
}