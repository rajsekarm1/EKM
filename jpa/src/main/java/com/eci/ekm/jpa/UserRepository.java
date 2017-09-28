package com.eci.ekm.jpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eci.ekm.dataobject.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	

    public List<User> findByLastName(String lastName);

}
