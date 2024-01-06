package java_interview;

import java.util.List;

public class Employee {
	
	private String name;
	private String address;
	private int age;
	private List<String> email;
	
	private List<Integer> mob_number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<Integer> getMob_number() {
		return mob_number;
	}

	public void setMob_number(List<Integer> mob_number) {
		this.mob_number = mob_number;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", age=" + age + ", email=" + email + ", mob_number="
				+ mob_number + "]";
	}

	public Employee(String name, String address, int age, List<String> email, List<Integer> mob_number) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.email = email;
		this.mob_number = mob_number;
	}
	
	
	

}
