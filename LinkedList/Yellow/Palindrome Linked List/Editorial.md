# Palindrome Linked List

## Problem

Given the ```head``` of a singly linked list, return ```true``` if it is a palindrome or ```false``` otherwise.

## Example

![Image](./palindrome.jpg)

```java
Input: head = [1,2,2,1]
Output: true
```

## Solution

To solve this problem, we need to make use of the property of a palindrome which is having two identical halves that mirror each other perfectly.

Using a slow and fast pointer approach, we identify the first node of the second half of the linked list which is the node right after the middle node of an odd-numbered linked list or in an even-numbered linked list, it is the node right after the last node in the first half of the linked list.

From the first node of the second half, we reverse the nodes. Afterwards, we do a node by node comparison between the first half and the reversed second half to check the values

```java
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
```

## Complexity

Time: O(n) </br>
Space: O(1)
