import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 변수 정의
    static int n, s;
    static int[] arr;
    static List<Student> students = new ArrayList<>();
    
    // 변수 값 입력 받음
    static void input() {
        n = scan.nextInt();
        arr = new int[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            arr[i] = scan.nextInt();
        }
        
        s = scan.nextInt();
        
        for (int i = 0; i < s; i++) {
            students.add(new Student(scan.nextInt(), scan.nextInt()));
        }
    }
    
    static class Student {
        int gender;
        int number;
        
        public Student(int gender, int number) {
            this.gender = gender;
            this.number = number;
        }
    }
    
    private static void maleChange(int index) {
        for (int i = 1; i < arr.length; i++) {
            if (i % index == 0) {
                arr[i] = valueChange(arr[i]);
            }
        }
    }
    
    private static void femaleChange(int index) {
        int left = index - 1;
        int right = index + 1;
        
        while (left > 0 && right < arr.length) {
            if (arr[left] != arr[right]) {
                break;
            }
            
            left--;
            right++;
        }
        
        for (int i = left + 1; i < right; i++) {
            arr[i] = valueChange(arr[i]);
        }
    }
    
    private static int valueChange(int value) {
        return value == 0 ? 1 : 0;
    }
    
    static void func() {
        for (Student student : students) {
            int gender = student.gender;
            int number = student.number;
            
            if (gender == 1) {
                maleChange(number);
                
                continue;
            }
            
            femaleChange(number);
        }
        
        int count = 0;
        
        for (int i = 1; i < arr.length; i++) {
            count++;
            
            sb.append(arr[i]).append(" ");
            
            if (count >= 20 && count % 20 == 0) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
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