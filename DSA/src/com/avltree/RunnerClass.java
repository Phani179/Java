package com.avltree;

public class RunnerClass 
{
	public static void main(String[] args) 
	{
		AVLTree avlTree = new AVLTree();
		avlTree.insert(10);
		avlTree.insert(20);
		avlTree.insert(30);
		avlTree.insert(30);
		avlTree.insert(40);
		avlTree.insert(50);
		avlTree.insert(60);
		avlTree.levelOrder();
		System.out.println();
		avlTree.delete(30);
		avlTree.levelOrder();
	}
}
