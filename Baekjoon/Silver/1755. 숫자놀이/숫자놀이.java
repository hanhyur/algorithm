import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int m, n;
    static String[] numToWord = {"zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten"};

    // 변수 값 입력 받음
    static void input() {
        m = scan.nextInt();
        n = scan.nextInt();
    }

    static String toEnglish(int number) {
        StringBuilder word = new StringBuilder();

        while (number > 0) {
            word.insert(0, numToWord[number % 10] + " ");

            number /= 10;
        }

        return word.toString().trim();
    }

    public static void func() {
        Map<String, Integer> map = new TreeMap<>();

        for (int i = m; i <= n; i++) {
            String word = toEnglish(i);

            map.put(word, i);
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getValue()).append(" ");

            count++;

            if (count % 10 == 0) {
                sb.append("\n");
            }
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