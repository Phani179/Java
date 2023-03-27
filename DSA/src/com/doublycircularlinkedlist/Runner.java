package com.doublycircularlinkedlist;

public class Runner 
{
	public static void main(String[] args) {
		DoublyCircularLinkedList list = new DoublyCircularLinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.delete();
		list.deleteAt(0);
//		list.insertAt(1,0);
		list.show();
	}
}
 