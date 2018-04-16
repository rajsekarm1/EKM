package com.eci.ekm.dataobject;

import org.mongodb.morphia.annotations.Embedded;

import com.eci.ekm.type.AddressType;

@Embedded
public class Address {
	protected String street;

	  protected String zip;

	  protected String city;

	  protected String country;

	  protected AddressType addressType;

	  public String getStreet() {
	    return street;
	  }

	  public String getZip() {
	    return zip;
	  }

	  public String getCity() {
	    return city;
	  }

	  public String getCountry() {
	    return country;
	  }

	  public AddressType getAddressType() {
	    return addressType;
	  }

	  @Override
	  public String toString() {
	    return "AddressEntity [street=" + street + ", zip=" + zip + ", city=" + city + ", country="
		   + country + ", addressType=" + addressType + "]";
	  }
}
