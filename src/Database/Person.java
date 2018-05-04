package Database;

//trang 1212
public class Person {

	private int addressID;
	private String firstName, lastName, email, phoneNumber;
	public Person()
	{
		
	}
	
	public Person( int id, String first, String last, String emailAddress, String phone)
	{
		setAddressID(id);
		setFirstName(first);
		setLastName(last);
		setEmail(emailAddress);
		setPhoneNumber(phone);
	}
	
	public void setAddressID(int id)
	{
		addressID = id;
	}
	
	public int getAddressID() 
	{
		return addressID;	
	}
	
	public void setFirstName(String first)
	{
		firstName = first;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setEmail(String eAddress)
	{
		email = eAddress;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setPhoneNumber(String ph)
	{
		phoneNumber = ph;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
}
