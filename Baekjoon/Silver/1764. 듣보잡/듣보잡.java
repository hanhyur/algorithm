import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static int N, M; // N : 들은 적 없는 사람 수, M : 본 적 없는 사람 수
    static String[] names, answer; // ns : 들은 적 없는 명단, nh : 본 적 없는 명단

    // 변수 값 입력 받음
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        names = new String[N];
        answer = new String[N];

        for (int i = 0; i < N; i++) {
            names[i] = scan.next();
        }

        Arrays.sort(names);
    }

    /**
     * arr : 탐색할 배열
     * left : arr의 첫 번째 인덱스
     * right : arr의 마지막 인덱스
     * str : arr에서 찾을 문자열
     */
    static boolean binarySearch(String[] arr, int left, int right, String str) {
        while (left <= right) {
            int mid = (left + right) / 2;

            // 같은 문자열이 있으면
            if (arr[mid].equals(str)) {
                return true;
            }

            // 같은 문자열이 없을 때 -> 순서비교
            if (arr[mid].compareTo(str) < 0) {
                left = mid + 1; // str보다 앞에 있는 단어
            } else {
                right = mid - 1; // str보다 뒤에 있는 단어
            }
        }

        return false;
    }

    /**
     * 듣도 못한 사람과 보도 못한 사람 중에서 둘 다 해당하는 사람을 찾아서 출력한다.
     * 이름의 중복은 없다.
     */
    static void func() {
        int ansCnt = 0;

        for (int i = 0; i < M; i++) {
            String str = scan.nextLine();

            // 배열에 같은 이름이 있으면
            if (binarySearch(names, 0, N - 1, str)) {
                answer[ansCnt] = str; // 중복된 이름 등록
                ansCnt++; // 갯수 증가
            }
        }

        // 사전순으로 출력해야 하므로 정렬
        // 단, ansCnt보다 큰 인덱스들은 null이므로 범위를 지정해준다.
        Arrays.sort(answer, 0, ansCnt);

        sb.append(ansCnt).append('\n');

        for (int i = 0; i < ansCnt; i++) {
            sb.append(answer[i]).append('\n');
        }

        System.out.println(sb);
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
