
import java.util.Scanner;


public class Project1 {
    public static void main (String []args)
    {
        BinarySearchTree bsTree = new BinarySearchTree();
        Scanner keyboardInput = new Scanner(System.in);
        String usersChoice = null;
        /*bsTree.add(51, bsTree.getRoot());
        bsTree.add(29, bsTree.getRoot());
        bsTree.add(68, bsTree.getRoot());
        bsTree.add(90, bsTree.getRoot());
        bsTree.add(36, bsTree.getRoot());
        bsTree.add(40, bsTree.getRoot());
        bsTree.add(22, bsTree.getRoot());
        bsTree.add(59, bsTree.getRoot());
        bsTree.add(44, bsTree.getRoot());
        bsTree.add(99, bsTree.getRoot());
        bsTree.add(1, bsTree.getRoot());
        bsTree.add(77, bsTree.getRoot());
        bsTree.add(60, bsTree.getRoot());
        bsTree.add(27, bsTree.getRoot());
        bsTree.add(83, bsTree.getRoot());
        bsTree.add(15, bsTree.getRoot());
        bsTree.add(75, bsTree.getRoot());
        bsTree.add(3, bsTree.getRoot());
        */ 
        
        bsTree.add(60000, bsTree.getRoot());
        bsTree.add(1, bsTree.getRoot());
        bsTree.add(2, bsTree.getRoot());
        bsTree.add(3, bsTree.getRoot());
        bsTree.add(4, bsTree.getRoot());
        bsTree.add(5, bsTree.getRoot());
        bsTree.add(60, bsTree.getRoot());
        bsTree.add(600, bsTree.getRoot());
        bsTree.add(6000, bsTree.getRoot());
        bsTree.add(60000, bsTree.getRoot());
        
        
        System.out.print("Pre-order: ");
        bsTree.preOrderTraversal(bsTree.getRoot());
         System.out.print("\nIn-order: ");
        bsTree.inOrderTraversal(bsTree.getRoot());
         System.out.print("\nPost-order: ");
        bsTree.postOrderTraversal(bsTree.getRoot());
        
        while(true)
        {
            System.out.print("\nCommand? ");
            usersChoice = keyboardInput.nextLine();
            
            if(usersChoice.charAt(0) == 'I')
            {
                //Insert a value
                int userNum = Integer.parseInt(bsTree.stringTokenizer(usersChoice));
                bsTree.add(userNum, bsTree.getRoot());
                System.out.print("In-Order: ");
                bsTree.inOrderTraversal(bsTree.getRoot());
            }
            else if(usersChoice.charAt(0) == 'D')
            {
                //Delete a value
                int userNum = Integer.parseInt(bsTree.stringTokenizer(usersChoice));
                bsTree.remove(userNum, bsTree.getRoot(), null);
                System.out.print("In-Order: ");
                bsTree.inOrderTraversal(bsTree.getRoot());
            }
            else if(usersChoice.charAt(0) == 'P')
            {
                //find prodessor
                int userNum = Integer.parseInt(bsTree.stringTokenizer(usersChoice));
                int predessor = bsTree.getPredecessor(userNum);
                if(predessor == -99)
                {
                    System.out.println("Error: " + userNum +" is either not in list or does not have predessor");
                }
                else
                {
                    System.out.println(bsTree.getPredecessor(userNum));
                }
                
            }
            else if(usersChoice.charAt(0) == 'S')
            {
                //find sucessor
                int userNum = Integer.parseInt(bsTree.stringTokenizer(usersChoice));
                int sucessor = bsTree.getSucessor(userNum);
                if(sucessor == -99)
                {
                    System.out.println("Error: " + userNum +" is either not in list or does not have sucessor");
                }
                else
                {
                    System.out.println(sucessor);
                }
            }
            else if(usersChoice.charAt(0) == 'E')
            {
                //exit program
                System.out.println("Thank you for using my project");
                break;
            }
            else if(usersChoice.charAt(0) == 'H')
            {
                //Display menu
                bsTree.showMenu();
            }
            else
            {
                //Error message
                System.out.println("Error: Command not found");
                System.out.println("Type H for list of commands");
            }
            
        }
    }
        
}
