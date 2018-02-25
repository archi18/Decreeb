package com.blkchain.app.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blkchain.app.operation.BlockchainOperation;
import com.blkchain.app.util.TrasactionParser;
import com.fasterxml.jackson.core.JsonParser;
import com.blkchain.app.constant.TransctionType;
import com.blkchain.app.construct.Address;
import com.blkchain.app.construct.Block;
import com.blkchain.app.construct.Transactions;
import com.blkchain.app.construct.User;

@RestController
public final class BlockchainController {
	
	
	
	@Autowired
	private BlockchainOperation blockchainOperation; 
	
	public BlockchainController(BlockchainOperation operation) throws FileNotFoundException {
		blockchainOperation =operation;
		System.out.println("===================Operation OBJECT INTIALIZED ================");
		//this.randomData();
		File file = new File(Thread.currentThread().getContextClassLoader().getResource("trasactiondata.json").getFile());
		TrasactionParser.parseData(file, blockchainOperation);
	}
	
	@RequestMapping("/welcome")
	String hello(){
		Thread.currentThread().getContextClassLoader().getResource("");
		
		return "Hello Blockchain";
	}
	
	@RequestMapping("/users")
	List<User> getUserList(){
		return blockchainOperation.getUserList();
	}
	
	@GetMapping("/blocks/{ssn}/{dob}")
	List<Block> getTrasactionList(@PathVariable long ssn,@PathVariable String dob ){
		User user = new User(null, null, null, ssn, dob, null);
		return blockchainOperation.getUserTransctionDetails(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/transaction")
	void addTransaction(@RequestBody User user){
		Transactions transaction= new Transactions(5, (long)(Math.random()*1000), TransctionType.CarInsurencePremium, "02182018", "none");
		blockchainOperation.addTrasaction(transaction, user);
	}
	
	
	private void randomData(){
		System.out.println("===========================Generating Randmom data==================================");
		
		User user= null; 
		Address address=null;
		List<Address> addList;
		Transactions transaction;

		for (int i = 0; i<10; i++){
			address = new Address("streetName"+i, "appartment"+i, "state"+i, "city"+i, "county"+i, (int)(Math.random()*1000000000));
			addList = new ArrayList<>();
			addList.add(address);
			user= new User("firstName"+i, "lastName"+i, "passportNumber"+i, (long)(Math.random()*1000000000),"02182018", addList);	
			blockchainOperation.createUser(user);
			transaction= new Transactions(i, (long)(Math.random()*1000), TransctionType.CarInsurencePremium, "02182018", "none");
			blockchainOperation.addTrasaction(transaction, user);
		}
		
		for (int i = 0; i<10; i++){
			address = new Address("streetName"+i, "appartment"+i, "state"+i, "city"+i, "county"+i, (int)(Math.random()*1000000000));
			addList = new ArrayList<>();
			addList.add(address);
			user= new User("firstName"+i, "lastName"+i, "passportNumber"+i, (long)(Math.random()*1000000000),"02182018", addList);	
			//operation.createUser(user);
			transaction= new Transactions(i, (long)(Math.random()*1000), TransctionType.CarInsurencePremium, "02182018", "none");
			blockchainOperation.addTrasaction(transaction, user);
		}
	
	}
	
	
}
