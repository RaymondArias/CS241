import java.util.Scanner;

public class BinarySearchTree {
    private BSTNode root;
    
    public BinarySearchTree()
    {
        root = null;
    }
    
    /**
     * Adds an element to a binary search tree
     * @param element
     * @param node 
     */
    public void add (int element, BSTNode node)
    {
        BSTNode cursor = node;
        BSTNode newElement = new BSTNode(element, null, null);
       
        
        if(cursor == null)  //Tree is empty
        {
            root = newElement;
        }
        else if(cursor.getData() == element) //Data is already is BST
        {
            System.out.println(element + " already exists, ignore");
        }
        else
        {
            if(element < cursor.getData())
            {
                if(cursor.getLeft() == null)
                {
                    cursor.setLeft(newElement);
                    return;
                }
                else
                {
                    this.add(element, node.getLeft());
                }
            }
            else
            {
                if(cursor.getRight() == null)
                {
                    cursor.setRight(newElement);
                    return;
                }
                else
                {
                    this.add(element, node.getRight());
                }
              
            }
        }
    }
    /**
     * Recursively removes element from BST and returns true; else element 
     * is not found and method returns false
     * @param target
     * @param node
     * @param parent
     * @return 
     */
    public boolean remove(int target, BSTNode node, BSTNode parent)
    {
        BSTNode cursor = node;
        
        
        if(cursor == null) // Case 1: target not in tree
        {
            System.out.println(target + " doesn't exist!");
            return false;
        }
        if(cursor.getData() == target)
        {
            if(cursor.getLeft() == null)
            {
                if(cursor == root) //Case 2: target found at root with no left child
                {
                    root = root.getRight(); 
                    return true;
                }
            
                if(cursor == parent.getLeft()) //Case 3: target found with no left child
                {
                    parent.setLeft(cursor.getRight());
                }
            
                else
                {
                    parent.setRight(cursor.getRight());
                }
                return true;
            }
            else
            {
                cursor.setData(cursor.getLeft().getRightMostData());
                cursor.setLeft(cursor.getLeft().removeRightMost());
                return true;
            }
        
        }
        else if (target < cursor.getData())
        {
            parent = cursor;
            return this.remove(target, cursor.getLeft(), parent);
        }
        else
        {
            parent = cursor;
            return this.remove(target, cursor.getRight(), parent);
        }
        
    }
    /**
     * Returns root of BST
     * @return 
     */
    public BSTNode getRoot()
    {
        return root;
    }
    /**
     * Performs pre-order traversal and prints data from every node of
     * of the binary search tree
     * @param node 
     */
    public void preOrderTraversal(BSTNode node)
    {
        if(node == null)
        {
            System.out.println("Tree Empty");
            return;
        }
        System.out.print(node.getData() + " ");
        if(node.getLeft() != null)
            this.preOrderTraversal(node.getLeft());
        if(node.getRight() != null)
            this.preOrderTraversal(node.getRight());
    }
     /**
     * Performs in-order traversal and prints data from every node of
     * of the binary search tree
     * @param node 
     */
    public void inOrderTraversal(BSTNode node)
    {
        if(node == null)
        {
            System.out.println("Tree Empty");
            return;
        }
        if(node.getLeft() != null)
            this.inOrderTraversal(node.getLeft());
        System.out.print(node.getData() + " ");
        if(node.getRight() != null)
             this.inOrderTraversal(node.getRight());
    }
     /**
     * Performs post-order traversal and prints data from every node of
     * of the binary search tree
     * @param node 
     */
    public void postOrderTraversal(BSTNode node)
    {
        if(node == null)
        {
            System.out.println("Tree Empty");
            return;
        }
        if(node.getLeft() != null)
            this.postOrderTraversal(node.getLeft());
        if(node.getRight() != null)
            this.postOrderTraversal(node.getRight());
        System.out.print(node.getData() + " ");
    }
    /**
     * Returns predecessor of int value passed in
     * by recursively search through binary search tree.
     * @param value
     * @return 
     */
    public int getPredecessor(int value)
    {
        if(root == null)
            return -99; //tree is empty
        BSTNode node = getNode(value, root);
        if(node == null)
        {
            return -99; //value not found in tree
        }
        if(node.getLeft() != null)
            return node.getLeft().getRightMostData();
        else
        {
            BSTNode parent = getParent(node, null, root);
            if(parent == null)
                return -99;
            BSTNode grandParent = getParent(parent, null, root);
            if(grandParent == null)
                return -99;
            if(node == parent.getRight())
                return parent.getData();
            while(parent != grandParent.getRight())
            {
                parent = grandParent;
                grandParent = getParent(parent, null, root);
                if(grandParent == null)
                    return -99; //value is the smallest value
            }
            
            return grandParent.getData();
            
               
        }
    }
    /**
     * Returns successor of int value passed in
     * by recursively search through binary search tree.
     * @param value
     * @return 
     */
    public int getSucessor(int value)
    {
         if(root == null)
            return -99; //tree is empty
        BSTNode node = getNode(value, root);
        if(node == null)
        {
            return -99; //value not found in tree
        }
        if(node.getRight() != null)
            return node.getRight().getLeftMostData();
         else
        {
            BSTNode parent = getParent(node, null, root);
            if(parent == null)
                return -99;
            BSTNode grandParent = getParent(parent, null, root);
            if(node == parent.getLeft())
                return parent.getData();
            while(parent != grandParent.getLeft())
            {
                parent = grandParent;
                grandParent = getParent(parent, null, root);
                if(grandParent == null)
                    return -99; //value is the smallest value
            }
            
            return grandParent.getData();
            
               
        }
    }
    /**
     * Returns node with data matching value passed
     * @param value
     * @param node
     * @return 
     */
    public BSTNode getNode(int value, BSTNode node)
    {
        
        if(node == null)
        {
            return null;
        }
        else if(value == node.getData())
        {
            return node;
        }
        else if(value < node.getData())
        {
            return this.getNode(value, node.getLeft());
        }
        else if(value > node.getData())
        {
            return this.getNode(value, node.getRight());
        }
        return null;
    }
    /**
     * Returns parents of node 
     * @param node
     * @param parentNode
     * @param traverseNode
     * @return 
     */
    public BSTNode getParent(BSTNode node, BSTNode parentNode, BSTNode traverseNode)
    {
        if(traverseNode.getData() == node.getData())
            return parentNode;
        if(node.getData() < traverseNode.getData())
        {
            parentNode = traverseNode;
            return this.getParent(node, parentNode, traverseNode.getLeft());
        }
        else
        {
            parentNode = traverseNode;
            return this.getParent(node, parentNode, traverseNode.getRight());
        }
    }
    /**
     * Display commands that can be ran
     */
    public void showMenu()
    {
         System.out.println("I Insert a value");
         System.out.println("D Delete a value");
         System.out.println("P Find predessor");
         System.out.println("S Find successor");
         System.out.println("E Exit the program");
         System.out.println("H Display this message");
    }
    /**
     * returns the number representation of the user's input
     * @param regString
     * @return 
     */
    public String stringTokenizer(String regString)
    {
        return regString.substring(2, regString.length());
    }
            
        
}
