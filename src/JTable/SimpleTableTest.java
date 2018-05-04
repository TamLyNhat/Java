package JTable;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTable;

public class SimpleTableTest extends JFrame {

	private JTable table;
	
	public static void main(String[] args) {
		SimpleTableTest stt = new SimpleTableTest();
		stt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stt.setSize(400,200);
		stt.setVisible(true);
	}

	public SimpleTableTest()
	{
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		TableValues tv = new TableValues();
		table = new JTable(tv);
		pane.add(table,BorderLayout.CENTER);
	}
}
