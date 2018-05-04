package AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTCounter extends Frame implements ActionListener {

	private Label lbcount;
	private TextField tfcount;
	private Button btncount;
	private int count = 0;
	
	public AWTCounter()
	{
	    setLayout(new FlowLayout());
		lbcount = new Label("Counter");
		add(lbcount);
		
		tfcount = new TextField("0",10);
		tfcount.setEditable(false);
		add(tfcount);
		
		btncount = new Button("Count");
		add(btncount);
		
		btncount.addActionListener(this);
		
		setTitle("AWT Counter");
		setSize(250, 100);
		setVisible(true);
		System.out.println(this);
		System.out.println(lbcount);
		System.out.println(tfcount);
		System.out.println(btncount);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		++count;
		tfcount.setText(count + "");
	}

	public static void main(String[] args) {
		AWTCounter app = new AWTCounter();
	}

}
