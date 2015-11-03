/**
 * Main class for program.
 * Gives users two options
 * Choice 1: Build 20 heap using both methods with 
 * randomly generated values and compare average number of
 * swaps need to build heaps
 * Choice 2: Build a heap using both methods, output first ten values,compare number of swaps
 * needed, delete 10 values, and output new first ten values
 */


import java.util.*;

public class Project2 {
	public Project2(){}
	
	/**
	 * Menu for program, which ask user to choose between 
	 * two options
	 */
	public void menu()
	{
		int choice;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please select how to test the program:");
		System.out.println("(1) 20 sets of 100 randomly generated integers");
		System.out.println("(2) Fixed integer values 1-100");
		System.out.print("Enter choice: ");
		choice = userInput.nextInt();
		
		if(choice == 1)
		{
			//20 sets of randomly generated test
			randomSetAverage();
		}
		else if (choice == 2)
		{
			//Fixed Integers
			fixedValueInsertion();
		}
		else
		{
			//error state
			System.out.println("Error");
		}
		
	}
	/**
	 * Choice one: build 20 randomly generated heaps
	 * with both methods and compare the average number of swaps
	 */
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
	/**
	 * Choice 2: Build a heap using both methods, output first ten values,compare number of swaps
	 * needed, delete 10 values, and output new first ten values
	 */
	public void fixedValueInsertion()
	{
		Heap seqHeap = new Heap();
		OptimalHeap optHeap = new OptimalHeap();
		for(int i = 0; i < 100; i++)
		{
			seqHeap.add(i + 1);
			optHeap.add(i + 1);
		}
		System.out.print("Heap built using series of insertions: " );
		seqHeap.displayFirstTen();
		System.out.println("...\nNumber of swaps: " +seqHeap.getNumOfSwaps());
		System.out.print("Heap after 10 removals: ");
		for(int i = 0; i < 10; i++)
		{
			seqHeap.remove();
		}
		seqHeap.displayFirstTen();
		
		optHeap.reheapifyUpward();		
		System.out.println();
		System.out.print("\nHeap built using optimal method: ");
		optHeap.displayFirstTen();
		System.out.println("\nNumber of swaps: " + optHeap.getNumOfSwaps());
		for(int i = 0; i < 10; i++)
		{
			optHeap.remove();
		}
		System.out.print("Heap after 10 removals: ");
		optHeap.displayFirstTen();
		
	}

	public static void main(String[] args) {
		Project2 output = new Project2();
		output.menu();
		
	}

}
