import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String docs = br.readLine();
        String word = br.readLine();
        
        int startIndex = 0;
        int answer = 0;
        
        while (true) {
            int findIndex = docs.indexOf(word, startIndex);
            
            if (findIndex < 0) {
                break;
            }
            
            answer++;
            
            startIndex = findIndex + word.length();
        }
        
        System.out.println(answer);
    }
    
}