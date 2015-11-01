import java.util.*;

public class Project2 {
	public Project2(){}
	public void menu()
	{
		int choice;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please select how to test the program:");
		System.out.println("(1) 20 sets of 100 randomly generated integers");
		System.out.println("(2) Fixed integer values 1-100");
		System.out.println("Enter choice:");
		choice = userInput.nextInt();
		
		if(choice == 1)
		{
			//20 sets of randomly generated test
			randomSetAverage();
		}
		else if (choice == 2)
		{
			//Fixed Integers
		}
		else
		{
			//error state
		}
		
	}
	public void randomSetAverage()
	{
		double seqHeapAverage = 0.0;
		double optHeapAverage = 0.0;
		Random randInt = new Random();
		
		for(int i = 0; i < 20; i ++)
		{
			Heap seqHeap = new Heap();
			OptimalHeap optHeap = new OptimalHeap();
			for(int j = 0; j < 100; j++)
			{
				int num = 1 + randInt.nextInt(100);
				
				while(seqHeap.contains(num))
				{
					num = 1 + randInt.nextInt(100);
				}
				seqHeap.add(num);
				optHeap.add(num);
			}
			optHeap.reheapifyUpward();
			seqHeapAverage += (double)seqHeap.getNumOfSwaps();
			optHeapAverage += (double)optHeap.getNumOfSwaps();
			
		}
		System.out.println("Average swaps for series of insertions: "+ seqHeapAverage/20);
		System.out.println("Average swaps for optimal method: "+ optHeapAverage/20);
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project2 output = new Project2();
		output.menu();
		
	}

}
