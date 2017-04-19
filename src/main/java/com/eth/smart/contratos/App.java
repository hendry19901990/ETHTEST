package com.eth.smart.contratos;

import java.util.concurrent.ExecutionException;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.infura.InfuraHttpService;
 

public class App 
{
	private static String walletFile = "UTC--2017-04-19T18-14-12.599000000Z--1539beb0920cbb05e4e499c3f6795fac88339e34.json";
	 
    public static void main(String[] args) throws Exception
    {
    	Web3jService inf = new InfuraHttpService("https://ropsten.infura.io/1bFTbNDTBv3jMPXnANB0");
    	Web3j web3 = Web3j.build(inf);	 
    	Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
    	
    	String clientVersion = web3ClientVersion.getWeb3ClientVersion();
    	Credentials credentials = WalletUtils.loadCredentials("123456", "/wallet_eth/"+App.walletFile);

    	
    	
    }
}



/*

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