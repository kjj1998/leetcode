public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { 
            this.val = val; this.next = next; 
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half = slow.next;
        slow.next = null;

        ListNode rev = reverse(half);

        while (head != null && rev != null) {
            if (head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode rev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = rev;
            rev = head;

            head = next;
        }

        return rev;
    }
}
