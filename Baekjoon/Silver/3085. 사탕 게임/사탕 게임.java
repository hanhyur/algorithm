import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n;
    static char[][] arr;
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        arr = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String str = scan.next();
            
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
    }
    
    // 최대 연속 부분의 길이를 계산
    static int maxConsecutiveLength(char[] line) {
        int maxLength = 1;
        int currentLength = 1;
        
        for (int i = 1; i < line.length; i++) {
            if (line[i] == line[i - 1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        
        maxLength = Math.max(maxLength, currentLength);
        
        return maxLength;
    }
    
    // 행과 열에서 최대 사탕 개수를 계산
    static int getMaxCandies() {
        int maxCandies = 0;
        
        // Check rows
        for (int i = 0; i < n; i++) {
            maxCandies = Math.max(maxCandies, maxConsecutiveLength(arr[i]));
        }
        
        // Check columns
        for (int i = 0; i < n; i++) {
            char[] column = new char[n];
            
            for (int j = 0; j < n; j++) {
                column[j] = arr[j][i];
            }
            
            maxCandies = Math.max(maxCandies, maxConsecutiveLength(column));
        }
        
        return maxCandies;
    }
    
    // 색을 교환하고 최대 사탕 개수를 다시 계산
    static int swapAndCompute(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
        
        int result = getMaxCandies();
        
        arr[x2][y2] = arr[x1][y1];
        arr[x1][y1] = temp;
        
        return result;
    }
    
    /**
     * 1. 주어진 행열에서 최대 길이를 구한다.
     * 2. 인접한 값과 변경했을 때 최대 길이와 비교한다.
     */
    static void func() {
        int maxCandies = getMaxCandies();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    maxCandies = Math.max(maxCandies, swapAndCompute(i, j, i, j + 1));
                }
                if (arr[j][i] != arr[j + 1][i]) {
                    maxCandies = Math.max(maxCandies, swapAndCompute(j, i, j + 1, i));
                }
            }
        }
        
        sb.append(maxCandies).append('\n');
        
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
