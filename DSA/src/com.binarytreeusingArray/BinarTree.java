public class BinaryTree
{
    String binaryTree[];
    int lastUsedIndex = 0;

    public BinaryTree(int length)
    {
        binaryTree = new String[length + 1];
    }

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
}