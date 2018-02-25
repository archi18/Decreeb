package com.blkchain.app.construct;

import java.util.List;

public class User {
String firstName;
	
	String lastName;
	
	String passportNumber;
	
	long ssn;
	
	String dob;
	
	List<Address> address;
	public User(){
		
	}
	public User(String firstName, String lastName, String passportNumber, long ssn, String dob, List<Address> address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
		this.ssn = ssn;
		this.dob = dob;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String bod) {
		this.dob = bod;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
}
