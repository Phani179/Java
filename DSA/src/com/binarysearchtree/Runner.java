package com.binarysearchtree;

public class Runner
{
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(70);
		binarySearchTree.insert(50);
		binarySearchTree.insert(90);
		binarySearchTree.insert(30);
		binarySearchTree.insert(60);
		binarySearchTree.insert(80);
		binarySearchTree.insert(100);
		binarySearchTree.insert(20);
		binarySearchTree.insert(40);
		binarySearchTree.show();
		System.out.println();
//		binarySearchTree.preOrder(binarySearchTree.rootNode);
//		System.out.println();
//		binarySearchTree.inOrder(binarySearchTree.rootNode);
//		System.out.println();
//		binarySearchTree.postOrder(binarySearchTree.rootNode);
		binarySearchTree.delete(70);
		binarySearchTree.deleteBST();
		binarySearchTree.show();
	}
}
