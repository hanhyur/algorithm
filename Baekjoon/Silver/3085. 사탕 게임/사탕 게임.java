import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int n;
    static char[][] board;

    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scan.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }
    }

    // 최대 연속 부분 길이를 계산하는 함수
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

        return Math.max(maxLength, currentLength);
    }

    // 행에서 최대 연속 부분 길이를 계산하는 함수
    static int maxRowLength(int row) {
        return maxConsecutiveLength(board[row]);
    }

    // 열에서 최대 연속 부분 길이를 계산하는 함수
    static int maxColumnLength(int col) {
        char[] column = new char[n];
        for (int i = 0; i < n; i++) {
            column[i] = board[i][col];
        }
        return maxConsecutiveLength(column);
    }

    // 색을 교환하고 최대 사탕 개수를 다시 계산하는 함수
    static int swapAndCompute(int x1, int y1, int x2, int y2) {
        // Swap
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;

        // Compute max candies
        int maxCandies = 0;
        for (int i = 0; i < n; i++) {
            maxCandies = Math.max(maxCandies, maxRowLength(i));
            maxCandies = Math.max(maxCandies, maxColumnLength(i));
        }

        // Revert Swap
        board[x2][y2] = board[x1][y1];
        board[x1][y1] = temp;

        return maxCandies;
    }

    // 핵심 로직을 처리하는 함수
    static void func() {
        int maxCandies = 0;

        // Initial max candies
        for (int i = 0; i < n; i++) {
            maxCandies = Math.max(maxCandies, maxRowLength(i));
            maxCandies = Math.max(maxCandies, maxColumnLength(i));
        }

        // Try swapping adjacent cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    maxCandies = Math.max(maxCandies, swapAndCompute(i, j, i, j + 1));
                }
                if (board[j][i] != board[j + 1][i]) {
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
