import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int zero = 0;
        int winning = 0;
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            }
            
            if (IntStream.of(win_nums).anyMatch(n -> n == lotto)) {
                winning++;
            }
        }
        
        return new int[] {Math.min(6, 6 - (winning + zero) + 1), Math.min(6, 6 - winning + 1)};
    }
}