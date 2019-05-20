package com.company;

import org.junit.Assert;
import org.junit.Test;

public class Main {

    @Test
    public void binarySearch(){
        int[] nums = {0, 1, 2, 4, 5};
        int target = 4;
        Assert.assertEquals(3, BinarySearch.search(nums, target));
        nums = new int[]{-1, 0, 3, 5, 9, 12};
        target = 2;
        Assert.assertEquals(-1, BinarySearch.search(nums, target));
        target = 9;
        Assert.assertEquals(4, BinarySearch.search(nums, target));
        nums = new int[]{ -1, 2, 4, 6, 7, 8, 10, 12, 14, 16, 29, 31, 100 };
        target = 8;
        Assert.assertEquals(5, BinarySearch.search(nums, target));
        target = -1;
        Assert.assertEquals(0, BinarySearch.search(nums, target));
        target = 100;
        Assert.assertEquals(nums.length-1, BinarySearch.search(nums, target));
        nums = new int[]{-1, 2};
        target = -1;
        Assert.assertEquals(0, BinarySearch.search(nums, target));
        nums = new int[]{-1, 2};
        target = 2;
        Assert.assertEquals(1, BinarySearch.search(nums, target));
        nums = new int[]{2};
        target = 2;
        Assert.assertEquals(0, BinarySearch.search(nums, target));
        nums = new int[]{};
        target = 2;
        Assert.assertEquals(-1, BinarySearch.search(nums, target));
    }

    @Test
    public void squareRoot(){
//        Assert.assertEquals(0, BinarySearch.squareRoot(0));
//        Assert.assertEquals(1, BinarySearch.squareRoot(1));
//        Assert.assertEquals(1, BinarySearch.squareRoot(3));
//        Assert.assertEquals(2, BinarySearch.squareRoot(4));
//        Assert.assertEquals(2, BinarySearch.squareRoot(5));
//        Assert.assertEquals(2, BinarySearch.squareRoot(7));
//        Assert.assertEquals(2, BinarySearch.squareRoot(8));
//        Assert.assertEquals(3, BinarySearch.squareRoot(9));
//        Assert.assertEquals(3, BinarySearch.squareRoot(10));
        Assert.assertEquals(3, BinarySearch.squareRoot(11));
        Assert.assertEquals(3, BinarySearch.squareRoot(12));
        Assert.assertEquals(3, BinarySearch.squareRoot(13));
        Assert.assertEquals(3, BinarySearch.squareRoot(14));
        Assert.assertEquals(3, BinarySearch.squareRoot(15));
        Assert.assertEquals(4, BinarySearch.squareRoot(16));
        Assert.assertEquals(10, BinarySearch.squareRoot(101));
        Assert.assertEquals(3513, BinarySearch.squareRoot(12345678));
        Assert.assertEquals(46340, BinarySearch.squareRoot(2147395600));
        Assert.assertEquals(46339, BinarySearch.squareRoot(2147395599));
    }

    @Test
    public void binaryTreePreoder(){
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        int[] result = BinaryTree.preorderTraversal(root)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Assert.assertArrayEquals(new int[] {1}, result);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        result = BinaryTree.preorderTraversal(root)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Assert.assertArrayEquals(new int[] {1, 2, 3}, result);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        result = BinaryTree.preorderTraversal(root)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Assert.assertArrayEquals(new int[] {1, 2, 4, 3 }, result);
    }
}
