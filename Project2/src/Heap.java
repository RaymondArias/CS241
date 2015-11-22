
/**
 * Class used to create heap
 * using sequential insertion method
 * @author Raymond Arias
 *
 */
import java.util.Arrays;

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
	/**
	 * Adds data to heap array if data is not already in array
	 * Once in heap the method reheapifies the heap upward.
	 * The method also keeps track of the number of swaps needed to
	 * reheapify heap and increments dataCount.
	 * @param element
	 */
	public void add(int element)
	{
		if(contains(element))
			return;
		heapArray[dataCount] = element;
		int i = dataCount;
		
		while(heapArray[i] > heapArray[(int) Math.floor((i - 1)/2)]) 	//While child [i] is larger than parent
		{
			//Swap child and parent values
			int temp = heapArray[i];	
			heapArray[i] = heapArray[(int) Math.floor((i - 1)/2)];
			heapArray[(int) Math.floor((i - 1)/2)] = temp;
			i = (int) Math.floor((i - 1)/2); //set i to new child and reiterate
			numberOfSwaps++;
		}
		dataCount++;
			
			
	}
	/**
	 * Returns the number of swaps needed to
	 * restore build heap
	 * @return
	 */
	public int getNumOfSwaps()
	{
		return numberOfSwaps;
	}
	/**
	 * Removes root of heap and reheapifies the heap
	 */
	public void remove()
	{
		int root = 0;
		heapArray[root] = heapArray[dataCount -1];
		heapArray[dataCount - 1] = -1;
		dataCount--;
		
		if(2 * root + 2 >= heapArray.length)
		{
			doubleArraySize();
		}
		while (heapArray[root] < heapArray[2 * root + 1] || heapArray[root] < heapArray[2 * root + 2])
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
			if(2 *root + 2 >= heapArray.length)
			{
				doubleArraySize();
			}
		}
	}
	/**
	 * Displays first ten values in heap
	 */
	public void displayFirstTen()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.print(heapArray[i] + ", ");
		}
		
	}
	/**
	 * Returns true if data is in heap;
	 * else returns false
	 * @param element
	 * @return
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
	/**
	 * Double array size, used to ensure
	 * index out of bound exception is not 
	 * thrown.
	 */
	public void doubleArraySize()
	{
		int []tempArray = heapArray;
		heapArray = Arrays.copyOf(tempArray, 2 * tempArray.length);
		tempArray = null;
	}
}
