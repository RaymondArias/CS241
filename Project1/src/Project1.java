
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        BinarySearchTree bsTree = new BinarySearchTree();
        Scanner keyboardInput = new Scanner(System.in);
        String usersChoice = null;
        String userInput = null;
        String []tokenizedStr = null; 
        
        System.out.println("Please enter initial sequence of characters: ");
        userInput = keyboardInput.nextLine();
        tokenizedStr = userInput.split(" ");
        for(int i = 0; i < tokenizedStr.length; i++)
        {
            bsTree.add(Integer.parseInt(tokenizedStr[i]), bsTree.getRoot());
        }
        

        System.out.print("Pre-order: ");
        bsTree.preOrderTraversal(bsTree.getRoot());
        System.out.print("\nIn-order: ");
        bsTree.inOrderTraversal(bsTree.getRoot());
        System.out.print("\nPost-order: ");
        bsTree.postOrderTraversal(bsTree.getRoot());

        while (true) {
            System.out.print("\nCommand? ");
            usersChoice = keyboardInput.nextLine();
            
           
            if(usersChoice.length() == 0)
            {
                //No command entered. Simply reloop
            }
            else if (usersChoice.charAt(0) == 'I') 
            {
                //Insert a value
                int userNum = Integer.parseInt(bsTree.stringTokenizer(usersChoice));
                bsTree.add(userNum, bsTree.getRoot());
                System.out.print("In-Order: ");
                bsTree.inOrderTraversal(bsTree.getRoot());
            } 
            else if (usersChoice.charAt(0) == 'D')
            {
                //Delete a value
                int userNum = Integer.parseInt(bsTree.stringTokenizer(usersChoice));
                bsTree.remove(userNum, bsTree.getRoot(), null);
                System.out.print("In-Order: ");
                bsTree.inOrderTraversal(bsTree.getRoot());
            } 
            else if (usersChoice.charAt(0) == 'P') 
            {
                //find prodessor
                int userNum = Integer.parseInt(bsTree.stringTokenizer(usersChoice));
                int predessor = bsTree.getPredecessor(userNum);
                if (predessor == -99)
                {
                    System.out.println("Error: " + userNum + " is either not in list or does not have predessor");
                }
                else 
                {
                    System.out.print(bsTree.getPredecessor(userNum));
                }

            } 
            else if (usersChoice.charAt(0) == 'S')
            {
                //find sucessor
                int userNum = Integer.parseInt(bsTree.stringTokenizer(usersChoice));
                int sucessor = bsTree.getSucessor(userNum);
                if (sucessor == -99)
                {
                    System.out.println("Error: " + userNum + " is either not in list or does not have sucessor");
                } 
                else
                {
                    System.out.print(sucessor);
                }
            } 
            else if (usersChoice.charAt(0) == 'E') 
            {
                //exit program
                System.out.println("Thank you for using my program");
                break;
            } 
            else if (usersChoice.charAt(0) == 'H') {
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


