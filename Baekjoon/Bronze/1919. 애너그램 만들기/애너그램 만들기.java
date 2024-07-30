import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String w1 = sc.next();
		String w2 = sc.next();
        int cnt = 0;

		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		for(int i=0; i<w1.length(); i++){
            arr1[w1.charAt(i)-'a']++;
        }
        for(int i=0; i<w2.length(); i++){
            arr2[w2.charAt(i)-'a']++;
        }
		for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]){
                cnt += Math.abs(arr1[i] - arr2[i]);
            }
        }	
		System.out.println(cnt);
	}
}