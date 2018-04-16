package com.eci.ekm.jpa;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;

import com.eci.ekm.dataobject.BaseEntity;

public abstract class BaseRepository<T extends BaseEntity> {
	
	@Autowired
    protected Datastore datastore;
	
	protected Class<T> entityName;
	
	protected BaseRepository(Class<T> entityName1){
		this.entityName = entityName1;
	}
	
	public T create(T entity){
		Key<T> keyValue= datastore.save(entity);
		System.out.println("Key Value:"+keyValue.getId());
		return datastore.get(entityName, keyValue.getId());
	}
	
	public List<T> getAllEntity(){
		Query<T> resultList = datastore.createQuery(entityName);
		
		return resultList.asList();
	}
	
	public void delete(T entity){
		datastore.delete(entity);
	}
	
	public T getEntity(ObjectId objectId){
		return datastore.get(entityName, objectId);
	}
	
	public T update(T entity,String fieldName, String fieldValue){
		UpdateOperations<T> updateOps = datastore.createUpdateOperations(entityName).set(fieldName, fieldValue);
		UpdateResults updateResult = datastore.update(entity, updateOps);
		if(updateResult.getUpdatedExisting())
			return getEntity(entity.getId());
		else
			return null;
	}
}
