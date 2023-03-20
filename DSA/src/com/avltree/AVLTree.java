package com.avltree;

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
		return 1 + Math.max(getHeight(rootNode.leftChild), getHeight(rootNode.rightChild));
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
		newRoot.height = 1 + Math.max(getHeight(newRoot.leftChild), getHeight(newRoot.rightChild));
		disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.leftChild), getHeight(disBalancedNode.rightChild));
		return newRoot;
	}
	
	// Insert Node
	private BinaryNode insert(BinaryNode rootNode, int value)
	{
		if(rootNode == null)
		{
			BinaryNode newNode = new BinaryNode();
			newNode.value = value;
			return rootNode;
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
		if(balance > 1 && value < rootNode.leftChild.value)
		{
			
		}
	}
}
