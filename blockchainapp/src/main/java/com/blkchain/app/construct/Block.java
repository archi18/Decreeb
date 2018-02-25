package com.blkchain.app.construct;

import java.util.Date;
import java.util.List;


public class Block {
	Hashes hashes;
	List<Transactions> transactions;
	int numberOfTransactions;
	Date timestamp;
	int hashCode;
	
	public Block(Hashes hashes, List<Transactions> transactions, int numberOfTransactions, Date timestamp) {
		this.hashes = hashes;
		this.transactions = transactions;
		this.numberOfTransactions = numberOfTransactions;
		this.timestamp = timestamp;
		this.hashCode = (int)(Math.random()*1000000);
		System.out.println("HashCOde ["+hashCode+"]");
	}

	@Override
	public int hashCode() {
		return this.hashCode;
	}


	public Hashes getHashes() {
		return hashes;
	}

	public void setHashes(Hashes hashes) {
		this.hashes = hashes;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	public int getNumberOfTransactions() {
		return numberOfTransactions;
	}

	public void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public void incrementTrasaction(){
		this.numberOfTransactions +=1;
	}
	
	
}
