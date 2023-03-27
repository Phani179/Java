package doublylinkedlist;

public class Node 
{
	Node previous;
	Node next;
	int val;
	public Node(int val)
	{
		this.val = val;
	}
	public Node(Node previous,int val, Node next) 
	{
		this.previous = previous;
		this.val = val;
		this.next = next;
	}
}
