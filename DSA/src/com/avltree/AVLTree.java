package com.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree 	// Adelson - Velsky and Landis
{
	BinaryNode rootNode;
	
	public AVLTree()
	{
		rootNode = null;
	}
	
	// Height of the Node.
	public int getHeight(BinaryNode rootNode)
	{
		if(rootNode == null)
		{
			return 0;
		}
		return rootNode.height;
	}
	
	// Difference between heights of LeftSubTree and RightSubTree.
	public int getBalance(BinaryNode rootNode)
	{
		if(rootNode == null)
		{
			return 0;
		}
		return getHeight(rootNode.leftChild) - getHeight(rootNode.rightChild);
	}
	
	// Right Rotation.
	public BinaryNode rightRotation(BinaryNode disBalancedNode)
	{
		BinaryNode newRoot = disBalancedNode.leftChild;
		disBalancedNode.leftChild = newRoot.rightChild;
		newRoot.rightChild = disBalancedNode;
		disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.leftChild), getHeight(disBalancedNode.rightChild));
		newRoot.height = 1 + Math.max(getHeight(newRoot.leftChild), getHeight(newRoot.rightChild));
		return newRoot;
	}
	
	// Left Rotation.
	public BinaryNode leftRotation(BinaryNode disBalancedNode)
	{
		BinaryNode newRoot = disBalancedNode.rightChild;
		disBalancedNode.rightChild = newRoot.leftChild;
		newRoot.leftChild = disBalancedNode;
		disBalancedNode.height = 1 + Math.max(getHeight(newRoot.leftChild), getHeight(newRoot.rightChild));
		newRoot.height = 1 + Math.max(getHeight(newRoot.leftChild), getHeight(newRoot.rightChild));
		return newRoot;
	}
	
	// Insert Node
	private BinaryNode insert(BinaryNode rootNode, int value)
	{
		if(rootNode == null)
		{
			BinaryNode newNode = new BinaryNode();
			newNode.value = value;
			return newNode;
		}
		else if(value < rootNode.value)
		{
			rootNode.leftChild =  insert(rootNode.leftChild, value);
		}
		else
		{
			rootNode.rightChild = insert(rootNode.rightChild, value);
		}
		
		int balance = getBalance(rootNode);
		rootNode.height = 1 + Math.max(getHeight(rootNode.leftChild), getHeight(rootNode.rightChild));
		
		if(balance > 1 && value < rootNode.leftChild.value)	// LL Condition.
		{
			return rightRotation(rootNode);
		}
		if(balance > 1 && value > rootNode.leftChild.value) // LR Condition.
		{
			rootNode.leftChild = leftRotation(rootNode.leftChild);
			return rightRotation(rootNode);
		}
		if(balance < -1 && value > rootNode.rightChild.value) // RR Condition.
		{
			return leftRotation(rootNode);
		}
		if(balance < -1 && value < rootNode.rightChild.value) // RL Condition.
		{
			rootNode.rightChild = rightRotation(rootNode.rightChild);
			return leftRotation(rootNode);
		}
		return rootNode;
	}
	
	public void insert(int value)
	{
		rootNode = insert(rootNode, value);
	}
	
	// Level Order Traversal.
	public void levelOrder(BinaryNode rootNode)
	{
		if(rootNode == null)
		{
			System.out.println("Tree is Empty !!!");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(rootNode);
		while(!queue.isEmpty())
		{
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value+" ");
			if(presentNode.leftChild != null)
			{
				queue.add(presentNode.leftChild);
			}
			if(presentNode.rightChild != null)
			{
				queue.add(presentNode.rightChild);
			}
		}
	}
}
