package com.eth.smart.contratos;

import java.util.concurrent.ExecutionException;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.infura.InfuraHttpService;
 

public class App 
{
	 
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
    	Web3jService inf = new InfuraHttpService("https://ropsten.infura.io/1bFTbNDTBv3jMPXnANB0");
    	Web3j web3 = Web3j.build(inf);	 
    	Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
    	String clientVersion = web3ClientVersion.getWeb3ClientVersion();
    	System.out.println(clientVersion);
    	
    	web3.web3ClientVersion().observable().subscribe(x -> {
    		String clientVersionx = x.getWeb3ClientVersion();
    		System.out.println("---- observable");
    		System.out.println(clientVersionx);
    	    
    	});
    }
}



/*

Mas info

https://docs.web3j.io
https://github.com/web3j/web3j
https://github.com/adridadou/eth-contract-api

*/