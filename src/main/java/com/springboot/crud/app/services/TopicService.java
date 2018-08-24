package com.springboot.crud.app.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.*;


import com.springboot.crud.app.entity.Topic;
import com.springboot.crud.app.repository.TopicRepositiory;

/**
 * TopicService.java
 * Purpose: Implements the CRUD functionality and interacts with repository 
 * @author @anshul
 * @version 1.0 8/24/18
 */
@Service //default Singleton
public class TopicService {
	
	@Autowired
	private TopicRepositiory topicRepositiory;
	
	/**
	 * 
	 * @param 
	 * Fetch all topics from database using findAll() and add it to list
	 * @return list of topic
	 */	
	public List<Topic> getAllTopics()
	{
		System.out.println("topic service mein hu ------");
		ArrayList<Topic> topics = new ArrayList<>();
		topicRepositiory.findAll().forEach(topics::add);
		System.out.println(topics);
		return topics;
	}
	
	/**
	 * 
	 * @param Topic Id 
	 * Fetch the topic from topic repository using built in findById method
	 * @return topic
	 */
	public Topic getTopic(int id)
	{
		try {
			
			return topicRepositiory.findById(id).get();
			//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		}
		catch (Exception e) {
			return null;
		}
		 
	}
	/**
	 * 
	 * @param Topic Object
	 * Save the topic in database using repository built in method save
	 * @return void
	 */
	public void addTopic(Topic topic)
	{
		try {
			topicRepositiory.save(topic);

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/**
	 * 
	 * @param Topic Id, Topic Object
	 * Update the topic in database using repository built in method save with only
	 * attributes in the request body and keeping others intact 
	 * @return void
	 */	
	public void updateTopic(int id, Topic topic)
	{
		try {
			Topic theTopic = getTopic(id);
			System.out.println(theTopic.getName()+ ":"+ theTopic.getId()+":" + theTopic.getDescription()+theTopic.getCourseIds());
			if (topic.getName() != null){
				theTopic.setName(topic.getName());
			}
			if(topic.getDescription()!=null)
			{
				theTopic.setDescription(topic.getDescription());
			}
			if(topic.getCourseIds()!=null)
			{
				theTopic.setCourseIds(topic.getCourseIds());
			}
			System.out.println(theTopic.getName()+ ":"+ theTopic.getId()+":" + theTopic.getDescription()+theTopic.getCourseIds());
			topicRepositiory.save(theTopic);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * 
	 * @param Topic Id
	 * Delete the topic in database using repository built in method deleteById
	 * @return void
	 */
	public void deleteTopic(int id)
	{
		{
			try {
				topicRepositiory.deleteById(id);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}	
	}
}
