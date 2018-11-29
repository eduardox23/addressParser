package com.leite.friday.codeChallengeAddressParser.model.exceptions;

@SuppressWarnings("serial")
public class AddressNotFoundException extends RuntimeException {
	public AddressNotFoundException() {
	    super("Address null or empty and can not be found to be parsed");
	  }

}
