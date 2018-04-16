package com.eci.ekm.jpa;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eci.ekm.dataobject.User;

@Repository
public class UserRepositoryImpl extends BaseRepository<User>{
	
	  
	  
	  public UserRepositoryImpl(){
		  super(User.class);
	  }
	  

}
