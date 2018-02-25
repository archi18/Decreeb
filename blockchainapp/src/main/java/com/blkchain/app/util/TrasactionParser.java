package com.blkchain.app.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.blkchain.app.constant.TransctionType;
import com.blkchain.app.construct.Address;
import com.blkchain.app.construct.Transactions;
import com.blkchain.app.construct.User;
import com.blkchain.app.construct.UserEntity;
import com.blkchain.app.operation.BlockchainOperation;


public class TrasactionParser {
	
	static public void parseData(File file, BlockchainOperation blockchainOperation) throws FileNotFoundException{
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray;
		User user= null; 
		Address address=null;
		List<Address> addList;
		Transactions transaction;
		System.out.println("==================>Parsing file start<======================");
        try {
			jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));
			Iterator<JSONObject> jsIterator = jsonArray.iterator();
			while (jsIterator.hasNext()) {
				JSONObject jsonObject = jsIterator.next();
				
				long SSN  = (Long) jsonObject.get("SSN") ; 
				 long dateofbirth = (Long) jsonObject.get("dateofbirth") ; 
				 long transaction_id = (Long) jsonObject.get("transaction_id") ; 
				 long transaction_amt = (Long) jsonObject.get("transaction_amt") ; 
				 long transaction_dt = (Long) jsonObject.get("transaction_dt") ; 
				 String lname  = (String) jsonObject.get("lname") ; 
				 String addrs = (String) jsonObject.get("address") ; 
				 String city = (String) jsonObject.get("city") ; 
				 String state  = (String) jsonObject.get("state") ; 
				 String country  = (String) jsonObject.get("country") ; 
				 String transaction_typ = (String) jsonObject.get("transaction_typ");
				System.out.println("SSN===>"+SSN);
				System.out.println("BOD  "+dateofbirth);
				addList = new ArrayList<>();
				address=  new Address(addrs, "#56", state, city, country, 60616);
				addList.add(address);
				user = new User("firstName", lname, "P57146954", SSN, ""+dateofbirth, addList);
				transaction = new Transactions((int)transaction_id, (long)transaction_amt, TransctionType.CreditCard, ""+transaction_dt, "None");
				//blockchainOperation.createUser(user);
				blockchainOperation.addTrasaction(transaction, user);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
