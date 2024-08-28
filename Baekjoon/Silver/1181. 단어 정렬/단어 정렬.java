import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n;
    static String[] arr;
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        arr = new String[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLine();
        }
    }
    
    static class WordSort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            
            return o1.compareTo(o2);
        }
    }
    
    static void func() {
        Arrays.sort(arr, new WordSort());
        
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i].compareTo(arr[i - 1]) != 0) {
                sb.append(arr[i]).append("\n");
            }
        }
        
        System.out.println(sb.toString());
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