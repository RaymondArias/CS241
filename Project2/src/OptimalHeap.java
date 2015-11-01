import java.util.Arrays;
import java.util.Random;

public class OptimalHeap {
	private int []heapArray;
	private int dataCount;
	private int numberOfSwaps;
	
	public OptimalHeap()
	{
		heapArray = new int[100];
		Arrays.fill(heapArray, -1);
		dataCount = 0;
		numberOfSwaps = 0;
	}
	public void add(int element)
	{
		if(contains(element))
			return;
		heapArray[dataCount] = element;
		dataCount++;
	}
	public void reheapifyUpward()
	{
		int i = dataCount - 1;
		int parent = (int) Math.floor((i - 1) / 2);
		while(i > -1)
		{
			if(2 * parent + 2 > dataCount - 1)
			{
				if(heapArray[parent] < heapArray[2 * parent + 1])
				{
					int tempNum;
					int newRoot;
					if(heapArray[parent] < heapArray[2 * parent + 1])
					{
						tempNum = heapArray[2 * parent + 1];
						heapArray[2 * parent + 1] = heapArray[parent];
						heapArray[parent] = tempNum;
						newRoot = 2 * parent + 1;
						numberOfSwaps ++;
						swapRoot(newRoot);
					}
					
				}
				
			}
			else if(heapArray[parent] < heapArray[2 * parent + 1] || heapArray[parent] < heapArray[2 * parent + 2])
			{
				int tempNum;
				int newRoot;
				if(heapArray[parent] < heapArray[2 * parent + 1] 
						&& heapArray[2 * parent + 1] > heapArray[2 * parent + 2])
				{
					tempNum = heapArray[2 * parent + 1];
					heapArray[2 * parent + 1] = heapArray[parent];
					heapArray[parent] = tempNum;
					newRoot = 2 * parent + 1;
					numberOfSwaps ++;
				}
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
			}
			//Right child is larger so swap heapArray[newRoot] with right child
			else
			{
				int tempNum = heapArray[2 * newRoot + 2];
				heapArray[2 * newRoot + 2] = heapArray[newRoot];
				heapArray[newRoot] = tempNum;
				newRoot = 2 * newRoot + 2;
				
			}
			numberOfSwaps ++;
			if(2 * newRoot + 2 > dataCount - 1)
				return;
		}
	}
	public int getNumOfSwaps()
	{
		return numberOfSwaps;
	}
	public boolean contains(int element)
	{
		for (int i = 0; i < dataCount; i++)
		{
			if (heapArray[i] == element)
				return true;
		}
		return false;
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

}
