public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = count(headA);
        int bLength = count(headB);
        
        if (aLength > bLength) {
            int difference = aLength - bLength;
            
            while (difference > 0) {
                headA = headA.next;
                difference--;
            }
        } else if (bLength > aLength) {
            int difference = bLength - aLength;
            
            while (difference > 0) {
                headB = headB.next;
                difference--;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    public int count(ListNode head) {
        int length = 0;
        
        while (head != null) {
            head = head.next;
            length++;
        }
        
        return length;
    }        
}
