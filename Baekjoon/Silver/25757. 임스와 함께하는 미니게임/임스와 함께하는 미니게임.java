import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n;
    static String game;
    static List<String> users = new ArrayList<>();
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        game = scan.next();
        
        for (int i = 0; i < n; i++) {
            users.add(scan.next());
        }
    }
    
    static void func() {
        List<String> distinctList = users.stream().distinct().collect(Collectors.toList());
        int playCount = 0;
        
        if (game.equals("Y")) {
            playCount = distinctList.size();
        }
        
        if (game.equals("F")) {
            playCount = distinctList.size() / 2;
        }
        
        if (game.equals("O")) {
            playCount = distinctList.size() / 3;
        }
        
        sb.append(playCount).append("\n");
        
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