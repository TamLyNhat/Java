package JTable;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.table.AbstractTableModel;

public class TableValues extends AbstractTableModel {

	public static int FIRST_NAME = 0;
	public static int LAST_NAME = 1;
	public static int DATE_OF_BIRTH = 2;
	public static int ACCOUNT_BALANCE = 3;
	public static int GENDER = 4;
	public final static boolean GENDER_MALE = true;
	public final static boolean GENDER_FEMALE = false;
	
	public Object[][] values = {
			{
				"Clay", "Ashworth",
				new GregorianCalendar(1962, Calendar.FEBRUARY,20).getTime(),
				new Float(12345.67), new Boolean(GENDER_MALE)
			},
			{
				"Jacob", "Ashworth",
				new GregorianCalendar(1987, Calendar.JANUARY, 6).getTime(),
				new Float(23456.78), new Boolean(GENDER_MALE)
			},
			{
				"Jordan", "Ashworth",
				new GregorianCalendar(1989, Calendar.AUGUST, 31).getTime(),
				new Float(34567.89), new Boolean(GENDER_FEMALE)
			}, 
			{
				"Evelyn", "Kirk",
				new GregorianCalendar(1945, Calendar.JANUARY, 16).getTime(),
				new Float(-456.70), new Boolean(GENDER_FEMALE)
			}, 
			{
				"Belle", "Spyres",
				new GregorianCalendar(1907, Calendar.AUGUST, 2).getTime(),
				new Float(567.00), new Boolean(GENDER_FEMALE)
			}
	};
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return values[0].length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return values[row][column];
	}

}
