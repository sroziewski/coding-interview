package com.company;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    static List<Integer> preorderedList = new ArrayList<Integer>();

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return preorderedList;
    }

    private static void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        preorderedList.add(root.val);
        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null){
            preOrder(root.right);
        }
    }

}
