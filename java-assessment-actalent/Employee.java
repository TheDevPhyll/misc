import java.util.ArrayList;
import java.util.Date;

/**
 * Employee class as described in Question 2 with additional example properties and methods
 */
public class Employee {

	private String name;
	private Date dateHired;
	private int id;
	private Manager manager;
	private double salary;
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	public String getID()
	{
		return id + "";
	}
	
	public void setDateHired(Date dateHired)
	{
		this.dateHired = dateHired;
	}
	public Date getDateHired()
	{
		return dateHired;
	}
//	public void setSalary(double salary)
//	{
//		this.salary = salary;
//	}
//	public double getAnnualIncome()
//	{
//		return salary;
//	}
	
	public boolean isManager()
	{
		return this instanceof Manager;
	}
	public boolean isPartTimer()
	{
		return this instanceof PartTimer;
	}
}

class Manager extends Employee {

	private ArrayList<Employee> employeesManaging;
	
}

class PartTimer extends Employee{

	private int hourLimit;
	private double hourlyRate;
	
//	@Override
//	public double getAnnualIncome()
//	{
//		return hourLimit * hourlyRate * 52;
//	}
}
