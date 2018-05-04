package Threads;
//trang 1061

import java.util.Arrays;
import java.util.Random;

public class SimpleArray2
{
	private final int[] array;
	private int writeIndex = 0;
	private final static Random generator = new Random();
	
	public SimpleArray2(int size)
	{
		array = new int[size];
	}
	
	public synchronized void add(int value)
	{
		int position = writeIndex;
		
		try
		{
			Thread.sleep(generator.nextInt(500));
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
		array[position] = value;
		System.out.printf("%s wrote %2d to element %d\n",Thread.currentThread().getName(),value,position);
		
		++writeIndex;
		System.out.printf("Next write index: %d\n",writeIndex);
	}
	
	public String toString()
	{
		return "\nContent of SimpleArray: \n" + Arrays.toString(array);
	}
	
}
