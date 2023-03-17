package com.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

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
