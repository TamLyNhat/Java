package JTable;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class SimpleTableTest1 extends JFrame {

	private JTable table;
	
	public static void main(String[] args)
	{
		SimpleTableTest stt = new SimpleTableTest();
		stt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stt.setSize(400,200);
		stt.setVisible(true);

	}
	
	public SimpleTableTest1()
	{
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		TableValues tv = new TableValues();
		table = new JTable(tv);
		TableColumnModel tcm = table.getColumnModel();
		TableColumn tc = tcm.getColumn(TableValues.GENDER);
		tc.setCellRenderer( new GenderRenderer());
		JScrollPane jsp = new JScrollPane(table);
		pane.add(jsp,BorderLayout.CENTER);
	}

}
