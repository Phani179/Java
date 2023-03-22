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
		disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.leftChild), getHeight(disBalancedNode.rightChild));
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
		
		rootNode.height = 1 + Math.max(getHeight(rootNode.leftChild), getHeight(rootNode.rightChild));
		int balance = getBalance(rootNode);
		
		if(balance > 1 && value < rootNode.leftChild.value)	// LL Condition.
		{
			rootNode = rightRotation(rootNode);
		}
		if(balance > 1 && value > rootNode.leftChild.value) // LR Condition.
		{
			rootNode.leftChild = leftRotation(rootNode.leftChild);
			rootNode = rightRotation(rootNode);
		}
		if(balance < -1 && value > rootNode.rightChild.value) // RR Condition.
		{
			rootNode = leftRotation(rootNode);
		}
		if(balance < -1 && value < rootNode.rightChild.value) // RL Condition.
		{
			rootNode.rightChild = rightRotation(rootNode.rightChild);
			rootNode = leftRotation(rootNode);
		}
		return rootNode;
		
	} 
	
	public void insert(int value)
	{
		rootNode = insert(rootNode, value);
	}
	
	// Minimum Node.
	public BinaryNode minimiNode(BinaryNode node)
	{
		if(node.leftChild == null)
		{
			return node;
		}
		return minimiNode(node.leftChild);
	}
	
	// Delete Node.
	public BinaryNode deleteNode(BinaryNode rootNode, int value)
	{
		if(rootNode == null)
		{
			System.out.println("Tree is Empty");
			return null;
		}
		else if(value < rootNode.value)
		{
			rootNode.leftChild = deleteNode(rootNode.leftChild, value);
		}
		else if(value > rootNode.value)
		{
			rootNode.rightChild = deleteNode(rootNode.rightChild, value);
		}
		else 
		{
			if(rootNode.leftChild != null && rootNode.rightChild!= null)	// Node has two children.
			{
				BinaryNode minNodeforRight = minimiNode(rootNode.rightChild);
				rootNode.value = minNodeforRight.value;
				rootNode.rightChild = deleteNode(rootNode.rightChild, minNodeforRight.value);
			}
			else if (rootNode.leftChild != null) 		// Node has one left children.
			{	
				rootNode = rootNode.leftChild;
			}
			else if (rootNode.rightChild != null) 		// Node has one right children.
			{
				rootNode = rootNode.rightChild;
			}
			else										// Node to be deleted is a leaf Node. 
			{
				rootNode = null;
			}
		}
		
		int balance = getBalance(rootNode);
		
		if(balance > 1 && getBalance(rootNode.leftChild) > 0)	// LL Condition.
		{
			rootNode = rightRotation(rootNode);
		}
		if(balance > 1 && getBalance(rootNode.leftChild) < 0)	// LR Condition.
		{
			rootNode.leftChild = leftRotation(rootNode.leftChild);
			rootNode = rightRotation(rootNode);
		}
		if(balance < -1 && getBalance(rootNode.rightChild) < 0)	// RR Condition.
		{
			rootNode = leftRotation(rootNode);
		}
		if(balance < -1 && getBalance(rootNode.rightChild) > 0)	// LR Condition.
		{
			rootNode.rightChild = rightRotation(rootNode.rightChild);
			rootNode = leftRotation(rootNode.rightChild);
		}
		return rootNode;
	}
	
	public void deleteNode(int value)
	{
		rootNode = deleteNode(rootNode, value);
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
