
public class BSTNode 
{
    private int data;
    private BSTNode left;
    private BSTNode right;
    
    public BSTNode(int data, BSTNode left, BSTNode right)
    {
     this.data = data;
     this.left = left;
     this.right = right;
    }
    
    public int getData()
    {
        return data;
    }
    public BSTNode getLeft()
    {
        return left;
    }
    public BSTNode getRight()
    {
        return right;
    }
    public void setData(int data)
    {
        this.data = data;
    }
    public void setLeft(BSTNode left)
    {
        this.left = left;
    }
    public void setRight(BSTNode right)
    {
        this.right = right;
    }

    public int getLeftMostData()
    {
        if(this.left == null)
            return data;
        return getLeft().getLeftMostData();
    }
    public int getRightMostData()
    {
        if(this.right == null)
            return data;
        return getRight().getRightMostData();
    }
    public BSTNode removeLeftMost()
    {
        if (left == null)
            return right;
        else
        {
            left = left.removeLeftMost();
            return this;
        }
    }
    public BSTNode removeRightMost()
    {
        if (right == null)
            return left;
        else
        {
            right = right.removeRightMost();
            return this;
        }
    }    
}
