package com.springboot.crud.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.app.entity.Course;
import com.springboot.crud.app.entity.Topic;
import com.springboot.crud.app.services.CourseService;

/**
 * CourseController.java
 * Purpose: controls the data flow of courses into model object and 
 * 			updates the API whenever data changes or fetched 
 * @author @anshul
 * @version 1.0 8/24/18
 */

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	/**
	 * 
	 * @param Topic Id, Course object
	 * Send the inputs to course service layer for business logic implementation
	 * @return void
	 */
	@RequestMapping(value="/topics/{topicId}/courses/",method=RequestMethod.POST)	
	public void addCourse(@PathVariable int topicId, @RequestBody Course course)
	{
		System.out.println("In add course");
		courseService.addCourse(topicId,course);
	}

	/**
	 * 
	 * @param Course Id, Topic Id, Course object
	 * Send the inputs to course service layer for business logic implementation
	 * @return void
	 */
	@RequestMapping(value="/topics/{topicId}/courses/{id}",method=RequestMethod.PUT)
	public void updateCourse(@PathVariable int id, @PathVariable int topicId, @RequestBody Course course)
	{
		courseService.updateCourse(id,course);
	}
	
	/**
	 * 
	 * @param Course Id, Topic Id
	 * Send the inputs to course service layer for business logic implementation
	 * @return void
	 */
	@RequestMapping(value="/topics/{topicId}/courses/{id}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable int id,@PathVariable int topicId) {
		System.out.println(id + " " + topicId);
		courseService.deleteCourse(id,topicId);
	}
	
	/**
	 * 
	 * @param  Topic Id
	 * Send the inputs to course service layer for business logic implementation
	 * @return List of Course
	 */
	@RequestMapping(value="/topics/{id}/courses",method=RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable int id)
	{
		return courseService.getAllCourses(id);
	}
	
	/**
	 * 
	 * @param Course Id
	 * Send the inputs to course service layer for business logic implementation
	 * @return list of courses
	 */
	@RequestMapping(value="/topics/{topicId}/courses/{id}",method=RequestMethod.GET)
	public Course getCourse(@PathVariable int id)
	{
		System.out.println("In get course");
		return courseService.getCourse(id);
	}
	
}
