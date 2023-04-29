package com.hashing;

public class Runner 
{
	public static void main(String[] args) {
		HashingDirectChaining hashing = new HashingDirectChaining(10);
		hashing.insert("Phani");
		hashing.insert("Prem");
		hashing.insert("Aaryan");
		hashing.insert("Mouni");
		hashing.showHashTable();
		hashing.delete("Prem");
//		hashing.search("Hi");
		hashing.showHashTable();
	}
}
