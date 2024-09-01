import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int n, c;
    static List<Integer> list = new ArrayList<>();

    // 변수 값 입력 받음
    static void input() {
        n = Integer.parseInt(scan.next());
        c = Integer.parseInt(scan.next());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(scan.next()));
        }
    }

    static void sortByCount(Map<Integer, Integer> map, List<Integer> original) {
        list.sort((o1, o2) -> {
            if (Objects.equals(map.get(o1), map.get(o2))) {
                return original.indexOf(o1) - original.indexOf(o2);
            }

            return Integer.compare(map.get(o2), map.get(o1));
        });
    }

    static void func() {
        List<Integer> original = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            original.add(list.get(i));
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }

        sortByCount(map, original);

        for (int i = 0; i < n; i++) {
            sb.append(list.get(i)).append(" ");
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