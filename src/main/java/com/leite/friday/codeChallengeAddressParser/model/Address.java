package com.leite.friday.codeChallengeAddressParser.model;

public class Address {
	
	private long id;
    private String street;
    private String housenumber;

    public Address(long id, String street,String housenumber) {
        this.id = id;
        this.street = street;
        this.housenumber = housenumber;
    }
    
    public Address(long id, String street) {
        this.id = id;
        this.street = street;
    }

    public Address() {
	}

	public long getId() {
        return id;
    }

	public String getStreet() {
		return street;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	
	

    

}
