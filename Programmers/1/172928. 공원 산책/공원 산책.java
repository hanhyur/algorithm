class Solution {
    public int[] solution(String[] park, String[] routes) {
        int y = 0, x = 0;
        
        for (int i = 0; i < park.length; i++) {
            if(park[i].contains("S")) {
                y = i;
                x = park[i].indexOf('S');
            }
        }
            
        int[][] d={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String dir="NSWE";
        
        for (String r : routes) {
            String[] p = r.split(" ");
            int dy = d[dir.indexOf(p[0])][0];
            int dx = d[dir.indexOf(p[0])][1];
            
            int n = Integer.parseInt(p[1]);
            int ny = y, nx = x; 
            
            boolean ok=true;
            
            for (int i = 0; i < n; i++) {
                ny += dy;
                nx += dx;
                
                if (ny < 0 || nx < 0 || ny >= park.length || nx >= park[0].length() ||
                    park[ny].charAt(nx) == 'X') {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                y = ny;
                x = nx;
            }
        }
        
        return new int[] {y, x};
    }
}