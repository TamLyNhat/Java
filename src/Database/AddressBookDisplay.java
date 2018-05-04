package Database;

//trang 1218
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddressBookDisplay extends JFrame {

	private Person currentEntry;
	private PersonQueries personQueries;
	private List<Person> results;
	private int numberOfEntries = 0, currentEntryIndex;
	private JButton browseButton;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel idLabel;
	private JTextField idTextField;
	private JTextField indexTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JTextField maxTextField;
	private JButton nextButton;
	private JLabel ofLabel;
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	private JButton previousButton;
	private JButton queryButton;
	private JLabel queryLabel;
	private JPanel queryPanel;
	private JPanel navigatePanel;
	private JPanel displayPanel;
	private JTextField queryTextField;
	private JButton insertButton;
	
	
	public AddressBookDisplay()
	{
		super( "Address Book" );
		
		// establish database connection and set up PreparedStatements
		personQueries = new PersonQueries();
		
		navigatePanel = new JPanel();
		displayPanel = new JPanel();
		queryPanel = new JPanel();
		browseButton = new JButton();
		insertButton = new JButton();
		nextButton = new JButton();
		previousButton = new JButton();
		queryButton = new JButton();
		indexTextField = new JTextField(2);
		idTextField = new JTextField(20);
		maxTextField = new JTextField(2);
		firstNameTextField = new JTextField(10);
		lastNameTextField = new JTextField(10);
		emailTextField = new JTextField(10);
		phoneTextField = new JTextField(10);
		queryTextField = new JTextField(10);
		ofLabel = new JLabel();
		idLabel = new JLabel();
		firstNameLabel = new JLabel();
		lastNameLabel = new JLabel();
		emailLabel = new JLabel();
		phoneLabel = new JLabel();
		queryLabel = new JLabel();
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		setSize(500, 400);
		setResizable( false );
		
		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));
		
		previousButton.setText("Previous");
		previousButton.setEnabled(false);
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousButtonActionPerformed(e);
			}
		});
		
		navigatePanel.add(previousButton);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		indexTextField.setHorizontalAlignment(JTextField.CENTER);
		
		indexTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexTextFieldActionPerformed(e);
			}
		});
		
		navigatePanel.add(indexTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		ofLabel.setText("of");
		navigatePanel.add(ofLabel);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		maxTextField.setHorizontalAlignment(JTextField.CENTER);
		maxTextField.setEditable(false);
		navigatePanel.add(maxTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		nextButton.setText("Next");
		nextButton.setEnabled(false);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextButtonActionPerformed(e);
			}
		});
		
		navigatePanel.add(nextButton);
		add(navigatePanel);
		
		displayPanel.setLayout(new GridLayout(5, 2, 4, 4));
		idLabel.setText("Address ID:");
		displayPanel.add(idLabel);
		
		idTextField.setEditable(false);
		displayPanel.add(idTextField);
		
		firstNameLabel.setText("First Name:");
		displayPanel.add(firstNameLabel);
		displayPanel.add(firstNameTextField);

		lastNameLabel.setText("Last Name:");
		displayPanel.add(lastNameLabel);
		displayPanel.add(lastNameTextField);
		
		emailLabel.setText("Email:");
		displayPanel.add(emailLabel);
		displayPanel.add(emailTextField);
		
		phoneLabel.setText("Phone Number:");
		displayPanel.add(phoneLabel);
		displayPanel.add(phoneTextField);
		add(displayPanel);
		
		queryPanel.setLayout(new BoxLayout( queryPanel, BoxLayout.X_AXIS) );
		queryPanel.setBorder(BorderFactory.createTitledBorder("Find an entry by last name"));
		queryLabel.setText("Last Name:");
		queryPanel.add(Box.createHorizontalStrut(5));
		queryPanel.add(queryLabel);
		queryPanel.add(Box.createHorizontalStrut(10));
		queryPanel.add(queryTextField);
		queryPanel.add(Box.createHorizontalStrut(10));
		
		queryButton.setText("Find");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryButtonActionPerformed(e);
			}
		});
		
		queryPanel.add(queryButton);
		queryPanel.add(Box.createHorizontalStrut(5));
		add(queryPanel);
		
		browseButton.setText("Browse All Entries");
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browseButtonActionPerformed(e);
			}
		});
		
		add(browseButton);
		
		insertButton.setText("Insert New Entry");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertButtonActionPerformed(e);
			}
		});
		
		add(insertButton);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				personQueries.close();
				System.exit(0);
			}
		});
		
		setVisible(true);
	}
	
	// handles call when previousButton is clicked
	private void previousButtonActionPerformed(ActionEvent e) 
	{
		currentEntryIndex--;
		if (currentEntryIndex < 0)
			currentEntryIndex = numberOfEntries - 1;
		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(e);
	}
	
	// handles call when nextButton is clicked
	private void nextButtonActionPerformed(ActionEvent e) 
	{
		currentEntryIndex++;
		if (currentEntryIndex >= numberOfEntries)
			currentEntryIndex = 0;
		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(e);
	}
	
	// handles call when queryButton is clicked
	private void queryButtonActionPerformed(ActionEvent e)
	{
		results = personQueries.getPeopleByLastName(queryTextField.getText());
		numberOfEntries = results.size();
		
		if (numberOfEntries != 0)
		{
			currentEntryIndex = 0;
			currentEntry = results.get(currentEntryIndex);
			idTextField.setText("" + currentEntry.getAddressID());
			firstNameTextField.setText(currentEntry.getFirstName());
			lastNameTextField.setText(currentEntry.getLastName());
			emailTextField.setText(currentEntry.getEmail());
			phoneTextField.setText(currentEntry.getPhoneNumber());
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
			nextButton.setEnabled( true );
			previousButton.setEnabled( true );
		}
		else
		{
			browseButtonActionPerformed(e);
		}
	}
	
	// handles call when a new value is entered in indexTextField
	private void indexTextFieldActionPerformed(ActionEvent e) 
	{
		currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);
		
		if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries) 
		{
			currentEntry = results.get(currentEntryIndex);
			idTextField.setText("" + currentEntry.getAddressID());
			firstNameTextField.setText(currentEntry.getFirstName());
			lastNameTextField.setText(currentEntry.getLastName());
			emailTextField.setText(currentEntry.getEmail());
			phoneTextField.setText(currentEntry.getPhoneNumber());
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
		}
	}
	
	private void browseButtonActionPerformed(ActionEvent e)
	{
		try {
			results = personQueries.getAllPeople();
			numberOfEntries = results.size();
			if (numberOfEntries != 0) 
			{
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				idTextField.setText("" + currentEntry.getAddressID());
				firstNameTextField.setText(currentEntry.getFirstName());
				lastNameTextField.setText(currentEntry.getLastName());
				emailTextField.setText(currentEntry.getEmail());
				phoneTextField.setText(currentEntry.getPhoneNumber());
				maxTextField.setText("" + numberOfEntries);
				indexTextField.setText("" + (currentEntryIndex + 1));
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			}
		} catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}
	
	private void insertButtonActionPerformed(ActionEvent e)
	{
		int result = personQueries.addPerson(firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(), phoneTextField.getText());
		
		if (result == 1)
		{
			JOptionPane.showMessageDialog( this, "Person added!", "Person added", JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog( this, "Person not added!", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		
		browseButtonActionPerformed(e);
	}
	
	public static void main(String[] args) 
	{
		new AddressBookDisplay();
	}
}
