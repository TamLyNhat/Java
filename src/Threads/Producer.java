package Threads;

public class Producer extends Thread
{
	private int n;
	private Buffer buf;
	
	public Producer(int m, Buffer buf)
	{
		this.n = m;
		this.buf = buf;
	}
	
	public void run()
	{
		for(int i = 0; i < n; i++)
		{
			try
			{
				Thread.sleep((int)Math.random() * 100);
			}catch(InterruptedException e)
			{
				return;
			}
			
			try
			{
				buf.put(i+1);
			}catch(InterruptedException e)
			{
				return;
			}
		}
	}
}
