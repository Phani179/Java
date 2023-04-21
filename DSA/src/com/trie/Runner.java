package com.trie;

public class Runner 
{
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("API");
		trie.insert("APIS");
		
		trie.delete("API");
		trie.search("API");
	}
}
