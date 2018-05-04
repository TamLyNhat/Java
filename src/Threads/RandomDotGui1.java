package Threads;
//trang 663 

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomDotGui1 extends JFrame implements ActionListener {

	public final int NDOTS = 10000;
	private Dotty1 dotty;
	private JPanel controls = new JPanel();
	private JPanel canvas = new JPanel();
	private JButton draw = new JButton("Draw");
	private JButton clear = new JButton("Clear");
	
	public RandomDotGui1()
	{
		getContentPane().setLayout(new BorderLayout());
		draw.addActionListener(this);
		clear.addActionListener(this);
		controls.add(draw);
		controls.add(clear);
		canvas.setBorder(BorderFactory.createTitledBorder("Drawing canvas"));
		getContentPane().add("North", controls);
		getContentPane().add("Center", canvas);
		getContentPane().setSize(600, 600);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == draw)
		{
			dotty = new Dotty1(canvas,NDOTS);
			Thread dottyThread = new Thread(dotty);
			dottyThread.start();
		}
		else
		{
			dotty.clear();
		}
	}

	public static void main(String[] args) {
		RandomDotGui1 gui = new RandomDotGui1();
		gui.setSize(400,500);
		gui.setVisible(true);
	}

}
