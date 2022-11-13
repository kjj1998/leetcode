# Intersection of Two Linked Lists

## Problem

Given the heads of two singly linked-lists ```headA``` and ```headB```, return *the node at which the two lists intersect*. If the two linked lists have no intersection at all, return ```null```.

**Note** that the linked lists must **retain their original structure** after the function returns.

## Example

![Image](./example.png)

```java
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
```

## Solution

Since both linked lists can be of varying lengths, we can find out the difference between the two of them and shift the head of the longer linked list forward by the difference.

This ensures that both linked lists will have an equal number of nodes until the node on which they intersect if there indeed is an intersection.

We then move nodes forward on both linked lists until we reach the intersection node. If there is no intersection node, we return null.

```java
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
```

## Complexity

Time: O(n) </br>
Space: O(1)
