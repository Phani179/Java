package com.binarytreeusingLL;

public class RunnerClass 
{
	public static void main(String[] args) 
	{
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.insert(5);
		binaryTree.insert(6);
		binaryTree.insert(7);
		binaryTree.insert(8);
		binaryTree.deleteNode(3);
		binaryTree.show(binaryTree.rootNode);
	}
}
