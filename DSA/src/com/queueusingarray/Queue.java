package com.queueusingarray;

public class Queue 
{
	int head, tail;
	int[] queue;
	int size;
	public Queue(int length) 
	{
		size = length;
		queue = new int[length];
		for(int i = 0; i < length; i++)
		{
			queue[i] = 0;
		}
		head = -1;
		tail = -1;
	}
	
	public void enQueue(int val)
	{
		if(tail == size - 1)
		{
			System.out.println("Overflow...");
		}
		else if(head == -1)
		{
			head++; 
			tail++;
			queue[head] = val;
		}
		else
		{
			tail++;
			queue[tail] = val;
		}
	}
	
	public void deQueue()
	{
		if(head > tail)
		{
			System.out.println("Underflow...");
		}
		else if(head == tail)
		{
			queue[head] = 0;
			head++;
		}
		else 
		{
			queue[head] = 0;
			head++;
		}
	}
	
	public void show()
	{
		for(int i = head; i <= size - 1; i++)
		{
			System.out.print(queue[i]+" ");
		}
	}
}
