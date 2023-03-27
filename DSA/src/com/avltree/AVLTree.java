package com.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree 	// Adelson - Velsky and Landis
{
	BinaryNode rootNode;
	
	// Height of Node.
	public int getHeight(BinaryNode rootNode)
	{
		if(rootNode == null)
		{
			return -1;
		}
		return rootNode.height;
	}
	
	// Balance.
	public int getBalance(BinaryNode rootNode)
	{
		if(rootNode == null)
		{
			return 0;
		}
		return getHeight(rootNode.leftChild) - getHeight(rootNode.rightChild);
	}
	
	// Right Rotation.
	public BinaryNode rightRotation(BinaryNode rootNode)
	{
		BinaryNode newRoot = rootNode.leftChild;
		rootNode.leftChild = newRoot.rightChild;
		newRoot.rightChild = rootNode;
		rootNode.height = 1 + Math.max(getHeight(rootNode.leftChild), getHeight(rootNode.rightChild));
		newRoot.height = 1 + Math.max(getHeight(newRoot.leftChild), getHeight(newRoot.rightChild));
		return newRoot;
	}
	
	// Left Rotation.
	public BinaryNode leftRotation(BinaryNode rootNode)
	{
		BinaryNode newRoot = rootNode.rightChild;
		rootNode.rightChild = newRoot.leftChild;
		newRoot.leftChild = rootNode;
		rootNode.height = 1 + Math.max(getHeight(rootNode.leftChild), getHeight(rootNode.rightChild));
		newRoot.height = 1 + Math.max(getHeight(newRoot.leftChild), getHeight(newRoot.rightChild));
		return newRoot;
	}
	
	// Insert Method Runner.
	private BinaryNode insert(BinaryNode rootNode, int value)
	{
		if(rootNode == null)
		{
			BinaryNode newNode = new BinaryNode();
			newNode.value = value;
			newNode.height = 0;
			return newNode;
		}
		else if(value <= rootNode.value)
		{
			rootNode.leftChild = insert(rootNode.leftChild, value);
		}
		else 
		{
			rootNode.rightChild = insert(rootNode.rightChild, value);
		}
		
		rootNode.height = 1 + Math.max(getHeight(rootNode.leftChild), getHeight(rootNode.rightChild));
		int balance = getBalance(rootNode);
		if(balance > 1 && value < rootNode.leftChild.value)
		{
			rootNode = rightRotation(rootNode);
			return rootNode;
		}
		if(balance > 1 && value > rootNode.leftChild.value)
		{
			rootNode.leftChild = leftRotation(rootNode.leftChild);
			rootNode = rightRotation(rootNode);
			return rootNode;
		}
		if(balance < -1 && value > rootNode.rightChild.value)
		{
			rootNode = leftRotation(rootNode);
			return rootNode;
		}
		if(balance < -1 && value <= rootNode.rightChild.value) 
		{
			rootNode.rightChild = rightRotation(rootNode.rightChild);
			rootNode = leftRotation(rootNode);
			return rootNode;
		}
		return rootNode;
	}
	
	// Insert Method.
	public void insert(int value)
	{
		rootNode = insert(rootNode, value);
	}
	
	//Minimum Node.
	public BinaryNode getMinimum(BinaryNode rootNode)
	{
		if(rootNode.leftChild == null)
		{
			return rootNode;
		}
		return getMinimum(rootNode.leftChild); 
	}
	
	// Delete Method Runner.
	private BinaryNode delete(BinaryNode rootNode, int value)
	{
		if(rootNode == null)
		{
			System.out.println("Element is not in the AVL Tree");
			return null;
		}
		else if(value < rootNode.value)
		{
			rootNode.leftChild = delete(rootNode.leftChild, value);
		}
		else if(value > rootNode.value)
		{
			rootNode.rightChild = delete(rootNode.rightChild, value);
		}
		else 
		{
			if(rootNode.leftChild != null && rootNode.rightChild != null)
			{
				BinaryNode minNodeForRight = getMinimum(rootNode.rightChild);
				rootNode.value = minNodeForRight.value;
				rootNode.rightChild = delete(rootNode.rightChild, minNodeForRight.value);
			}
			else if(rootNode.leftChild != null)
			{
				rootNode = rootNode.leftChild;
			}
			else if(rootNode.rightChild != null)
			{
				rootNode = rootNode.rightChild;
			}
			else 
			{
				rootNode = null;
			}
		}	
		int balance = getBalance(rootNode);
		if(balance > 1 && value < rootNode.leftChild.value)
		{
			rootNode = rightRotation(rootNode);
			return rootNode;
		}
		if(balance > 1 && value > rootNode.leftChild.value)
		{
			rootNode.leftChild = leftRotation(rootNode.leftChild);
			rootNode = rightRotation(rootNode);
			return rootNode;
		}
		if(balance < -1 && value > rootNode.rightChild.value)
		{
			rootNode = leftRotation(rootNode);
			return rootNode;
		}
		if(balance < -1 && value <= rootNode.rightChild.value) 
		{
			rootNode.rightChild = rightRotation(rootNode.rightChild);
			rootNode = leftRotation(rootNode);
			return rootNode;
		}
		return rootNode;
	}
	
	// Delete Method.
	public void delete(int value)
	{
		rootNode = delete(rootNode, value);
	}
	
	// Level Order.
	public void levelOrder()
	{
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(rootNode);
		while(!queue.isEmpty())
		{
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value+" - "+presentNode.height+" ");
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
