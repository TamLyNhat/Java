package Threads;

public class Consumer extends Thread
{
	private int n;
	private Buffer buf;
	
	public Consumer(int m, Buffer buf)
	{
		this.n = m;
		this.buf = buf;
	}
	
	public void run()
	{
		int value;
		for(int i = 0; i < n; i++)
		{
			try
			{
				value = buf.get();
			}catch(InterruptedException e)
			{
				return;
			}
			
			try
			{
				Thread.sleep((int)Math.random() * 100);
			}catch(InterruptedException e)
			{
				return;
			}
		}
	}
}
