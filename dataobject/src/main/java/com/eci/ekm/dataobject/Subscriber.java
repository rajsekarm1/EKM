package com.eci.ekm.dataobject;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;

@Entity(value="eci_subscriber")
public class Subscriber extends BaseEntity{
	
	@Indexed
	public String name;
	
	@Embedded
	public Address address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String web;

	@Override
	public String toString() {
		return String.format("Subscriber [name=%s, address=%s, web=%s, id=%s, creationDate=%s, updatedDate=%s]", name,
				address, web, id, creationDate, updatedDate);
	}
	
	 

}
