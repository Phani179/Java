package com.singlelinkedlist;

public class Runner 
{
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(8);
		list.insert(44);
		list.insert(1201);
		list.insert(844);
		list.insertAtStart(448);
		list.insertAt(2, 1000);
		list.deleteAt(3);
		list.show();
	}
}
