package jdbc_ex.dto;

public class Department {
	private int no;
	private String name;
	private int floor;

	public Department() {
	}

	public Department(int no) {
		super();
		this.no = no;
	}

	public Department(int no, String name, int floor) {
		super();
		this.no = no;
		this.name = name;
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Department [no=" + no + ", name=" + name + ", floor=" + floor + "]";
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

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

}
