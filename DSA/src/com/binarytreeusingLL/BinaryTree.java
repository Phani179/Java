package com.binarytreeusingLL;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree 
{
	BinaryNode rootNode;
	
	// Insert Method.
	public void insert(int value)
	{
		BinaryNode node = new BinaryNode(value);
		if(rootNode == null)
		{
			rootNode = node;
		}
		else
		{
			Queue<BinaryNode> binaryNodes = new LinkedList<BinaryNode>();
			binaryNodes.add(rootNode);
			
			while(!binaryNodes.isEmpty())
			{
				BinaryNode presentNode = binaryNodes.remove();
//				System.out.print(presentNode.value+" ");
				if(presentNode.leftNode == null)
				{
					presentNode.leftNode = node;
					return;
				}
				else if(presentNode.rightNode == null)
				{
					presentNode.rightNode = node;
					return;
				}
				else
				{
					binaryNodes.add(presentNode.leftNode);
					binaryNodes.add(presentNode.rightNode);
				}
			}
		}
	}
	
	// Deepest Node.
	public BinaryNode findingDeepestNode()
	{
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(rootNode);
		BinaryNode presentNode = null;
		while(!queue.isEmpty())
		{
			presentNode = queue.remove();
			if(presentNode.leftNode != null)
			{
				queue.add(presentNode.leftNode);
			}
			if(presentNode.rightNode != null)
			{
				queue.add(presentNode.rightNode);
			}
		}
		return presentNode;
	}
	
	// Delete Deepest Node.
	public void deleteDeepestNode()
	{
		Queue<BinaryNode> binaryNodes = new LinkedList<>();
		binaryNodes.add(rootNode);
		BinaryNode previousNode = null, presentNode = null;
		while(!binaryNodes.isEmpty())
		{
			previousNode = presentNode;
			presentNode = binaryNodes.remove();
			if(presentNode.leftNode == null)
			{
				previousNode.rightNode = null;
				return;
			}
			if(presentNode.rightNode == null)
			{
				presentNode.leftNode = null;
				return;
			}
			if(presentNode.leftNode != null)
			{
				binaryNodes.add(presentNode.leftNode);
			}
			if(presentNode.rightNode != null)
			{
				binaryNodes.add(presentNode.rightNode);
			}
		}
	}
	
	// Delete a Node in Binary Tree.
	public void deleteNode(int value)
	{
		Queue<BinaryNode> binaryNodes = new LinkedList<>();
		binaryNodes.add(rootNode);
		while(!binaryNodes.isEmpty()) 
		{
			BinaryNode presentNode = binaryNodes.remove();
			if(presentNode.value == value)
			{
				presentNode.value = findingDeepestNode().value;
				deleteDeepestNode();
//				presentNode = deepestNode; 
				return;
			}
			else
			{
				if(presentNode.leftNode != null)
				{
					binaryNodes.add(presentNode.leftNode);
				}
				if(presentNode.rightNode != null)
				{
					binaryNodes.add(presentNode.rightNode);
				}
			}
		}
	}
	
	
	public void show(BinaryNode rootNode)
	{
		Queue<BinaryNode> binaryNodes = new LinkedList<>();
		binaryNodes.add(rootNode);
		while(!binaryNodes.isEmpty()) 
		{
			BinaryNode presentNode = binaryNodes.remove();
			System.out.print(presentNode.value+" ");
			if(presentNode.leftNode != null)
			{
				binaryNodes.add(presentNode.leftNode);
			}
			if(presentNode.rightNode != null)
			{
				binaryNodes.add(presentNode.rightNode);
			}
		}
	}
}
