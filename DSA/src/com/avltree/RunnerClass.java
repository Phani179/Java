package com.avltree;

public class RunnerClass 
{
	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();
		avlTree.insert(10);
		avlTree.insert(20);
		avlTree.insert(30);
		avlTree.insert(40);
		avlTree.insert(50);
		avlTree.insert(60);
		avlTree.insert(70);
		avlTree.insert(80);
		avlTree.levelOrder(avlTree.rootNode);
		avlTree.deleteNode(10);
		System.out.println();
		avlTree.levelOrder(avlTree.rootNode);
		System.out.println(avlTree.rootNode.height);
	}
}
