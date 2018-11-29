package com.leite.friday.codeChallengeAddressParser.model;

import static com.leite.friday.codeChallengeAddressParser.testUtils.Addresses.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.leite.friday.codeChallengeAddressParser.model.exceptions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class ParseAddressTest {

	private ParseAddress parseAddress;

	@Before
	public void setUp() throws Exception {
		parseAddress = new ParseAddress();
	}

	@Test
	public void shouldParseSimpleCases() {

		String address = SIMPLE_CASE_1;
		Address adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("Winterallee", "3"));

		address = SIMPLE_CASE_2;
		adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("Musterstrasse", "45"));

		address = SIMPLE_CASE_3;
		adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("Blaufeldweg", "123B"));
	}
	@Test
	public void shouldParseComplicatedCases() {

		String address = COMPLICATED_CASE_1;
		Address adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("Am Bächle", "23"));

		address = COMPLICATED_CASE_2;
		adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("Auf der Vogelwiese", "23 b"));
	}
	
	@Test
	public void shouldParseInternationalAddressCases() {

		String address = INTERNATIONAL_ADDRESS_CASE_1;
		Address adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("rue de la revolution", "4"));

		address = INTERNATIONAL_ADDRESS_CASE_2;
		adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("Broadway Av", "200"));
		
		address = INTERNATIONAL_ADDRESS_CASE_3;
		adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("Calle Aduana", "29"));
		
		address = INTERNATIONAL_ADDRESS_CASE_4;
		adressParsed = parseAddress.parse(address);
		assertThat(adressParsed).isEqualToComparingFieldByField(new Address("Calle 39", "No 1540"));
	}
	
	@Test
	  public void shouldThrowExceptionWhenAddressIsNull() {
	    Throwable thrown = catchThrowable(() -> parseAddress.parse(null));
	    assertThat(thrown).isExactlyInstanceOf(AddressNotFoundException.class);
	    assertThat(thrown).hasMessageContaining("Address null or empty and cannot be found to be parsed");
	  }

	  @Test
	  public void shouldThrowExceptionWhenAddressIsEmpty() {
	    Throwable thrown = catchThrowable(() -> parseAddress.parse(""));
	    assertThat(thrown).isExactlyInstanceOf(AddressNotFoundException.class);
	    assertThat(thrown).hasMessageContaining("Address null or empty and cannot be found to be parsed");
	  }
	  
	  @Test
	  public void shouldThrowExceptionWhenAddressIsNotParseable() {
	    Throwable thrown = catchThrowable(() -> parseAddress.parse(UNPARSEBABLE_ADDRESS));
	    assertThat(thrown).isExactlyInstanceOf(ParserNotFoundException.class);
	    assertThat(thrown).hasMessageContaining(String.format("String Address %s could not be parsed", UNPARSEBABLE_ADDRESS));
	  }




}
