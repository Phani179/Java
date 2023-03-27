package com.doublycircularlinkedlist;

public class DoublyCircularLinkedList 
{
	Node headNode;
	Node tailNode;
	
	public void insert(int val)
	{
		Node node = new Node();
		node.val = val;
		
		if(headNode == null)
		{
			headNode = node;
			tailNode = node;
			headNode.nextNode = tailNode;
			tailNode.previousNode = headNode;
			tailNode.nextNode = headNode;
			headNode.previousNode = tailNode;
		}
		else
		{
			tailNode.nextNode = node;
			node.previousNode = tailNode;
			node.nextNode = headNode;
			headNode.previousNode = node;
			tailNode = node;
		}
	}
	
	public void insertAt(int index, int val)
	{
		Node node = new Node();
		node.val = val;
		
		if(headNode == null)
		{
			System.out.println("List is Empty, Value is inserted at start Index");
			insert(val);
		}
		else if(index == 0)
		{
			node.previousNode = tailNode;
			node.nextNode = headNode;
			headNode.previousNode = node;
			tailNode.nextNode = node;
			headNode = node;
		}
		else 
		{
			Node currentNode = headNode;
			Node next = null;
			for(int i = 0; i < index - 1; i++)
			{
				currentNode = currentNode.nextNode;
			}
			next = currentNode.nextNode;
			currentNode.nextNode = node;
			node.previousNode = currentNode;
			node.nextNode = next;
			next.previousNode = node;
		}
	}
	
	public void delete()
	{
		tailNode = tailNode.previousNode;
		tailNode.nextNode = headNode;
		headNode.previousNode = tailNode;	
	}
	
	public void deleteAt(int index)
	{
		if(headNode == null)
		{
			System.out.println("List is empty.");
		}
		else if(index == 0)
		{
			headNode = headNode.nextNode;
			headNode.previousNode = tailNode;
			tailNode.nextNode = headNode;
		}
		else 
		{
			Node currentNode = headNode;
			for(int i = 0; i < index - 1; i++)
			{
				currentNode = currentNode.nextNode;
			}
			Node next = currentNode.nextNode;
			next.nextNode.previousNode = next.previousNode;
			currentNode.nextNode = next.nextNode;
		}
	}
	
	public void show()
	{
		Node currentNode = headNode;
		
		while(currentNode.nextNode != headNode)
		{
			System.out.print(currentNode.val+" ");
			currentNode = currentNode.nextNode;
		}
		System.out.print(currentNode.val+" ");
		System.out.print(currentNode.nextNode.val);		// To check tailNode connect to headNode or not.
	}
}
