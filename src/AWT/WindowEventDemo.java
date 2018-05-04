package AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventDemo extends Frame implements ActionListener,
		WindowListener {

	private TextField tfcount;
	private Button btncount;
	private int count = 0;
	
	public WindowEventDemo()
	{
		setLayout(new FlowLayout());
		
		add(new Label("Counter"));
		
		tfcount = new TextField("0",10);
		tfcount.setEditable(false);
		add(tfcount);

		btncount = new Button("Count");
		add(btncount);
		
		btncount.addActionListener(this);
		// btnCount (source object) fires ActionEvent upon clicking
		// btnCount adds "this" object as an ActionEvent listener

		addWindowListener(this);
		setTitle("WindowEvent demo:");
		setSize(350, 250);
		setVisible(true);
	}
	
	public void windowActivated(WindowEvent arg0) {

	}

	public void windowClosed(WindowEvent arg0) {

	}

	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	public void windowDeactivated(WindowEvent arg0) {

	}

	public void windowDeiconified(WindowEvent arg0) {

	}

	public void windowIconified(WindowEvent arg0) {

	}

	public void windowOpened(WindowEvent arg0) {

	}

	
	public void actionPerformed(ActionEvent arg0) {
		++count;
		tfcount.setText(count + "");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new WindowEventDemo();

	}

}
