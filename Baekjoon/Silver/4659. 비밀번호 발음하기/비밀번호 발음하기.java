import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static String str;
    static List<String> list = new ArrayList<>();
    
    // 변수 값 입력 받음
    static void input() {
        while (true) {
            str = scan.nextLine();
            
            if (str.equals("end")) {
                break;
            }
            
            list.add(str);
        }
    }
    
    private static boolean isContainsVowel(String s) {
        return s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u");
    }
    
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    private static boolean isNotContinuous(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            boolean c1 = isVowel(s.charAt(i));
            boolean c2 = isVowel(s.charAt(i + 1));
            boolean c3 = isVowel(s.charAt(i + 2));
            
            if ((c1 && c2 && c3) || (!c1 && !c2 && !c3)) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean isSpecificVowel(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            
            if (c1 == c2) {
                return c1 == 'e' || c1 == 'o';
            }
        }
        
        return true;
    }
    
    static void func() {
        for (String s : list) {
            boolean isAcceptable = true;
            
            if (s.length() == 1 && isVowel(s.charAt(0))) {
                sb.append("<").append(s).append("> is acceptable.").append("\n");
                continue;
            }
            
            if (!isContainsVowel(s) || !isNotContinuous(s) || !isSpecificVowel(s)) {
                isAcceptable = false;
            }
            
            sb.append("<").append(s).append("> is ").append(isAcceptable ? "acceptable." : "not acceptable.").append("\n");
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