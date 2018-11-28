package com.leite.friday.codeChallengeAddressParser;

public class Address {
	
	private final long id;
    private String street;
    private Integer housenumber;

    public Address(long id, String street,Integer housenumber) {
        this.id = id;
        this.street = street;
        this.housenumber = housenumber;
    }
    
    public Address(long id, String street) {
        this.id = id;
        this.street = street;
    }

    public long getId() {
        return id;
    }

	public String getStreet() {
		return street;
	}

	public Integer getHousenumber() {
		return housenumber;
	}

    

}
