package com.springboot.crud.app.entity;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.*;


/**
 * Topic.java
 * Purpose:Creates a topic class with multiple courses
 * @author @anshul
 * @version 1.0 8/24/18
 */
@Document
public class Topic {

	@Id
	private int id;
	
	@Field
	private String name;
	
	@Field
	private String description;
	
	//Modelling many to one relationship between courses and topic
	@Field
	private List<Integer> courseIds = new ArrayList<>();
	

	public Topic()
	{
		
	}
	public Topic(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Integer> getCourseIds() {
		return courseIds;
	}
	public void setCourseIds(List<Integer> courseIds) {
		this.courseIds = courseIds;
	}
	
	
	@Override
	public boolean equals(Object o1) {
		Topic theTopic = (Topic)o1;
		return (theTopic.getId()==this.getId()) && theTopic.getDescription().equals(this.getDescription()) && theTopic.getName().equals(this.getName()); 
	}
}
