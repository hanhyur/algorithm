import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n, t;
    static Long[] arr;
    
    // 변수 값 입력 받음
    static void input() {
        t = scan.nextInt();
        arr = new Long[t];
        
        for (int i = 0; i < t; i++) {
            arr[i] = scan.nextLong();
        }
    }
    
    public static List<Long> convertBase(Long num, int b) {
        List<Long> res = new ArrayList<>();
        
        while (num > 0) {
            res.add(num % b);
            
            num /= b;
        }
        
        return res;
    }
    
    // 회문인지 아닌지 판별
    public static boolean isPalindrome(List<Long> list) {
        int left = 0;
        int right = list.size() - 1;
        
        while (left < right) {
            if (!Objects.equals(list.get(left), list.get(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * 회문 인지 아닌지 판별하여 출력한다.
     * 단, B 진법으로 변경했을 때도 고려한다.
     */
    static void func() {
        outLoop:
        for (Long aLong : arr) {
            for (int base = 2; base < 65; base++) {
                List<Long> list = convertBase(aLong, base);
                
                if (isPalindrome(list)) {
                    sb.append("1").append("\n");
                    continue outLoop;
                }
            }
            
            sb.append("0").append("\n");
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
