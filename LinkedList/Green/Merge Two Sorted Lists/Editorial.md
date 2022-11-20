# Merge Two Sorted Lists

## Problem

You are given the heads of two sorted linked lists ```list1``` and ```list2```.

Merge the two lists in a one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return *the head of the merged linked list.*

## Example

![Image](./merge_ex1.jpg)

```java
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

## Solution

We can use the same idea that is used in merge sort to solve this question.

As we iterate down both linked lists, we compare the values between both nodes and progress the pointer of the linked list whose node is the smaller of the two. We then the add the node with the smaller value to a linked list that will contain nodes from both linked lists in a sorted manner.

This goes on until one of the linked list has been completely iterated through where we can append the remaining nodes on the linked list to the linked list containing nodes from both lists.

Algorithm:

- Create a ```dummyHead``` node that will point to the head of the sorted linked list
- Create a ```cur``` node that points to the dummy head node
- While ```list1``` and ```list2``` are both not null:
  - Compare the nodes pointed to by ```list1``` and ```list2```
  - Point ```cur.next``` to the smaller node of ```list1``` and ```list2```
  - Progress the smaller node of the two
  - Also progress ```cur``` node
- If ```list1``` or ```list2``` have remaining nodes, append it to ```cur.next```
- Return ```dummyHead.next```

## Complexity

Time: O(n) </br>
Space: O(1)
