package com.binaryheap;

public class BinaryHeap 
{
	int[] arr;
	int sizeOfTree;
	
	BinaryHeap(int size)
	{
		arr = new int[size+1];
		sizeOfTree = 0;
	}
	
	// isEmpty.
	public boolean isEmpty()
	{
		if(sizeOfTree == 0)
		{
			return true;
		}
		return false;
	}
	
	// Peek of the Heap.
	public int peek()
	{
		if(sizeOfTree == 0)
		{
			return 0;
		}
		return arr[1];
	}
	
	// Swapping of Two Numbers.
	public void swap(int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	//HeapifyBottomToTop.
	public void heapifyBottomToTop(int index, String heapType)
	{
		int parent = index/2;		
		if(parent <= 0)
		{
			return;
		}
		
		if( heapType.equals("Min") && arr[index] < arr[parent])
		{
			swap(index,parent);
		}
		if( heapType.equals("Max") && arr[index] > arr[parent])
		{
			swap(index,parent);
		}
		heapifyBottomToTop(parent,heapType);
	}
	
	// Insert Node.
	public void insert(int value, String heapType)
	{
		if(sizeOfTree == arr.length - 1)
		{
			System.out.println("Binary Heap is full !!!");
			return;
		}
		arr[++sizeOfTree] = value;
		heapifyBottomToTop(sizeOfTree,heapType);
	}
	
	// Level Order.
	public void levelOrder()
	{
		for(int i = 1; i <= sizeOfTree; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	// heapifyTopToBottom.
	public void heapifyTopToBottom(int index, String heapType)
	{
		int left = index * 2;
		int right = index * 2 + 1;
		int swapChild = 0;
		if(sizeOfTree < left)
		{
			return;
		}
		
		if(heapType.equals("Max"))
		{
			if(sizeOfTree == left)
			{
				if(arr[left] > arr[index]) {
					swap(left,index);
				}
				return;
			}
			else
			{
				if(arr[left] > arr[right])
				{
					swapChild = left;
				}
				else
				{
					swapChild = right;
				}
				if(arr[swapChild] > arr[index])
				{
					swap(swapChild,index);
				}
			}
		}
		else
		{
			if(sizeOfTree == left)
			{
				if(arr[left] < arr[index])
				{
					swap(left,index);
				}
			}
			else
			{
				if(arr[left] < arr[right])
				{
					swapChild = left;
				}
				else
				{
					swapChild = right;
				}
				if(arr[swapChild] < arr[index])
				{
					swap(swapChild, index);
				}
			}
		}
		heapifyTopToBottom(swapChild, heapType);
	}
	
	// Extract Node.
	public void extract(String heapType)
	{
		arr[1] = arr[sizeOfTree--];
		heapifyTopToBottom(1,heapType);
	}
}













