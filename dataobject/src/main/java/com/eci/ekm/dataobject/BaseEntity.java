package com.eci.ekm.dataobject;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.annotations.Version;

public abstract class BaseEntity {
	
	@Id
	protected ObjectId id;
	
	
	public ObjectId getId() {
		return id;
	}

	protected Date creationDate;
	protected Date updatedDate;
	
	@Version
	private long version;
	
	public BaseEntity(){
		super();
	}
	
	@PrePersist
	  public void prePersist() {
	    this.creationDate = (creationDate == null) ? new Date() : creationDate;
	    this.updatedDate = (updatedDate == null) ? creationDate : new Date();
	  }
}
