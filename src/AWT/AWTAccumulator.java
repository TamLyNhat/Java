package AWT;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*; 

public class AWTAccumulator extends Frame implements ActionListener {

	private static final LayoutManager FlowLayout = null;
	private Label lbinput;
	private Label lboutput;
	private TextField tfinput;
	private TextField tfoutput;
	private int sum = 0;
	
	public AWTAccumulator()
	{
		setLayout(new FlowLayout());
		
		lbinput = new Label("Enter an Interger: ");
		add(lbinput);
		
		tfinput = new TextField(10);
		add(tfinput);
		
		tfinput.addActionListener(this);
		
		lboutput = new Label("The Accumelated sum, is: ");
		add(lboutput);
		
		tfoutput = new TextField(10);
		tfoutput.setEditable(false);
		add(tfoutput);
		
		setTitle("AWT Accumulated");
		setSize(350,120);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		int number = Integer.parseInt(tfinput.getText());
		sum += number;
		tfinput.setText("");
		tfoutput.setText(sum + "");
	}

	public static void main(String[] args) {
		new AWTAccumulator();

	}

}
