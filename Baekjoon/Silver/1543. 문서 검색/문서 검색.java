import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String docs = br.readLine();
        String word = br.readLine();
        
        String replaced = docs.replace(word, "");
        
        int answer = (docs.length() - replaced.length()) / word.length();
        
        System.out.println(answer);
    }
    
}