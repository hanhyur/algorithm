import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int n;
    static int[] arr;

    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scan.next());
        }
    }

    static void func() {
        int[] copy = arr.clone();

        Arrays.sort(copy);

        Map<Integer, Integer> map = new HashMap<>();

        int order = 0;

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], order);
                order++;
            }
        }

        for (int j : arr) {
            sb.append(map.get(j)).append(" ");
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