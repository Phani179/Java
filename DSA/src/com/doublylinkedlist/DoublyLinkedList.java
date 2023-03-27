package com.doublylinkedlist;

public class DoublyLinkedList 
{
	private Node headNode;
	private Node tailNode;
	public int length;
	
	public void insert(int val)
	{
		Node node = new Node(null,val,null);
		if(headNode == null)
		{
			headNode = node;
			tailNode = node;
			length++;
		}
		else 
		{
			tailNode.next = node;
			node.previous = tailNode;
			tailNode = node;
			length++;
		}
	}
	
	public void insertAt(int index, int val)
	{
		Node node = new Node(null,val,null);
		
		Node currentNode = headNode;
		if(headNode == null)
		{
			headNode = node;
			tailNode = node;
			length++;
		}
		else if(index == 0)
		{
			currentNode.previous = node;
			node.next = currentNode;
			length++;
		}
		else if(index == 1)
		{
			Node nextNode = null;
			nextNode = currentNode.next;
			currentNode.next = node;
			node.previous = currentNode;
			node.next = nextNode;
			nextNode.previous = node;
			length++;
		}
		else if(index == length-1)
		{
			tailNode.next = node;
			node.previous = tailNode;
			tailNode = node;
			length++;
		}
		else 
		{
			Node nextNode = null;
			for(int i = 0; i < index - 1; i++)
			{
				currentNode = currentNode.next;
			}
			nextNode = currentNode.next;
 			currentNode.next = node;
 			node.previous = currentNode;
			length++;
		}
	}
	
	public void delete(int index)
	{
		Node currentNode = headNode;
		Node nextNode = null;
		if(headNode == null)
		{
			return;
		}
		else if(index == 0)
		{
			nextNode = currentNode.next;
			nextNode.previous = null;
			headNode = nextNode;
			length--;
		}
		else
		{
			for(int i = 0; i < index - 1; i++)
			{
				currentNode = currentNode.next;
			}
			nextNode = currentNode.next;
			currentNode.next = nextNode.next;
			nextNode.next.previous = currentNode;
			nextNode = null;
			length--;
		}
	}
	
	public void show()
	{
		Node currentNode = headNode;
		for(int i = 0; i < length; i++)
		{
			System.out.print(currentNode.val+" ");
			currentNode = currentNode.next;
		}
	}
}
