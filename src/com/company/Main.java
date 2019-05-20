package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main {

    @Test
    public void binarySearch(){
        int[] nums = {0, 1, 2, 4, 5};
        int target = 4;
        assertEquals(3, BinarySearch.search(nums, target));
        nums = new int[]{-1, 0, 3, 5, 9, 12};
        target = 2;
        assertEquals(-1, BinarySearch.search(nums, target));
        target = 9;
        assertEquals(4, BinarySearch.search(nums, target));
        nums = new int[]{ -1, 2, 4, 6, 7, 8, 10, 12, 14, 16, 29, 31, 100 };
        target = 8;
        assertEquals(5, BinarySearch.search(nums, target));
        target = -1;
        assertEquals(0, BinarySearch.search(nums, target));
        target = 100;
        assertEquals(nums.length-1, BinarySearch.search(nums, target));
        nums = new int[]{-1, 2};
        target = -1;
        assertEquals(0, BinarySearch.search(nums, target));
        nums = new int[]{-1, 2};
        target = 2;
        assertEquals(1, BinarySearch.search(nums, target));
        nums = new int[]{2};
        target = 2;
        assertEquals(0, BinarySearch.search(nums, target));
        nums = new int[]{};
        target = 2;
        assertEquals(-1, BinarySearch.search(nums, target));
    }

    @Test
    public void squareRoot(){
//        assertEquals(0, BinarySearch.squareRoot(0));
//        assertEquals(1, BinarySearch.squareRoot(1));
//        assertEquals(1, BinarySearch.squareRoot(3));
//        assertEquals(2, BinarySearch.squareRoot(4));
//        assertEquals(2, BinarySearch.squareRoot(5));
//        assertEquals(2, BinarySearch.squareRoot(7));
//        assertEquals(2, BinarySearch.squareRoot(8));
//        assertEquals(3, BinarySearch.squareRoot(9));
//        assertEquals(3, BinarySearch.squareRoot(10));
        assertEquals(3, BinarySearch.squareRoot(11));
        assertEquals(3, BinarySearch.squareRoot(12));
        assertEquals(3, BinarySearch.squareRoot(13));
        assertEquals(3, BinarySearch.squareRoot(14));
        assertEquals(3, BinarySearch.squareRoot(15));
        assertEquals(4, BinarySearch.squareRoot(16));
        assertEquals(10, BinarySearch.squareRoot(101));
        assertEquals(3513, BinarySearch.squareRoot(12345678));
        assertEquals(46340, BinarySearch.squareRoot(2147395600));
        assertEquals(46339, BinarySearch.squareRoot(2147395599));
    }

    /*@Test
    public void binaryTreePreoder(){
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        int[] result = BinaryTree.preorderTraversal(root)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        assertArrayEquals(new int[] {1}, result);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        result = BinaryTree.preorderTraversal(root)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        assertArrayEquals(new int[] {1, 2, 3}, result);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        result = BinaryTree.preorderTraversal(root)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        assertArrayEquals(new int[] {1, 2, 4, 3 }, result);
    }*/
}
