package Threads;
//trang 662

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Dotty1 implements Runnable {

	private static int HREF = 50, VREF = 50, LEN = 300;
	private JPanel canvas;
	private int nDots;
	private int nDrawn;
	private int firstRed = 0;
	private boolean isClear = false;
	
	@Override
	public void run() {
		draw();
	}

	public Dotty1(JPanel canv, int dots)
	{
		canvas = canv;
		nDots = dots;
	}
	
	private void draw() 
	{
		Graphics g = canvas.getGraphics();
		
		for(nDrawn = 0; !isClear && nDrawn < nDots; nDrawn++)
		{
			int x = HREF + (int)(Math.random() * LEN);
			int y = VREF + (int)(Math.random() * LEN);
			
			g.fillOval(x, y, 3, 3);
			
			if(Math.random() < 0.001 && firstRed == 0)
			{
				g.setColor(Color.darkGray);
				firstRed = nDrawn;
			}
			
			try
			{
				Thread.sleep(1);
			}
			catch(InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void clear() 
	{
		isClear = true;
		Graphics g = canvas.getGraphics();
		g.setColor(canvas.getBackground());
		g.fillRect(HREF, VREF, LEN + 3, LEN + 3);
			
		System.out.print("\nNumber of drawn since first Red = " + (nDrawn	- firstRed));
	}

}
