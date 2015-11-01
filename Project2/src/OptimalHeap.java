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
		heapArray[dataCount] = element;
		dataCount++;
	}
	public void reheapifyUpward()
	{
		int i = dataCount;
		int parent = (int) Math.floor((i - 1) / 2);
		while(i > -1)
		{
			if(heapArray[parent] < heapArray[2 * parent + 1] || heapArray[parent] < heapArray[2 * parent + 2])
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
				}
				else
				{
					tempNum = heapArray[2 * parent + 2];
					heapArray[2 * parent + 2] = heapArray[parent];
					heapArray[parent] = tempNum;
					newRoot = 2 * parent + 1;
				}
				while(heapArray[newRoot] < heapArray[2 * newRoot + 1] ||
						heapArray[newRoot] < heapArray[2 * newRoot + 2])
				{
					if(heapArray[newRoot] < heapArray[2 * newRoot + 1] 
						&& heapArray[2 * newRoot + 1] > heapArray[2 * newRoot + 2])
					{
						
					}
				}
			}
			i = i - 2;
			parent = (int) Math.floor((i - 1) / 2);
		}
	}
	public void swapRoot(int newRoot)
	{
		if(heapArray[newRoot] < heapArray[])
	}
	public static void main(String []args)
	{
		OptimalHeap testHeap = new OptimalHeap();
		Random randInt = new Random();
		
		for(int i = 0; i < 10; i++)
		{
			testHeap.add(i);
		}
		testHeap.reheapifyUpward();
		System.out.println("Test");
		
	}

}
