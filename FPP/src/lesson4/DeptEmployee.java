package lesson4;

import java.time.LocalDate;

public class DeptEmployee
{
	protected String name;
	protected LocalDate hiredate;
	protected Double salary;
	
	public DeptEmployee(String name, LocalDate hiredate, Double salary) {
		super();
		this.name = name;
		this.hiredate = hiredate;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getHiredate() {
		return hiredate;
	}
	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}
	public double computeSalary()
	{
		return this.salary;
	}
	
	
}