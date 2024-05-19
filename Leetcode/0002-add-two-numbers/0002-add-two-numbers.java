/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 더미 노드 생성
        ListNode pointer = dummy; // 포인터
        int temp = 0; // 초과값 저장용
        
        while (l1 != null || l2 != null || temp == 1) {
            int sum = 0; // 노드 합
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += temp;
            temp = sum / 10; // sum이 10 이상이면 넘치는 값을 저장
            
            ListNode node = new ListNode(sum % 10); // 나머지 값을 가지는 노드 생성
            pointer.next = node; // 포인터의 다음 위치에 저장
            pointer = pointer.next; // 다음으로 포인터 이동
        }
        
        return dummy.next; // 초기화를 위해 넣은 값을 제외하고 출력
    }
}