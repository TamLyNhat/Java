package Threads;
//trang 659

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Dotty {

	private static int HREF = 50, VREF = 50, LEN = 300;
	private JPanel canvas;
	private int nDots;
	private int nDrawn;
	private int firstRed = 0;
	
	public Dotty(JPanel canv, int dots)
	{
		canvas = canv;
		nDots = dots;
	}
	
	public void draw() {
		Graphics g = canvas.getGraphics();
	
		for(nDrawn = 0; nDrawn < nDots; nDrawn++)
		{
			int x = HREF 	+ (int)(Math.random() * LEN);
			int y = VREF 	+ (int)(Math.random() * LEN);
			
			g.fillOval(x, y, 3, 3);
			
			if(Math.random() < 0.001 && firstRed == 0)
			{
				g.setColor(Color.darkGray);
				firstRed = nDrawn;
			}
		}
	}

	public void clear() {
		Graphics g = canvas.getGraphics();
		g.setColor(canvas.getBackground());
		g.fillRect(HREF, VREF, LEN + 3, LEN + 3);
			
		System.out.print("\nNumber of drawn since first Red = " + (nDrawn	- firstRed));
	}
}
