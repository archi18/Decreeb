package com.blkchain.app.construct;

public class Hashes {
	String blockHash;
	String previousBlockHash;
	String nextBlockHash;
	String markelRoot;
	
	
	public Hashes(String blockHash, String previousBlockHash, String nextBlockHash, String markelRoot) {
		super();
		this.blockHash = blockHash;
		this.previousBlockHash = previousBlockHash;
		this.nextBlockHash = nextBlockHash;
		this.markelRoot = markelRoot;
	}


	public String getBlockHash() {
		return blockHash;
	}


	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}


	public String getPreviousBlockHash() {
		return previousBlockHash;
	}


	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}


	public String getNextBlockHash() {
		return nextBlockHash;
	}


	public void setNextBlockHash(String nextBlockHash) {
		this.nextBlockHash = nextBlockHash;
	}


	public String getMarkelRoot() {
		return markelRoot;
	}


	public void setMarkelRoot(String markelRoot) {
		this.markelRoot = markelRoot;
	}
	
	
}
