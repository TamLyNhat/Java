package Threads;

public class ConsumerProducerGood 
{
	public static void main(String[] args) 
	{
		Buffer b = new Buffer();

		Thread prod = new Producer(10,b);
		Thread cons = new Consumer(10,b);
		
		prod.start();
		cons.start();
		
		try
		{
			prod.join();
			cons.join();
		}catch(InterruptedException e)
		{
			return;
		}
	}

}
