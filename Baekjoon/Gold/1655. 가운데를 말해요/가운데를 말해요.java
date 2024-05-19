import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());        
        int val = 0;

        for(int i = 0; i < n; i++) {
            val = Integer.parseInt(br.readLine());

            if(max.size() <= min.size()) {
                max.offer(val);
            } else {
                min.offer(val);
            }

            if(!min.isEmpty() && max.peek() > min.peek()) {
                max.offer(min.poll());
                min.offer(max.poll());
            }

            bw.write(max.peek() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}