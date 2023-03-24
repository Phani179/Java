package com.binaryheap;

public class RunnerClass 
{
	public static void main(String[] args) {
		BinaryHeap bh = new BinaryHeap(10);
		bh.insert(10, "Min");
		bh.insert(20, "Min");
		bh.insert(5, "Min");
		bh.insert(30, "Min");
//		bh.insert(1, "Min");
		bh.insert(35, "Min");
		bh.insert(15, "Min");
		bh.insert(50, "Min");
		bh.insert(25, "Min");
		bh.insert(55, "Min");
		bh.extract("Min");
		bh.levelOrder();
	}
}
