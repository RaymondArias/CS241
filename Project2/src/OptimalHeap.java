/**
 * This class creates a heap
 * using the optimal method;
 * @author Raymond Arias
 *
 */
import java.util.Arrays;

public class OptimalHeap {
	private int []heapArray; 	//Array that holds heap
	private int dataCount;		//Number of data held in heap
	private int numberOfSwaps;	//Number of swaps required to build heap
	
	public OptimalHeap()
	{
		heapArray = new int[100];
		Arrays.fill(heapArray, -1);
		dataCount = 0;
		numberOfSwaps = 0;
	}
	/**
	 * Adds data to heap, if data is 
	 * currently not in heap
	 * @param element
	 */
	public void add(int element)
	{
		if(contains(element))
			return;
		heapArray[dataCount] = element;
		dataCount++;
	}
	/**
	 * Builds heap using the optimal method, reheapify upward.
	 * Also, keeps track of swaps needed
	 * 
	 */
	public void reheapifyUpward()
	{
		int i = dataCount - 1;
		int parent = (int) Math.floor((i - 1) / 2);
		while(i > -1)
		{
			//Double array size if the child node is out of bounds
			if(2 * parent + 2 >= heapArray.length)
			{
				doubleArraySize();
				
			}
			//If either child is greater than the parent
			if(heapArray[parent] < heapArray[2 * parent + 1] || heapArray[parent] < heapArray[2 * parent + 2])
			{
				int tempNum;
				int newRoot;
				//If the left child is larger than parent and right child
				//swap with left child
				if(heapArray[parent] < heapArray[2 * parent + 1] 
						&& heapArray[2 * parent + 1] > heapArray[2 * parent + 2])
				{
					tempNum = heapArray[2 * parent + 1];
					heapArray[2 * parent + 1] = heapArray[parent];
					heapArray[parent] = tempNum;
					newRoot = 2 * parent + 1;
					numberOfSwaps ++;
				}
				//Swap with right child
				else
				{
					tempNum = heapArray[2 * parent + 2];
					heapArray[2 * parent + 2] = heapArray[parent];
					heapArray[parent] = tempNum;
					newRoot = 2 * parent + 2;
					numberOfSwaps ++;
				}
				swapRoot(newRoot);
				
			}
			i = i - 2;
			parent = (int) Math.floor((i - 1) / 2);
		}
	}
	/**
	 * Used to swap child and parent node data,
	 * method also keeps track of swaps
	 * @param newRoot
	 */
	public void swapRoot(int newRoot)
	{
		if(2 * newRoot + 2  > dataCount - 1)
			return;
		while (heapArray[newRoot] < heapArray[2 * newRoot + 1] || heapArray[newRoot] < heapArray[2 * newRoot + 2])
		{
			
			//left child is larger so swap heapArray[newRoot] and left child
			if(heapArray[2 * newRoot + 1] > heapArray[2 * newRoot + 2])
			{
				int tempNum = heapArray[2 * newRoot + 1];
				heapArray[2 * newRoot + 1] = heapArray[newRoot];
				heapArray[newRoot] = tempNum;
				newRoot = 2 * newRoot + 1;
				numberOfSwaps ++;
			}
			//Right child is larger so swap heapArray[newRoot] with right child
			else
			{
				int tempNum = heapArray[2 * newRoot + 2];
				heapArray[2 * newRoot + 2] = heapArray[newRoot];
				heapArray[newRoot] = tempNum;
				newRoot = 2 * newRoot + 2;
				numberOfSwaps ++;
				
			}
			
			if(2 * newRoot + 2 >= heapArray.length)
			{
				doubleArraySize();
			}
		}
	}
	/**
	 * Return number of swaps needed
	 * to build heap
	 * @return
	 */
	public int getNumOfSwaps()
	{
		return numberOfSwaps;
	}
	/**
	 * Boolean method which returns true
	 * if data is in heap; else it returns false
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
	 * Removes root from heap and reheapifies heap
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
			if(2 * root + 2 >= heapArray.length)
			{
				doubleArraySize();
			}
		}
	}
	/**
	 * Doubles array size, used to
	 * verify array index out of bounds exception
	 * is not thrown
	 */
	private void doubleArraySize()
	{
		int []tempArray = heapArray;
		heapArray = Arrays.copyOf(tempArray, 2 * tempArray.length);
		tempArray = null;
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


}
