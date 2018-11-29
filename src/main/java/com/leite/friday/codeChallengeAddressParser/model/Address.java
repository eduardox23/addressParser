package com.leite.friday.codeChallengeAddressParser.model;

public class Address {
	
    private String street;
    private String housenumber;

    public Address(String street,String housenumber) {
        this.street = street;
        this.housenumber = housenumber;
    }
    
    public Address(String street) {
        this.street = street;
    }

    public Address() {
	}

	public String getStreet() {
		return street;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	
	

    

}
