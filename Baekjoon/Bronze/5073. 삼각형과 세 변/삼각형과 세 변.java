import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int a, b, c;
    static List<int[]> list = new ArrayList<>();
    
    // 변수 값 입력 받음
    static void input() {
        while (true) {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            int[] arr = new int[]{a, b, c};
            
            list.add(arr);
        }
    }
    
    static void func() {
        for (int[] arr : list) {
            Arrays.sort(arr);
            
            if (arr[0] + arr[1] <= arr[2]) {
                sb.append("Invalid").append("\n");
                continue;
            }
            
            // 중복 제거를 사용한 길이 비교
            int[] distinctArr = Arrays.stream(arr).distinct().toArray();
            
            if (distinctArr.length == 1) {
                sb.append("Equilateral").append("\n");
                continue;
            }
            
            if (distinctArr.length == 2) {
                sb.append("Isosceles").append("\n");
                continue;
            }
            
            if (distinctArr.length == 3) {
                sb.append("Scalene").append("\n");
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