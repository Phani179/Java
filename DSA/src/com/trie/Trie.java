package com.trie;


public class Trie 
{
	TrieNode rootNode;
	
	public Trie() {
		rootNode = new TrieNode();
	}
	
	// Inserting a String into the Trie.
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
	
	// Search for a String in the Trie.
	public boolean search(String word)
	{
		if(rootNode == null)
		{
			System.out.println("Word "+word+" is not present in the Trie.");
			return false;
		}
		TrieNode currentNode = rootNode;
		for(int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			TrieNode node = currentNode.children.get(ch);
			if(node == null)
			{
				System.out.println("Word "+word+" is not present in the Trie.");
				return false;
			}
			currentNode = node;
		}
		if(currentNode.endOfString == true)
		{
			System.out.println("Word "+word+" is present in the Trie.");
			return true;
		}
		else {
			System.out.println("Word "+word+" is present as prefix of another Word");
			return false;
		}
	}
	
	// Deletion Helper Method.
	private boolean delete(TrieNode rootNode, String  word, int index)
	{
		char ch = word.charAt(index);
		TrieNode currentNode = rootNode.children.get(ch);
		boolean canThisNodeBeDeleted;
		if(currentNode.children.size() > 1)
		{
			delete(currentNode, word, index + 1);
			return false;
		}
		if(index == word.length() - 1)
		{
			if (currentNode.children.size() >= 1) 
			{
				currentNode.endOfString = false;
				return false;
			}
			else {
				rootNode.children.remove(ch);
				return true;
			}
		}
		if(currentNode.endOfString ==  true)
		{
			delete(currentNode, word, index + 1);
			return false;
		} 
		canThisNodeBeDeleted = delete(currentNode, word, index + 1);
		if(canThisNodeBeDeleted == true)
		{
			rootNode.children.remove(ch);
			return true;
		}
		else {
			return false;
		}
	}
	
	// Delete Method.
	public void delete(String word)
	{
		if(search(word) == true)
		{
			delete(rootNode, word, 0);
		}
	}
}





