package jdbc_ex.dto;

public class Employee {
	private int no;
	private String name;
	private Title tno;
	private Employee Manager;
	private int salary;
	private Department dno;
	
	public Employee() {
	}
	
	public Employee(int no) {
		super();
		this.no = no;
	}
	
	public Employee(int no, String name, Title tno, Employee manager, int salary, Department dno) {
		super();
		this.no = no;
		this.name = name;
		this.tno = tno;
		Manager = manager;
		this.salary = salary;
		this.dno = dno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Title getTno() {
		return tno;
	}

	public void setTno(Title tno) {
		this.tno = tno;
	}

	public Employee getManager() {
		return Manager;
	}

	public void setManager(Employee manager) {
		Manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDno() {
		return dno;
	}

	public void setDno(Department dno) {
		this.dno = dno;
	}

	@Override
	public String toString() {
		return "Employee [no=" + no + ", name=" + name + ", tno=" + tno + ", Manager=" + Manager + ", salary=" + salary
				+ ", dno=" + dno + "]";
	}

}
