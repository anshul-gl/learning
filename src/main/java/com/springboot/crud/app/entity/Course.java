package com.springboot.crud.app.entity;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.*;


/**
 * Course.java
 * Purpose:Creates a course class with attributes
 * @author @anshul
 * @version 1.0 8/24/18
 */
@Document
public class Course {

	@Id
	private int id;
	
	@Field
	private String name;
	
	@Field
	private String description;
	
	public Course()
	{
		
	}
	public Course(int id, String name, String description) {
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
	
	
}
