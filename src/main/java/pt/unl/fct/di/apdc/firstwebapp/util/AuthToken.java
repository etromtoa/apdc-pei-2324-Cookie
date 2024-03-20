package pt.unl.fct.di.apdc.firstwebapp.util;

import java.util.UUID;

import pt.unl.fct.di.apdc.firstwebapp.Authentication.SignatureUtils;

public class AuthToken {	
	public String username;
	public String tokenID;
	public String role;
	public String signature; 
	
	public AuthToken() {

	}
	
	public AuthToken(String username, String role) {
		this.username = username;
		this.tokenID = UUID.randomUUID().toString();
		this.role = role;
		this.signature = calculateSignature();
		
	}
	
	@Override
	public String toString() {
		return username+"."+tokenID+"."+role+"."+signature;
	}
	
	private String calculateSignature() {
		return SignatureUtils.calculateHMac("key", username+"."+tokenID+"."+role);
	}
	
}
