import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int n;

    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
    }

    static int getDigitSum(int num, int base) {
        int sum = 0;

        while (num > 0) {
            sum += num % base;
            num /= base;
        }

        return sum;
    }

    public static void func() {
        int maxSum = 0;
        int bestBase = 2;

        for (int i = 2; i <= n; i++) {
            int digitSum = getDigitSum(n, i);

            if (digitSum > maxSum) {
                maxSum = digitSum;
                bestBase = i;
            }
        }

        sb.append(maxSum).append(" ").append(bestBase).append("\n");

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

        boolean hasNextLine() {
            try {
                return br.ready();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }
    }

}