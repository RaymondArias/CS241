import java.util.Random;

/**
 * Classed used to create heap
 * using sequential insertion method
 * @author raymond
 *
 */
public class Heap {
	int [] heapArray;	//Array that holds the heap
	int numberOfSwaps;	//Number of swaps required to create heap
	int dataCount;		//data currently in heap array
	
	public Heap()
	{
		heapArray = new int[100];
		numberOfSwaps = 0;
		dataCount = 0;
	}
	public void add(int element)
	{
		heapArray[dataCount] = element;
		int i = dataCount;
		
		while(heapArray[i] > heapArray[(int) Math.floor((i - 1)/2)])
		{
			int temp = heapArray[i];
			heapArray[i] = heapArray[(int) Math.floor((i - 1)/2)];
			heapArray[(int) Math.floor((i - 1)/2)] = temp;
			i = (int) Math.floor((i - 1)/2);
			numberOfSwaps++;
		}
		dataCount++;
			
			
	}
	public static void main(String []args)
	{
		Heap testHeap = new Heap();
		Heap secondHeap = new Heap();
		Random randInt = new Random();
		
		for(int i = 0; i < 100; i++)
		{
			testHeap.add(randInt.nextInt(100));
			secondHeap.add(i);
		}
		
		System.out.println("Test");
		
	}

}
