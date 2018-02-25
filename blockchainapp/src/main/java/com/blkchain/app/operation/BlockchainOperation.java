package com.blkchain.app.operation;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mockito.internal.stubbing.answers.Returns;
import org.springframework.stereotype.Component;

import com.blkchain.app.construct.Block;
import com.blkchain.app.construct.Hashes;
import com.blkchain.app.construct.Transactions;
import com.blkchain.app.construct.User;

@Component
public class BlockchainOperation {
	Map<String, List<Block>> blockchain;
	Map<String, User> userMap;
	Block block;
	Hashes hashes;
	List<Block> blockList;
	List<Transactions> transcationList;
	Transactions transaction;

	final static int MAX_TRAN = 5;

	public BlockchainOperation() {
		blockchain = new HashMap();
		userMap = new HashMap<>();
	}

	public void createUser(User user) {
		String key = String.valueOf(user.getSsn()) + user.getDob();
		if (userMap.containsKey(key)) {
			return;
		} else {
			userMap.put(key, user);
			blockList = new ArrayList<>();
			blockList.add(createGensisBlock());
			blockchain.put(key, blockList);
			System.out.println("User added to network [" + key + "]");
		}
	}

	public List<Block> getUserTransctionDetails(User user) {
		String key = String.valueOf(user.getSsn()) + user.getDob();
		if (userMap.containsKey(key)) {
			return blockchain.get(key);
		}
		System.out.println("=================No Data Found for key================["+key+"]");
		return null;
	}
	
	public List<User> getUserList(){
		List<User> usrlist = new ArrayList<>();
		Set<String> userkey = userMap.keySet();
		Iterator<String> it = userkey.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println("===User key== ["+key+"]" );
			usrlist.add(userMap.get(key));
		}
		return usrlist; 
	}
	
	public void addTrasaction(Transactions transaction, User user) {
		String key = String.valueOf(user.getSsn()) + user.getDob();

		if (userMap.containsKey(key)) {
			blockList = blockchain.get(key);
			block = blockList.get(blockList.size() - 1);

			if (block.getNumberOfTransactions() == (MAX_TRAN)) {
				commitBlock(block);
				Block newBlock = createNewBlock(block.getHashes().getBlockHash());
				block.getHashes().setNextBlockHash(""+newBlock.hashCode());
				newBlock.getHashes().setPreviousBlockHash(""+block.hashCode());
				newBlock.setNumberOfTransactions(1);
				blockList.add(newBlock);
			} else {
				block.getTransactions().add(transaction);
				block.incrementTrasaction();
			}
		}else{
			System.out.println("User Does not exits ["+key+"]. Creating new user and then adding the transcation ");
			createUser(user);
			System.out.println("Fowrading call to add trassaction to newly created user ");
			addTrasaction(transaction, user);
			
		}
		System.out.println("Transaction Added to block "+transaction.getTransactionID());
	}

	private Block createGensisBlock() {
		hashes = new Hashes(null, "00000000000", "0000000000", "0000000000000");
		transcationList = new ArrayList<>();
		block = new Block(hashes, transcationList, 0, null);
		block.getHashes().setBlockHash(String.valueOf(block.hashCode()));
		return block;
	}

	private Block createNewBlock(String previousHash) {
		hashes = new Hashes(null, previousHash, "0000000000000", "0000000000000");
		transcationList = new ArrayList<>();
		block = new Block(hashes, transcationList, 0, null);
		block.getHashes().setBlockHash(String.valueOf(block.hashCode()));
		return block;
	}

	private void commitBlock(Block block) {
		block.setTimestamp(new Date());
		block.getHashes().setMarkelRoot(""+block.getTransactions().hashCode());
		System.out.println("Block Commited");
	}
}
