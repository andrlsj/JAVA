package ch03;

public class Employee implements Comparable<Employee> {
	private int empno;
	private String ename;

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEname() {
		return ename;
	}

	public Employee(int empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}

	public Employee(int empno) {
		this(empno, "-");
	}

	public Employee(String ename) {
		this(0, ename);
	}

	public Employee() {
		this(0, "-"); //或  empno = 0; ename = "-"
	}

	public void display() {
		System.out.println("empno=" + empno);
		System.out.println("ename=" + ename);
	}

	public int compareTo(Employee aEmployee) {
		//物件本身與 aEmployee 相比較，如果 retrun 正值，就表示比 aEmployee 大
		if (this.empno > aEmployee.empno) {
			return 1;
		} else {
			return -1;
		}
	}

}
