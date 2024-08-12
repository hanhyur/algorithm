import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = Integer.parseInt(br.readLine());

        for (int t = 0; t < p; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] < arr[j]) {
                        answer++;
                    }
                }
            }

            bw.write(n + " " + answer + "\n");
        }

        br.close();
        bw.close();
    }
}
