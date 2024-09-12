import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n, score, p;
    static List<Integer> list = new ArrayList<>();
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        score = scan.nextInt();
        p = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }
    }
    
    static void func() {
        int rank = 1;
        
        for (Integer i : list) {
            if (score < i) {
                rank++;
                
                continue;
            }
            
            break;
        }
        
        if (n == p && score <= list.get(p - 1)) {
            rank = -1;
        }
        
        sb.append(rank).append('\n');
        
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