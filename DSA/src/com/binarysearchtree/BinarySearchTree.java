package com.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree 
{
	BinaryNode rootNode;
	
	public void insert(int value)
	{
		BinaryNode node = new BinaryNode(value);
		if(rootNode == null)
		{
			rootNode = node;
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(rootNode);
		while(!queue.isEmpty())
		{
			BinaryNode presentNode = queue.remove();
			if(presentNode.leftNode != null && presentNode.value >= value)
			{
				queue.add(presentNode.leftNode);
			}
			else if(presentNode.rightNode != null && presentNode.value < value)
			{
				queue.add(presentNode.rightNode);
			}
			else if(presentNode.leftNode == null && presentNode.value >= value)
			{
				presentNode.leftNode = node;
			}
			else {
				presentNode.rightNode = node;
			}
		}
	}
	
	public void show()
	{
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
