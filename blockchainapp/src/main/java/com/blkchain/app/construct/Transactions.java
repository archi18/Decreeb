package com.blkchain.app.construct;

import java.util.Date;

import com.blkchain.app.constant.TransctionType;


public class Transactions {
int transactionID;
	
	long transactionAmmount=0;
	
	TransctionType transctionType;
	
	String postingDate;
	
	String otherInformation;

	public Transactions(int transactionID, long transactionAmmount, TransctionType transctionType, String postingDate,
			String otherInformation) {
		super();
		this.transactionID = transactionID;
		this.transactionAmmount = transactionAmmount;
		this.transctionType = transctionType;
		this.postingDate = postingDate;
		this.otherInformation = otherInformation;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public long getTransactionAmmount() {
		return transactionAmmount;
	}

	public void setTransactionAmmount(long transactionAmmount) {
		this.transactionAmmount = transactionAmmount;
	}

	public TransctionType getTransctionType() {
		return transctionType;
	}

	public void setTransctionType(TransctionType transctionType) {
		this.transctionType = transctionType;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}
	
}
