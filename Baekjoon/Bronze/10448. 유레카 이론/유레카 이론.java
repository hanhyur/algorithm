import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n, t, answer;
    static int[] arr;
    static List<Integer> triangularNumbers = new ArrayList<>();
    
    // 변수 값 입력 받음
    static void input() {
        t = scan.nextInt();
        arr = new int[t];
        int maxK = 0;
        
        for (int i = 0; i < t; i++) {
            arr[i] = scan.nextInt();
            
            if (arr[i] > maxK) {
                maxK = arr[i];
            }
        }
        
        generateTriangularNumbers(maxK);
    }
    
    // 삼각수를 생성하는 메소드
    static void generateTriangularNumbers(int limit) {
        triangularNumbers.clear();
        
        n = 1;
        
        while (true) {
            int Tn = n * (n + 1) / 2;
            
            if (Tn > limit) break;
            
            triangularNumbers.add(Tn);
            
            n++;
        }
    }
    
    // 삼각수의 합으로 표현 가능한지 확인하는 메소드
    static boolean isEureka(int K) {
        int size = triangularNumbers.size();
        
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                for (int k = j; k < size; k++) {
                    if (triangularNumbers.get(i) + triangularNumbers.get(j) + triangularNumbers.get(k) == K) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * 삼각수의 합으로 표현이 가능하면 1, 아니면 0을 출력한다.
     */
    static void func() {
        for (int K : arr) {
            if (isEureka(K)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
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
    
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int current = arr[i];
                    
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    
                    arr[j] = current;
                    
                    break;
                }
            }
        }
    }
    
}
