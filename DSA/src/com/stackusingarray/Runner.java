package com.stackusingarray;

public class Runner 
{
	public static void main(String[] args) 
	{
		Stack stack = new Stack(3);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		System.out.println(stack.peek);
		stack.show();
	}
}
