package com.binarytreeusingArray;

public class BinaryTree
{
    String binaryTree[];
    int lastUsedIndex = 0;

    public BinaryTree(int length)
    {
        binaryTree = new String[length + 1];
    }
    
    // PreOrder Method.
    public void preOrder(int index)
    {
    	if(index > lastUsedIndex)
    	{
    		return;
    	}
    	System.out.print(binaryTree[index]+" ");
    	preOrder(index * 2);
    	preOrder(index * 2 + 1);
    }
    
    //PostOrder Method.
    public void postOrder(int index)
    {
    	if(index > lastUsedIndex)
    	{
    		return;
    	}
    	postOrder(index * 2);
    	postOrder(index * 2 + 1);
    	System.out.print(binaryTree[index]+" ");
    }
    
    //InOrder Method.
    public void inOrder(int index)
    {
    	if(index > lastUsedIndex)
    	{
    		return;
    	}
    	inOrder(index * 2);
    	System.out.print(binaryTree[index]+" ");
    	inOrder(index * 2 + 1);
    }
    
    // Level Order.
    public void levelOrder() 
    {
    	for(int i = 1; i <= lastUsedIndex; i++)
        {
        	System.out.print(binaryTree[i]+" ");
        }
    }
    
    // Search Method.
    public int search(String value)
    {
        if(lastUsedIndex == 0)
        {
            System.out.println("Tree is Null");
            return;
        }
        for(int i = 1; i < lastUsedIndex; i++)
        {
            if(binaryTree[i] == value)
            {
                System.out.println("Element Found : "+i);
                return i;
            }
        }
        System.out.println("Element Not Found");
        return -1;
    }
    
    // Insert Method.
    public void insert(String value)
    {
        if(lastUsedIndex == binaryTree.length - 1)
        {
            System.out.println("Tree is full");
            return;
        }
        lastUsedIndex++;
        binaryTree[lastUsedIndex] = value;
    }
    
    public void show()
    {
    	for(int i = 1; i <= lastUsedIndex; i++)
    	{
    		System.out.print(binaryTree[i]+" ");
    	}
    }
}
