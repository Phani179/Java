package com.trie;

import com.doublycircularlinkedlist.Node;

public class Trie 
{
	TrieNode rootNode;
	
	public void insert(String word)
	{
		TrieNode currentNode = rootNode;
		for(int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			TrieNode node = currentNode.children.get(ch);
			if(node == null)
			{
				node = new TrieNode();
				currentNode.children.put(ch,node);
			}
			currentNode = node;
		}
		currentNode.endOfString = true;
		System.out.println("Succesfully Inserted...!");
	}
}
