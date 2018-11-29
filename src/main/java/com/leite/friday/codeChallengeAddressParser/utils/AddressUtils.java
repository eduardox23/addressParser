package com.leite.friday.codeChallengeAddressParser.utils;

import static com.leite.friday.codeChallengeAddressParser.utils.AddressRegexpUtils.ADDRESS_NUMBER;
import static com.leite.friday.codeChallengeAddressParser.utils.AddressRegexpUtils.ADDRESS_WITH_NUMBER_ID;
import static com.leite.friday.codeChallengeAddressParser.utils.AddressRegexpUtils.getMatcher;

import java.util.regex.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leite.friday.codeChallengeAddressParser.model.exceptions.AddressNotFoundException;
import com.leite.friday.codeChallengeAddressParser.model.exceptions.ParserNotFoundException;

public class AddressUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressUtils.class);
	
	
	/**
	   * @param String address - Address string with street names and numbers in the same string.
	   * @return String - cleaned string without leading and trailing white spaces and no commas
	   *     - Address Number
	   */
	public static String cleanAddressString(String address) {
		//trim() to remove leading and trailing white space 
		address = address.trim();
		//remove all commas of the address string","
		return address.replaceAll( ",", "" );
	}
	
	/**
	   * @param String address - Address string with street names and numbers in the same string.
	   * @return String - String with the number information part of the address string
	   * @throws ParserNotFoundException
	   */
	public static String extractAddressNumber(String address) throws ParserNotFoundException {

		Matcher matcher = getMatcher(ADDRESS_WITH_NUMBER_ID, address);

		//remove number string part
		if (matcher.find()) {
			LOGGER.info("Found address with ADDRESS_WITH_NUMBER_ID Regexp: ");
			//Returns the input subsequence matched by the previous match
			return matcher.group().trim();
		}

		matcher = getMatcher(ADDRESS_NUMBER, address);

		//remove number string part
		if (matcher.find()) {
			LOGGER.info("Found address with ADDRESS_NUMBER Regexp: ");
			//Returns the input subsequence matched by the previous match
			return matcher.group().trim();
		}
		
		throw new ParserNotFoundException(address);
	}
	/**
	   * @param String address - Address string with street names and numbers in the same string.
	   * @param String number - String with the number information part of the address string.
	   * @return String - String with the street information part of the address string
	   * @throws ParserNotFoundException
	   */
	public static String extractAddressStreetByNumber(String address,String number) {

		//with the content of streetNumber, remove it from the original address string to get the street string
		String street = address.replaceAll(number, "" ).trim();
		return street;
	}

}
