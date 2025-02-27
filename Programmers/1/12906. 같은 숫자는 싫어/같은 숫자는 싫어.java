import java.util.*;

public class Solution {
    public Stack<Integer> solution(int[] arr) {
//         ArrayList<Integer> tempList = new ArrayList<Integer>();
        
//         int preNum = 10;
//         for(int num : arr) {
//             if(preNum != num)
//                 tempList.add(num);
//             preNum = num;
//         }
        
//         int[] answer = new int[tempList.size()];
        
//         for(int i = 0; i < answer.length; i++) {
//             answer[i] = tempList.get(i).intValue();
//         }
        
//         return answer;
        Stack<Integer> answer = new Stack<>();
        
        for (int num : arr) {
            if (answer.size() == 0 || answer.peek() != num) {
                answer.push(num);
            }
        }
        
        return answer;
    }
}