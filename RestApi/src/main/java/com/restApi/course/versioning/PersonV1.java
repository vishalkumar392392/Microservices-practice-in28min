package com.restApi.course.versioning;

public class PersonV1 {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

	public PersonV1() {
		// TODO Auto-generated constructor stub
	}

	public PersonV1(String name) {
		super();
		this.name = name;
	}
	
	

}
