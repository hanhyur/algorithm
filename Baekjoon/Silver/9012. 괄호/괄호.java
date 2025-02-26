import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            boolean isVPS = true;
            String str = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            
            for(int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                
                if(tmp == '(') {
                    stack.push(tmp);
                } else if(tmp == ')') {
                    if(!stack.isEmpty())
                        stack.pop();
                    else {
                        isVPS = false;
                        break;
                    }
                }
            }
            
            if(!stack.isEmpty())
                isVPS = false;
            
            if(isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}