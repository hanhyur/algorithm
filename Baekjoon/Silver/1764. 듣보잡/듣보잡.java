import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<String> list = new ArrayList<>();
    String[] arr = new String[n + m];

    for(int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }
    
    for(int i = n; i < m + n; i++) {
      arr[i] = br.readLine();
    }
    
    Arrays.sort(arr);
    
    for(int i = 0; i < m + n - 1; i++) {
      if(arr[i].equals(arr[i + 1])) {
        list.add(arr[i]);
      }
    }
    
    System.out.println(list.size());

    for(String s : list)
      System.out.println(s);
  }
  
}
