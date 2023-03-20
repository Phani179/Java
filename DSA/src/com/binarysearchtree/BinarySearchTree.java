package com.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

import javax.xml.crypto.NodeSetData;

public class BinarySearchTree 
{
	BinaryNode rootNode;
	
//	// Insertion Method. --> O(N)
//	public void insert(int value)
//	{
//		BinaryNode node = new BinaryNode(value);
//		if(rootNode == null)
//		{
//			rootNode = node;
//			return;
//		}
//		Queue<BinaryNode> queue = new LinkedList<>();
//		queue.add(rootNode);
//		while(!queue.isEmpty())
//		{
//			BinaryNode presentNode = queue.remove();
//			if(presentNode.leftNode != null && presentNode.value >= value)
//			{
//				queue.add(presentNode.leftNode);
//			}
//			else if(presentNode.rightNode != null && presentNode.value < value)
//			{
//				queue.add(presentNode.rightNode);
//			}
//			else if(presentNode.leftNode == null && presentNode.value >= value)
//			{
//				presentNode.leftNode = node;
//			}
//			else {
//				presentNode.rightNode = node;
//			}
//		}
//	}
	
	// Insert method. --> O(log N)
	private BinaryNode insert(BinaryNode rootNode, int value)
	{
		if(rootNode == null)
		{
			BinaryNode newBinaryNode = new BinaryNode(value);
			return newBinaryNode;
		}
		else if(rootNode.value >= value)
		{
			rootNode.leftNode = insert(rootNode.leftNode, value);
			return rootNode;
		}
		else
		{
			rootNode.rightNode = insert(rootNode.rightNode, value);
			return rootNode;
		}
	}
	
	public void insert(int value)
	{
		rootNode= insert(rootNode,value);
	}
	
	// PreOrder Traversal.
	public void preOrder(BinaryNode rootNode)
	{
		if(rootNode == null)
		{
			return;
		}
		System.out.print(rootNode.value+" ");
		preOrder(rootNode.leftNode);
		preOrder(rootNode.rightNode);
	}
	
	// Minimum Node.
	public BinaryNode minimuNode(BinaryNode node)
	{
		if(node.leftNode == null)
		{
			return node;
		}
		return minimuNode(node.leftNode);
	}
	
	// Delete Node.
	public BinaryNode deleteNode(BinaryNode rootNode, int value)
	{
		if(rootNode == null)
		{
			System.out.println("Element is Not Found in the Binary Search Tree");
			return null;
		}
		else if(value < rootNode.value)
		{
			rootNode.leftNode = deleteNode(rootNode.leftNode, value);
		}
		else if(value > rootNode.value)
		{
			rootNode.rightNode = deleteNode(rootNode.rightNode, value);
		}
		else {
			if(rootNode.leftNode != null && rootNode.rightNode != null)	// Node has Two childern.
			{
				BinaryNode minNodeforRight = minimuNode(rootNode.rightNode);
				rootNode.value = minNodeforRight.value;
				rootNode.rightNode = deleteNode(rootNode.rightNode, minNodeforRight.value);
			}
			else if(rootNode.leftNode != null)	// Node has one left childern.
			{
				rootNode = rootNode.leftNode;
			}
			else if (rootNode.rightNode != null) // Node has one right children.
			{
				rootNode = rootNode.rightNode;
			}
			else 	// Node to be deleted is a Leaf Node.
			{
				rootNode = null;
			}
		}
		return rootNode;
	}
	
	// Delete Method Caller.
	public void delete(int value) {
		deleteNode(rootNode, value);
	}
	
	// Delete entire BST.
	public void deleteBST()
	{
		this.rootNode = null; 
	}
	
	// InOrder Traversal.
	public void inOrder(BinaryNode rootNode)
	{
		if(rootNode == null)
		{
			return;
		}
		inOrder(rootNode.leftNode);
		System.out.print(rootNode.value+" ");
		inOrder(rootNode.rightNode);
	}
	
	// PostOrder Traversal.
	public void postOrder(BinaryNode rootNode)
	{
		if(rootNode == null)
		{
			return;
		}
		postOrder(rootNode.leftNode);
		postOrder(rootNode.rightNode);
		System.out.print(rootNode.value+" ");
	}
	
	// LevelOrder Traversal Method is used in show() method.
	public void show()
	{
		if(rootNode == null)
		{
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(rootNode);
		while(!queue.isEmpty())
		{
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value+" ");
			if(presentNode.leftNode != null)
			{
				queue.add(presentNode.leftNode);
			}
			if(presentNode.rightNode != null)
			{
				queue.add(presentNode.rightNode);
			}
		}
	}
}
