package com.binarytreeusingArray; 

public class RunnerClass
{
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree(4);
        tree.insert("N1");
        tree.insert("N2");
        tree.insert("N3");
        tree.insert("N4");
        
        tree.show();
    }
}