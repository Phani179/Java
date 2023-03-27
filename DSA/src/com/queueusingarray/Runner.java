package com.queueusingarray;

public class Runner 
{
	public static void main(String[] args) 
	{
		Queue queue = new Queue(4);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.show();
	}
}
