package com.binarytreeusingArray; 

public class RunnerClass
{
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree(9);
        tree.insert("N1");
        tree.insert("N2");
        tree.insert("N3");
        tree.insert("N4");
        tree.insert("N5");
        tree.insert("N6");
        tree.insert("N7");
        tree.insert("N8");
        tree.insert("N9");
        tree.preOrder(1);
        System.out.println();
        tree.postOrder(1);
        System.out.println();
        tree.inOrder(1);
        System.out.println();
        tree.levelOrder();
        System.out.println();
        tree.show();
        System.out.println();
    }
}