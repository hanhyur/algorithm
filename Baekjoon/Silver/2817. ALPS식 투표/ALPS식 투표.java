import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int x, n;
    static double[] arr;
    static ArrayList<Staff> list = new ArrayList<>();
    static ArrayList<Score> scores = new ArrayList<>();
    
    // 변수 값 입력 받음
    static void input() {
        x = scan.nextInt();
        n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            String name = scan.next();
            int votes = Integer.parseInt(scan.next());
            
            list.add(new Staff(name, votes));
        }
    }
    
    static class Staff {
        String staffName;
        int votes;
        int chip = 0;
        
        public Staff(String staffName, int votes) {
            this.staffName = staffName;
            this.votes = votes;
        }
    }
    
    static class Score {
        double num;
        String name;
        
        public Score(double num, String name) {
            this.num = num;
            this.name = name;
        }
        
        public double getNum() {
            return num;
        }
    }
    
    static void totalScore(int score, String name) {
        for (int i = 0; i < 14; i++) {
            double num = (double) (score / (i + 1));
            
            scores.add(new Score(num, name));
        }
    }
    
    static void func() {
        List<Staff> validCandidate = list.stream()
          .filter(staff -> staff.votes >= x * 0.05)
          .sorted(Comparator.comparing(o -> o.staffName))
          .collect(Collectors.toList());
        
        arr = new double[validCandidate.size() * 14];
        
        for (Staff staff : validCandidate) {
            totalScore(staff.votes, staff.staffName);
        }
        
        List<Score> result = scores.stream()
          .sorted(Comparator.comparing(Score::getNum).reversed())
          .collect(Collectors.toList());
        
        for (int i = 0; i < 14; i++) {
            for (Staff staff : validCandidate) {
                if (staff.staffName.equals(result.get(i).name)) {
                    staff.chip++;
                }
            }
        }
        
        for (Staff staff : validCandidate) {
            sb.append(staff.staffName).append(" ").append(staff.chip).append("\n");
        }
        
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
    }
    
}