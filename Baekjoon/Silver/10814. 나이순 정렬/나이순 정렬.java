import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n;
    static Member[] arr;
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        arr = new Member[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = new Member(Integer.parseInt(scan.next()), scan.next());
        }
    }
    
    static class Member implements Comparable<Member> {
        int age;
        String name;
        
        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
        
        @Override
        public int compareTo(Member o) {
            return this.age - o.age;
        }
    }
    
    static void func() {
        Arrays.sort(arr, Member::compareTo);
        
        for (Member member : arr) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
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