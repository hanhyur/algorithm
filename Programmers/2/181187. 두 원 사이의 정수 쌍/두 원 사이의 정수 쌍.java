import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long A = 0;

        long r1Sq = 1L * r1 * r1;
        long r2Sq = 1L * r2 * r2;

        for (int x = 1; x <= r2; x++) {
            long xSq = 1L * x * x;

            long outerVal = r2Sq - xSq;
            if (outerVal < 0)
                continue;
            long outerY = (long) Math.sqrt(outerVal);

            long innerMinY = 1;
            long innerVal = r1Sq - xSq;

            if (innerVal > 0) {
                long y = (long) Math.sqrt(innerVal);
                if (y * y < innerVal)
                    y++;
                innerMinY = Math.max(innerMinY, y);
            }

            if (outerY >= innerMinY) {
                A += (outerY - innerMinY + 1);
            }
        }

        long axis = 4L * (r2 - r1 + 1);

        return 4L * A + axis;
    }
}