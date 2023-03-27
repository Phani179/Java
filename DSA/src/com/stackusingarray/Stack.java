package com.stackusingarray;

public class Stack 
{
	int top;
	int size;
	int[] stack; 
	public int peek;
	public Stack(int length) 
	{
		size = length;
		stack = new int[length];
		for(int i = 0; i < length; i++)
		{
			stack[i] = 0;
		}
		top = -1;
	}
	
	public void push(int data)
	{
		if(top == size - 1)
		{
			System.out.println("Stack Overflow");
		}
		else 
		{
			top++;
			stack[top] = data;
			System.out.println("Element inserted...");
		}
		peek = stack[top];
	}
	
	public void pop()
	{
		if(top == -1)
		{
			System.out.println("Stack Underflow");
		}
		else 
		{
			stack[top] = 0;
			top--;
			System.out.println("Element deleted...");
		}
		peek = stack[top];
	}
	
	public boolean isEmpty()
	{
		if(top == -1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isFull()
	{
		if(top == size - 1)
		{
			return true;
		}
		return false;
	}
	
	public void show() 
	{
		for(int i = 0; i < size; i++)
		{
			System.out.println(stack[i]);
		}
	}
}
