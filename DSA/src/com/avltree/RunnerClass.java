package com.avltree;

public class RunnerClass 
{
	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();
		avlTree.insert(50);
		avlTree.insert(40);
		avlTree.insert(60);
		avlTree.insert(70);
		avlTree.insert(75);
		avlTree.levelOrder(avlTree.rootNode);
	}
}
