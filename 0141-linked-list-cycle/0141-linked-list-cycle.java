/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode ahead = head;
        ListNode temp = head;

        while(ahead!=null && ahead.next != null){
            temp = temp.next;
            ahead = ahead.next.next;
            if(ahead==temp) return true;
        }

        return false;
        
    }
}