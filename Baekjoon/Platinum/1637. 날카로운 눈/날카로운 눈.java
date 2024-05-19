
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int N;
    static int[][] info;

    // 변수 값 입력 받음
    static void input() {
        N = scan.nextInt();
        info = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                info[i][j] = scan.nextInt();
            }
        }
    }

    // x 이하의 숫자가 몇 개 있는가
    static int count(int A, int B, int C, int x) {
        if (x < A) {
            return 0; // A가 가장 작은 값이므로 A보다 작으면 숫자가 없다
        }

        if (x > C) {
            return (C - A) / B + 1; // A와 C 사이의 B의 배수들의 갯수와 A의 갯수
        }

        return (x - A) / B + 1; // A와 x 사이의 B의 배수들의 갯수와 A의 갯수
    }

    // 정수 x의 갯수가 홀수개인가
    static boolean isValid(int x) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += count(info[i][0], info[i][2], info[i][1], x);
        }

        return sum % 2 == 1;
    }

    /**
     * 정수 뭉치에서 홀수 개 존재하는 정수와 그 정수의 갯수를 출력한다.
     * 짝수끼리 더할 때는 홀수가 나올 수 없다.
     * -> 즉, 누적 합이 짝수라면 홀수가 오른쪽에 있다는 뜻이다.
     * -> 따라서 홀짝을 검증한 후 결과에 따라 홀수면 lower, 짝수면 upper
     */
    static void func() {
        long left = 1, right = Integer.MAX_VALUE, answer = 0, cnt = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isValid((int) mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 숫자 갯수 확인
        if (answer == 0) {
            System.out.println("NOTHING");
        } else {
            for (int i = 0; i < N; i++) {
                if (info[i][0] <= answer && answer <= info[i][1]
                        && (answer - info[i][0]) % info[i][2] == 0) {
                    cnt++;
                }
            }

            System.out.println(answer + " " + cnt);
        }
    }

    public static void main(String[] args) {
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
