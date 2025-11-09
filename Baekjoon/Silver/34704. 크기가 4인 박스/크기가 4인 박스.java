import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] count = new int[5];
        
        for (int i = 0; i < N; i++) {
            count[sc.nextInt()]++;
        }

        int box = 0;

        box += count[4];

        box += count[3];
        count[1] = Math.max(0, count[1] - count[3]);

        box += count[2] / 2;
        if (count[2] % 2 == 1) {
            box += 1;
            count[1] = Math.max(0, count[1] - 2);
        }

        if (count[1] > 0) {
            box += (count[1] + 3) / 4;
        }

        System.out.println(box);
    }
}