import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int h, w, n, m;
    
    // 변수 값 입력 받음
    static void input() {
        h = Integer.parseInt(scan.next());
        w = Integer.parseInt(scan.next());
        n = Integer.parseInt(scan.next());
        m = Integer.parseInt(scan.next());
    }
    
    static void func() {
        int row = h;
        int rowGap = n + 1;
        int rowCnt = 0;
        
        int col = w;
        int colGap = m + 1;
        int colCnt = 0;
        
        while(row >= 1) {
            rowCnt++;
            row = row - rowGap;
        }
        
        while(col >= 1) {
            colCnt++;
            col = col - colGap;
        }
        
        int answer = rowCnt * colCnt;
        
        System.out.println(answer);
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