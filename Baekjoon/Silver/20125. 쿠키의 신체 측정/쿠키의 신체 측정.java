import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n, head;
    static String[] arr;
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        arr = new String[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            arr[i] = scan.nextLine();
        }
    }
    
    private static void isHead(String s) {
        if (s.contains("*")) {
            head = s.indexOf("*");
        }
    }
    
    private static int measureLeftArm(String s) {
        return head - s.indexOf("*");
    }
    
    private static int measureRightArm(String s) {
        return s.lastIndexOf("*") - head;
    }
    
    static void func() {
        int heart = 1;
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        
        for (int i = 1; i < arr.length; i++) {
            String s = arr[i];
            
            if (head == 0) {
                isHead(s);
                heart++;
                
                continue;
            }
            
            if (leftArm == 0 && rightArm == 0) {
                leftArm = measureLeftArm(s);
                rightArm = measureRightArm(s);
                
                continue;
            }
            
            if (s.charAt(head) == '*') {
                waist++;
                
                continue;
            }
            
            if (s.charAt(head - 1) == '*') {
                leftLeg++;
            }
            
            if (s.charAt(head + 1) == '*') {
                rightLeg++;
            }
        }
        
        sb.append(heart).append(" ").append(head + 1).append("\n");
        sb.append(leftArm).append(" ").append(rightArm).append(" ");
        sb.append(waist).append(" ");
        sb.append(leftLeg).append(" ").append(rightLeg);
        
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