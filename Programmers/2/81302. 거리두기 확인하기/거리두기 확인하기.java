import java.util.*;

class Solution {

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = isValidPlace(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean isValidPlace(String[] place) {
        char[][] map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (map[x][y] == 'P') {
                    if (isViolation(map, x, y)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isViolation(char[][] map, int x, int y) {
        int[][] direct1 = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] direct2 = {{2,0},{-2,0},{0,2},{0,-2}};
        int[][] diagonal = {{1,1},{1,-1},{-1,1},{-1,-1}};

        for (int[] d : direct1) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (inRange(nx, ny) && map[nx][ny] == 'P') {
                return true;
            }
        }

        for (int[] d : direct2) {
            int nx = x + d[0];
            int ny = y + d[1];
            int mx = x + d[0] / 2;
            int my = y + d[1] / 2;

            if (inRange(nx, ny) && map[nx][ny] == 'P' && map[mx][my] != 'X') {
                return true;
            }
        }

        for (int[] d : diagonal) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (inRange(nx, ny) && map[nx][ny] == 'P') {
                if (map[x][ny] != 'X' || map[nx][y] != 'X') {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }
}
