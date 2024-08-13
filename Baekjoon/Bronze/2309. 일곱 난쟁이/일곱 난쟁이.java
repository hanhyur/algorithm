import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n, sum;
    static int[] arr;
    
    // 변수 값 입력 받음
    static void input() {
        arr = new int[9];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
            sum += arr[i];
        }
    }
    
    /**
     * 전체 값에서 2명의 키를 제거 했을 때 100이 되면 된다.
     */
    static void func() {
        outLoop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int seven = sum - (arr[i] + arr[j]);
                
                if (seven == 100) {
                    arr[i] = -1;
                    arr[j] = -1;
                    
                    break outLoop;
                }
            }
        }
        
        insertionSort(arr);
        
        for (int i = 2; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public static void insertionSort(int[] arr) {
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
