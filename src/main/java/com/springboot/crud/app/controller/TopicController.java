package com.springboot.crud.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.java.document.json.JsonObject;
import com.springboot.crud.app.entity.Topic;
import com.springboot.crud.app.services.TopicService;

/**
 * CourseController.java
 * Purpose: controls the data flow of topic into model object and 
 * 			updates the API whenever data changes or fetched
 * @author @anshul
 * @version 1.0 8/24/18
 */
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	/**
	 * 
	 * @param 
	 * Send the inputs to topic service layer for business logic implementation
	 * @return list of topic
	 */
	@RequestMapping(value = "/topics", method=RequestMethod.GET)
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	/**
	 * 
	 * @param Topic Id
	 * Send the inputs to topic service layer for business logic implementation
	 * @return topic
	 */
	@RequestMapping(value="/topics/{id}",method=RequestMethod.GET)
	public Topic getTopic(@PathVariable int id)
	{
		return topicService.getTopic(id);
	}
	
	/**
	 * 
	 * @param Topic Object
	 * Send the inputs to topic service layer for business logic implementation
	 * @return void
	 */
	@RequestMapping(value="/topics/add",method=RequestMethod.POST)	
	public void addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
	}
	
	/**
	 * 
	 * @param Topic Id,Topic Object
	 * Send the inputs to topic service layer for business logic implementation
	 * @return void
	 */
	@RequestMapping(value="/topics/{id}",method=RequestMethod.PUT)
	public void updateTopic(@PathVariable int id, @RequestBody Topic topic)
	{
		topicService.updateTopic(id,topic);
	}
	
	/**
	 * 
	 * @param Topic Id
	 * Send the inputs to topic service layer for business logic implementation
	 * @return void
	 */
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable int id) {
		topicService.deleteTopic(id);
	}
}
