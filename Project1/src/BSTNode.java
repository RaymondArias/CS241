
public class BSTNode 
{
    private int data;         //Holds data at this node
    private BSTNode left;     //Reference to node's left
    private BSTNode right;    //Reference to node's right
    
    public BSTNode(int data, BSTNode left, BSTNode right)
    {
     this.data = data;
     this.left = left;
     this.right = right;
    }
    /**
     * Returns data held at this node
     * @return 
     */
    public int getData()
    {
        return data;
    }
    
   
    /**
     * Returns this node's left reference
     * @return 
     */
    public BSTNode getLeft()
    {
        return left;
    }
    /**
     * Returns this node's right reference
     * @return 
     */
    public BSTNode getRight()
    {
        return right;
    }
    /**
     * Assigns data at node with data passed in
     * @param data 
     */
    public void setData(int data)
    {
        this.data = data;
    }
    /**
     * Assigns left reference with reference passed in
     * @param left 
     */
    public void setLeft(BSTNode left)
    {
        this.left = left;
    }
    /**
     * Assigns right reference with reference passed in
     * @param right 
     */
    public void setRight(BSTNode right)
    {
        this.right = right;
    }
    /**
     * Returns left more data in tree/subtree
     * @return 
     */

    public int getLeftMostData()
    {
        if(this.left == null)
            return data;
        return getLeft().getLeftMostData();
    }
    /**
     * Return right most data in tree/subtree
     * @return 
     */
    public int getRightMostData()
    {
        if(this.right == null)
            return data;
        return getRight().getRightMostData();
    }
    /**
     * Removes left most node in tree/subtree
     * @return 
     */
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
    /**
     * Removes right most node in tree/subtree
     * @return 
     */
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
