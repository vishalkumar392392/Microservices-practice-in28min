package com.restApi.course.helloworld;

public class HelloWorld {
	
	private String name;
	private long mobileNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public HelloWorld(String name, long mobileNumber) {
		this.name = name;
		this.mobileNumber = mobileNumber;
	}
	public HelloWorld() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
