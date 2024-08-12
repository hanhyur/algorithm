import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 첫 번째 줄에서 N 읽기
        int N = Integer.parseInt(br.readLine());
        
        // 수의 범위에 따른 카운트 배열 초기화 (0부터 10,000까지)
        final int MAX_VALUE = 10000;
        int[] count = new int[MAX_VALUE + 1];
        
        // N개의 수를 읽어서 카운트 배열에 저장
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number]++;
        }
        
        // 카운트 배열을 이용하여 결과 출력
        for (int i = 0; i <= MAX_VALUE; i++) {
            while (count[i] > 0) {
                bw.write(i + "\n");
                count[i]--;
            }
        }
        
        // 자원 정리
        br.close();
        bw.close();
    }
    
}
