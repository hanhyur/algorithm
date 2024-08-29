import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n;
    static Map<String, Integer> map = new TreeMap<>();
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
    }
    
    static void func() {
        for (int i = 0; i < n; i++) {
            String title = scan.next();
            
            if (!map.containsKey(title)) {
                map.put(title, 1);
            } else {
                map.put(title, map.get(title) + 1);
            }
        }
        
        String answer = "";
        int sell = 0;
        
        for (String title : map.keySet()) {
            if (map.get(title) > sell) {
                answer = title;
                sell = map.get(title);
            }
        }
        
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