import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수 정의
    static String input;
    static final char[] VOWELS = {'a', 'i', 'y', 'e', 'o', 'u'};
    static final char[] CONSONANTS = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};

    // 변수 값 입력 받음
    static void input() {
        while (scan.hasNextLine()) {
            input = scan.nextLine();

            sb.append(decodeROT13(input)).append('\n');
        }
    }

    static String decodeROT13(String input) {
        StringBuilder decoded = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (isVowel(ch)) {
                decoded.append(decodeChar(ch, VOWELS, 3));
            } else if (isConsonant(ch)) {
                decoded.append(decodeChar(ch, CONSONANTS, 10));
            } else {
                decoded.append(ch);
            }
        }

        return decoded.toString();
    }

    static boolean isVowel(char ch) {
        for (char vowel : VOWELS) {
            if (Character.toLowerCase(ch) == vowel) {
                return true;
            }
        }

        return false;
    }

    static boolean isConsonant(char ch) {
        for (char consonant : CONSONANTS) {
            if (Character.toLowerCase(ch) == consonant) {
                return true;
            }
        }

        return false;
    }

    static char decodeChar(char ch, char[] charset, int shift) {
        boolean isUpperCase = Character.isUpperCase(ch);
        ch = Character.toLowerCase(ch);

        int index = -1;
        for (int i = 0; i < charset.length; i++) {
            if (charset[i] == ch) {
                index = i;

                break;
            }
        }

        int newIndex = (index - shift + charset.length) % charset.length;
        char decodedChar = charset[newIndex];

        return isUpperCase ? Character.toUpperCase(decodedChar) : decodedChar;
    }

    public static void func() {
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
