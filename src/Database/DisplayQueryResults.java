package Database;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//trang 1201, sach JH2P

public class DisplayQueryResults extends JFrame {

	/**
	 * @param args
	 */
	
	// database URL, username and password
	static final String DATABASE_URL = "jdbc:mysql://localhost/books";
	static final String USERNAME = "root";
	static final String PASSWORD = "12345";
	
	static final String DEFAULT_QUERY = "SELECT * FROM Authors";
	private ResultSetTableModel tableModel;
	private JTextArea queryArea;
	
	// create ResultSetTableModel and GUI
	public DisplayQueryResults()
	{
		super("Display Query Result");
		
		// create ResultSetTableModel and display database table
		try
		{
			// create TableModel for results of query SELECT * FROM Authors
			tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
			
			// set up JTextArea in which user types queries
			queryArea = new JTextArea(DEFAULT_QUERY,3,100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);
			
			JScrollPane scroll = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			// set up JButton for submitting queries
			JButton submitButton = new JButton("Submit Query");
			
			// create Box to manage placement of queryArea and
			// submitButton in GUI
			Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scroll);
			boxNorth.add(submitButton);
			
			// create JTable based on the tableModel
			JTable resultTable = new JTable(JTable);
			JLabel filterLabel = new JLabel("Filter: ");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply filter: ");
			Box boxSouth = Box.createHorizontalBox();
			
			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);
			
			// place GUI components on content pane
			add(boxNorth,BorderLayout.NORTH);
			add(new JScrollPane(resultTable),BorderLayout.CENTER);
			add(boxSouth,BorderLayout.SOUTH);
			
			// create event listener for submitButton
			submitButton.addActionListener(
					new ActionListener()
					{

						// pass query to table model
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// perform a new query
							try
							{
								tableModel.setQuery( queryArea.getText() );

							}
							catch(SQLException sqlException)
							{
								JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
								
								// try to recover from invalid user query
								// by executing default query
								try
								{
									tableModel.setQuery(DEFAULT_QUERY);
									queryArea.setText(DEFAULT_QUERY);
								}
								catch(SQLException sqlException2)
								{
									JOptionPane.showMessageDialog(null, sqlException2.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
									
									// ensure database connection is closed
									tableModel.disconnectFromDatabase();
									System.exit(1);
								}
							}
						}
						
					});
			
			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			// set window size
			setSize(500,250);
			// display window
			setVisible(true);
			// create listener for filterButton
			filterButton.addActionListener(
					new ActionListener()
					{
						
						// pass filter text to listener
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String text = filterText.getText();
							
							if(text.length() == 0)
							{
								sorter.setRowFilter(null);
							}
							else
							{
								try
								{
									sorter.setRowFilter(RowFilter.regexFilter(text));
								}
								catch(PatternSyntaxException a)
								{
									JOptionPane.showMessageDialog(null, "bad regex pattern", "bad regex pattern", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					});
		}
		catch(SQLException sqlException)
		{
			JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
			
			// ensure database connection is closed
			tableModel.disconectFromDatabase();
			System.exit(1);
		}
		
		// dispose of window when user quits application (this overrides
		// the default of HIDE_ON_CLOSE)
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// ensure database connection is closed when user quits application
		addWindowListener(
				new WindowAdapter()
				{
					// disconnect from database and exit when window has closed
					public void windowClosed(WindowEvent e)
					{
						tableModel.disconectFromDatabase();
						System.exit(0);
					}
				});
	}
	public static void main(String[] args) 	 throws Exception{
		// TODO Auto-generated method stub
		new DisplayQueryResults();
	}

}
