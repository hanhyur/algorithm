import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n, k;
    static String[] arr;
    
    // 변수 값 입력 받음
    static void input() {
        n = Integer.parseInt(scan.next());
        k = Integer.parseInt(scan.next());
        
        arr = new String[k];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextLine();
        }
    }
    
    private static boolean isValid(String[] wheel, int rotate, String alphabet) {
        if (!wheel[rotate].equals(alphabet)) {
            sb.append("!").append('\n');
            return true;
        }
        
        return false;
    }
    
    private static void printWheel(String[] wheel, int rotate) {
        for (int i = 0; i < n; i++) {
            if (wheel[rotate] != null) {
                sb.append(wheel[rotate]);
            }
            
            rotate--;
            
            if (rotate < 0) {
                rotate = n - 1;
            }
        }
        
        sb.append('\n');
    }
    
    static void func() {
        String[] wheel = new String[n];
        Arrays.fill(wheel, "?");
        
        int rotate = 0;
        
        for (String s : arr) {
            String[] split = s.split(" ");
            
            rotate += Integer.parseInt(split[0]);
            if (rotate >= n) {
                rotate %= n;
            }
            String alphabet = split[1];
            
            if (wheel[rotate].equals("?")) {
                if (Arrays.asList(wheel).contains(alphabet)) {
                    sb.append("!").append('\n');
                    break;
                }
                
                wheel[rotate] = alphabet;
            }
            
            if (isValid(wheel, rotate, alphabet)) {
                break;
            }
        }
        
        if (sb.toString().isEmpty()) {
            printWheel(wheel, rotate);
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
