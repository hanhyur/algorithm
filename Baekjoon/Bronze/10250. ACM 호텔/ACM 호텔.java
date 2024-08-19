import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int t, h, w, n;
    static int[][] arr;
    
    // 변수 값 입력 받음
    static void input() {
        t = scan.nextInt();
        arr = new int[t][3];
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(scan.nextLine());
        
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    static void func() {
        for (int i = 0; i < t; i++) {
            h = arr[i][0];
            n = arr[i][2];
            
            int floor = (n % h) * 100;
            int room = (n / h) + 1;
            
            if (floor == 0) {
                floor = h * 100;
                room = n / h;
            }
            
            sb.append(floor + room).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    public static void main(String[] args) throws IOException {
        input();
        
        func();
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return str;
        }
    }
    
}
