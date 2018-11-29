/**
 * 
 */
package com.leite.friday.codeChallengeAddressParser.model;

import com.leite.friday.codeChallengeAddressParser.model.exceptions.AddressNotFoundException;
import static com.leite.friday.codeChallengeAddressParser.utils.AddressUtils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author EddPro
 *
 */
public class ParseAddress {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParseAddress.class);

	/**
	 * @param String address - Address string with street names and numbers in the same string.
	 * @return Address - Address object with street and addressNumber
	 * @throws AddressNotFoundException
	 */
	public Address parse(String address) throws AddressNotFoundException{

		if (address == null || address.isEmpty()) {
			throw new AddressNotFoundException();
		}

		LOGGER.debug("Full String Address: ", address);

		//remove empty spaces and special chars
		address = cleanAddressString(address);

		LOGGER.debug("Cleaned String Address: ", address);

		Address parsedAddress = new Address();
		parsedAddress.setHousenumber(extractAddressNumber(address));
		parsedAddress.setStreet((extractAddressStreetByNumber(address,parsedAddress.getHousenumber())));

		return parsedAddress;		

	}

}
