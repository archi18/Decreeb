package com.blkchain.app.construct;

public class UserEntity {
	String SSN;
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getTransaction_amt() {
		return transaction_amt;
	}
	public void setTransaction_amt(String transaction_amt) {
		this.transaction_amt = transaction_amt;
	}
	public String getTransaction_dt() {
		return transaction_dt;
	}
	public void setTransaction_dt(String transaction_dt) {
		this.transaction_dt = transaction_dt;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTransaction_typ() {
		return transaction_typ;
	}
	public void setTransaction_typ(String transaction_typ) {
		this.transaction_typ = transaction_typ;
	}
	String dateofbirth;
	int transaction_id;
	String transaction_amt;
	String transaction_dt;
	String fname;
	String lname;
	String address;
	String city;
	String state;
	String country;
	String transaction_typ;  
}
