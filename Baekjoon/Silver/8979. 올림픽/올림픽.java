import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int n, k;
    static List<Country> list = new ArrayList<>();

    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(new Country(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
        }
    }

    static class Country implements Comparator<Country> {
        int name;
        int gold;
        int silver;
        int bronze;
        int rate;

        public Country(int name, int gold, int silver, int bronze) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compare(Country o1, Country o2) {
            if (o1.gold == o2.gold) {
                if (o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                }

                return o2.silver - o1.silver;
            }

            return o2.gold - o1.gold;
        }
    }

    static void func() {
        list.sort(new Country(0, 0, 0, 0));

        list.get(0).rate = 1;

        int target = 0;

        for (int i = 1; i < list.size(); i++) {
            Country before = list.get(i - 1);
            Country now = list.get(i);

            if (now.name == k) {
                target = i;
            }

            if (now.gold == before.gold && now.silver == before.silver && now.bronze == before.bronze) {
                now.rate = before.rate;

                continue;
            }

            now.rate = i + 1;
        }

        sb.append(list.get(target).rate);

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

}