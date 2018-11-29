package com.leite.friday.codeChallengeAddressParser.model.exceptions;

@SuppressWarnings("serial")
public class ParserNotFoundException extends RuntimeException{
	public ParserNotFoundException(String address) {
		super(String.format("String Address %s could not be parsed", address));
	}

}
