package com.leite.friday.codeChallengeAddressParser.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressRegexpUtils {
	
	//Special Address format that contains Number identification
	public static final String ADDRESS_WITH_NUMBER_ID = "((No )[0-9]+$)|((Nº )[0-9]+$)|((Number)[0-9]+$)";
	
	//Regexp to extract streetNumber of an address string
	public static final String ADDRESS_NUMBER = "^[0-9]+|^[0-9]+.|[0-9].+.$|[0-9]+$";
	
	public static Matcher getMatcher(String regexp, String address) {
		Pattern p = Pattern.compile(regexp);
	    return p.matcher(address);
	  }

}
