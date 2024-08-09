import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] size = br.readLine().split(" ");
        int w = Integer.parseInt(size[0]);
        int h = Integer.parseInt(size[1]);
        
        String[] point = br.readLine().split(" ");
        int p = Integer.parseInt(point[0]);
        int q = Integer.parseInt(point[1]);
        
        int t = Integer.parseInt(br.readLine());
        
        int x = (t + p) % (2 * w);
        int y = (t + q) % (2 * h);
        
        if (x > w) {
            x = 2 * w - x;
        }
        
        if (y > h) {
            y = 2 * h - y;
        }
        
        System.out.println(x + " " + y);
    }
    
}