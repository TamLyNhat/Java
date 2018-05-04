package Threads;
//trang 1061

public class ArrayWriter2 implements Runnable 
{
	private final SimpleArray2 sharedSimpleArray;
	private final int startValue;
	
	public ArrayWriter2(int value,SimpleArray2 array)
	{
		startValue = value;
		sharedSimpleArray = array;
	}
	
	@Override
	public void run() 
	{
		for(int i = startValue; i < startValue + 3; i++)
		{
			sharedSimpleArray.add(i);
		}
	}
}
