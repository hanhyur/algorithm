import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n, row, col;
    static String command;
    static char[][] map;
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        command = scan.nextLine();
    }
    
    private static boolean isValid(int row, int col, char c) {
        int originRow = row;
        int originCol = col;
        
        if (c == 'U') {
            row -= 1;
        }
        
        if (c == 'D') {
            row += 1;
        }
        
        if (c == 'L') {
            col -= 1;
        }
        
        if (c == 'R') {
            col += 1;
        }
        
        boolean result = row >= 0 && row < n && col >= 0 && col < n;
        
        row = originRow;
        col = originCol;
        
        return result;
    }
    
    private static void move(char direction) {
        if (direction == 'U') {
            Up(row, col);
            row -= 1;
        } else if (direction == 'D') {
            Down(row, col);
            row += 1;
        } else if (direction == 'L') {
            Left(row, col);
            col -= 1;
        } else if (direction == 'R') {
            Right(row, col);
            col += 1;
        }
    }
    
    private static void Up(int row, int col) {
        if (map[row][col] == '.') {
            map[row][col] = (char) 124;
        } else if (map[row][col] == (char) 45) {
            map[row][col] = (char) 43;
        }
        
        if (map[row - 1][col] == '.') {
            map[row - 1][col] = (char) 124;
        } else if (map[row - 1][col] == (char) 45) {
            map[row - 1][col] = (char) 43;
        }
    }
    
    private static void Down(int row, int col) {
        if (map[row][col] == '.') {
            map[row][col] = (char) 124;
        } else if (map[row][col] == (char) 45) {
            map[row][col] = (char) 43;
        }
        
        if (map[row + 1][col] == '.') {
            map[row + 1][col] = (char) 124;
        } else if (map[row + 1][col] == (char) 45) {
            map[row + 1][col] = (char) 43;
        }
    }
    
    private static void Left(int row, int col) {
        if (map[row][col] == '.') {
            map[row][col] = (char) 45;
        } else if (map[row][col] == (char) 124) {
            map[row][col] = (char) 43;
        }
        
        if (map[row][col - 1] == '.') {
            map[row][col - 1] = (char) 45;
        } else if (map[row][col - 1] == (char) 124) {
            map[row][col - 1] = (char) 43;
        }
    }
    
    private static void Right(int row, int col) {
        if (map[row][col] == '.') {
            map[row][col] = (char) 45;
        } else if (map[row][col] == (char) 124) {
            map[row][col] = (char) 43;
        }
        
        if (map[row][col + 1] == '.') {
            map[row][col + 1] = (char) 45;
        } else if (map[row][col + 1] == (char) 124) {
            map[row][col + 1] = (char) 43;
        }
    }
    
    static void func() {
        // 목판 만들기
        map = new char[n][n];
        for (char[] chars : map) {
            Arrays.fill(chars, '.');
        }
        
        // 시작 위치
        row = 0;
        col = 0;
        
        if (!command.isEmpty()) {
            for (int i = 0; i < command.length(); i++) {
                char direction = command.charAt(i);
                
                // 유효한 이동인지 체크
                if (!isValid(row, col, direction)) {
                    continue;
                }
                
                move(direction);
            }
        }
        
        for (char[] chars : map) {
            for (int j = 0; j < map.length; j++) {
                sb.append(chars[j]);
            }
            
            sb.append("\n");
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
