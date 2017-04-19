package com.eth.smart.contratos;

import java.math.BigInteger;

import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.infura.InfuraHttpService;
 
public class App 
{
	
	private static final String     walletFile = "UTC--2017-04-19T18-14-12.599000000Z--1539beb0920cbb05e4e499c3f6795fac88339e34.json";
	private static final String     address = "0x1539beb0920cbb05e4e499c3f6795fac88339e34";
	private static final BigInteger GAS_PRICE = new BigInteger("0");   
	private static final BigInteger GAS_LIMIT = new BigInteger("210000");   
	private static final BigInteger initialValue = new BigInteger("0");  
	private static final boolean    EXISTENTE = true;
	 
    public static void main(String[] args) throws Exception
    {
    	Greeter smartContract = null; 
    	Web3jService inf = new InfuraHttpService("https://ropsten.infura.io/1bFTbNDTBv3jMPXnANB0");
    	Web3j web3 = Web3j.build(inf);	 
    	Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
    	 
    	String clientVersion = web3ClientVersion.getWeb3ClientVersion();
    	Credentials credentials = WalletUtils.loadCredentials("123456", "/wallet_eth/" + walletFile);
 

    	if(!EXISTENTE){
 
	    	/* you can create and deploy your smart contract */
	    	smartContract = Greeter.deploy(web3, credentials, GAS_PRICE, GAS_LIMIT, initialValue, new Utf8String("HELLO WORLD")).get();
	    	
    	}else{
    		
	    	/* use an existing */
	    	smartContract = Greeter.load(address, web3, credentials, GAS_PRICE, GAS_LIMIT);
	    	
    	}
 
    	Utf8String msg = smartContract.greet().get();
    	 
    	System.out.println("clientVersion: " + clientVersion); 
    	System.out.println("clientVersion: " + msg); 
    	
    }
}



/*

tx 0xf8a4bbe9f21a19323b18ea7dc7a72219138e5606a0f226b2fec82dbe17c8499e
Transaction receipt was not generated after 600 seconds for transaction

Mas info

https://docs.web3j.io
https://github.com/web3j/web3j
https://github.com/adridadou/eth-contract-api

install solidity in linux

http://solidity.readthedocs.io/en/develop/installing-solidity.html#binary-packages

*/

/*
pragma solidity ^0.4.10;

contract mortal {
     
    address owner;
  
    function mortal() { owner = msg.sender; }
     
    function kill() { if (msg.sender == owner) selfdestruct(owner); }
}

contract greeter is mortal {
    
    string greeting;
  
    function greeter(string _greeting) public {
        greeting = _greeting;
    }

    function greet() constant returns (string) {
        return greeting;
    }
}

*/