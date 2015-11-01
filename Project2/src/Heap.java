import java.util.Arrays;
import java.util.Random;

/**
 * Classed used to create heap
 * using sequential insertion method
 * @author raymond
 *
 */
public class Heap {
	private int [] heapArray;	//Array that holds the heap
	private int numberOfSwaps;	//Number of swaps required to create heap
	private int dataCount;		//data currently in heap array
	
	public Heap()
	{
		heapArray = new int[100];
		Arrays.fill(heapArray, -1);
		numberOfSwaps = 0;
		dataCount = 0;
	}
	public void add(int element)
	{
		if(contains(element))
			return;
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
	public int getNumOfSwaps()
	{
		return numberOfSwaps;
	}
	public void remove()
	{
		int root = 0;
		heapArray[root] = heapArray[dataCount -1];
		heapArray[dataCount - 1] = -1;
		dataCount--;
		while (heapArray[root] < heapArray[2 * root + 1] || heapArray[root] < heapArray[2 * root + 1])
		{
			//left child is larger so swap heapArray[newRoot] and left child
			if(heapArray[2 * root + 1] > heapArray[2 * root + 2])
			{
				int tempNum = heapArray[2 * root + 1];
				heapArray[2 * root + 1] = heapArray[root];
				heapArray[root] = tempNum;
				root = 2 * root + 1;
			}
			//Right child is larger so swap heapArray[newRoot] with right child
			else
			{
				int tempNum = heapArray[2 * root + 2];
				heapArray[2 * root + 2] = heapArray[root];
				heapArray[root] = tempNum;
				root = 2 * root + 2;
				
			}
		}
	}
	/*public static void main(String []args)
	{
		OptimalHeap testHeap = new OptimalHeap();
		Heap seqHeap = new Heap();
		Random randInt = new Random();
		
		for(int i = 0; i < 10; i++)
		{
			seqHeap.add(i+1);
			testHeap.add(i+1);
		}
		testHeap.reheapifyUpward();
		System.out.println("Test");
		
	}
*/
	public boolean contains(int element)
	{
		for (int i = 0; i < dataCount; i++)
		{
			if (heapArray[i] == element)
				return true;
		}
		return false;
	}
}
