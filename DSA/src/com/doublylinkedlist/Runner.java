package com.doublylinkedlist;

public class Runner 
{
	public static void main(String[] args) 
	{
		DoublyLinkedList list = new DoublyLinkedList();
		list.insert(0);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insertAt(4,4);
		list.delete(2);
		list.show();
		System.out.print("\n"+list.length);
	}
}
