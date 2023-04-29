package com.hashing;

import java.util.LinkedList;

public class HashingDirectChaining
{
	LinkedList<String>[] hashTable;
	
	public HashingDirectChaining(int length) {
		hashTable = new LinkedList[length];
	}
	
	// modASCII HashFunction.
	public int modASCIIHashFunction(String word, int length)
	{
		int total = 0;
		for(int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			total += ch;
		}
		return total % length;
	}
	
	// Insertion Method.
	public void insert(String word)
	{
		int index = modASCIIHashFunction(word, hashTable.length);
		if(hashTable[index] == null)
		{
			hashTable[index] = new LinkedList<>();
			hashTable[index].add(word);
		}
		else 
		{
			hashTable[index].add(word);
		}
	}
	
	// Display Method.
	public void showHashTable() 
	{
		for(int i = 0; i < hashTable.length; i++)
		{
			System.out.println("Index = "+i+""+" Data = "+hashTable[i]);
		}
	}
	
	// Search Method.
	public boolean search(String word)
	{
		int index = modASCIIHashFunction(word, hashTable.length);
		if(hashTable[index] == null)
		{
			System.out.println("Word "+word+" not found");
			return false;
		}
		else if(hashTable[index].contains(word))
		{
			System.out.println("Word "+word+" is found");
			return true;
		}
		else 
		{
			System.out.println("Word "+word+" not found");
		}
		return false;
	}
	
	// Delete Method.
	public void delete(String word)
	{
		if(!search(word))
		{
			return;
		}
		else
		{
			int index = modASCIIHashFunction(word, hashTable.length);
			hashTable[index].remove(word);
			System.out.println("Deleted !!!");
		}
	}
}
