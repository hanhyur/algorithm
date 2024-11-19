import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int n;
    static Map<String, Integer> map = new HashMap<>();
    static Queue<String> que = new LinkedList<>();

    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            String initial = scan.next();
            int num = scan.nextInt();

            map.put(initial, num);
            que.add(initial);
        }
    }

    public static void func() {
        while (que.size() > 1) {
            String student = que.poll();
            int cnt = map.get(student);

            for (int i = 0; i < cnt - 1; i++) {
                que.add(que.poll());
            }

            que.poll();
        }

        System.out.println(que.poll());
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