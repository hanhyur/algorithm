import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int n, x;
    static int[] a;

    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        x = scan.nextInt();
    }

    /**
     * @param arr : 탐색할 배열
     * @param left : arr의 첫 번째 인덱스
     * @param right : arr의 마지막 인덱스
     * @param num : 찾아야 하는 값
     */
    static boolean binarySearch(int[] arr, int left, int right, int num) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == num) {
                return true;
            }

            if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /**
     * a[i] + a[j] = x인 수열의 갯수를 찾아서 출력한다.
     * a[j] = x - a[i]를 이용해서 이진 탐색을 실행한다.
     */
    static void func() {
        Arrays.sort(a);

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (binarySearch(a, i + 1, n - 1, x - a[i])) {
                cnt++;
            }
        }

        System.out.println(cnt);
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
