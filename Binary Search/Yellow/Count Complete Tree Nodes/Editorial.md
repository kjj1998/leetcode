# Count Complete Tree Nodes

## Problem

Given the ```root``` of a **complete** binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between ```1``` and ```2h``` nodes inclusive at the last level ```h```.

Design an algorithm that runs in less than ```O(n)``` time complexity.

## Example

![Image](./complete.jpg)

```java
Input: root = [1,2,3,4,5,6]
Output: 6
```

## Solution

The naive way would be to recursive go down each sub-tree and count the number of the nodes in them. So we recursively count the number of nodes in the ```left``` and ```right``` subtrees and sum them up and then add 1 to the sum. This will give us O(n) time.

However, we can optimize further by using the property of a complete binary tree. where the number of nodes in a fully filled complete binary tree is 2^h^-1 where h is the height of the tree.

So we start by recursively going down the left side of the left subtree and the right side of the right subtree until the right side is not null. If the left side is null, we have a fully filled complete binary tree and can easily compute the number of nodes. If not, we need to recursive go down both the left and right side and look for fully filled complete binary tree.

```java
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root, right = root;

        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }

        if (left == null) {
            return (1 << height) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
```

## Complexity

Time: **O((log n)^2^)**, we used O(log n) to calculate the height of the current subtree we are at and another O(log n) to recursively go down both left and right subtrees

Space: O(1)
