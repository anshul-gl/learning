package com.springboot.crud.app.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.app.entity.Course;
import com.springboot.crud.app.entity.Topic;
import com.springboot.crud.app.repository.CourseRepositiory;
import com.springboot.crud.app.repository.TopicRepositiory;

/**
 * CourseService.java
 * Purpose: Implements the CRUD functionality and interacts with repository 
 * @author @anshul
 * @version 1.0 8/24/18
 */
@Service //default Singleton
public class CourseService {
	
	@Autowired
	private CourseRepositiory courseRepository;
	
	@Autowired
	private TopicService topicService;
	
	/**
	 * 
	 * @param Topic Id
	 * Takes a Topic Id and fetch Topic object
	 * Fetch the course Ids array from topic object and calls course repository built in
	 * course by Id method on each id to fetch details of courses
	 * add these course information to arrays 
	 * @return list of course
	 */
	public List<Course> getAllCourses(int topicId)
	{
		try {
				List<Course> courses = new ArrayList<>();
				List<Integer> topicsIds = topicService.getTopic(topicId).getCourseIds();
				for(int id:topicsIds)
				{
					courses.add(getCourse(id));
				}
				return courses;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * @param Course Id
	 * Get the Course in database using repository built in method find by Id
	 * @return course
	 */
	public Course getCourse(int id)
	{
		try {
			
			return courseRepository.findById(id).get();
			//return Courses.stream().filter(t->t.getId().equals(id)).findFirst().get();
		}
		catch (Exception e) {
			return null;
		}
		 
	}
	/**
	 * 
	 * @param Topic Id, Course object
	 * Save the course in database using repository built in method save
	 * Fetch the topic object using the given topic id
	 * takes the course Ids list from the topic 
	 * Add a new course Id in list 
	 * Saves the topic object
	 * @return void
	 */
	public void addCourse(int topicId, Course course)
	{
		try {

			Topic topic = topicService.getTopic(topicId);
			List<Integer>courseArray = topic.getCourseIds();
			courseArray.add(course.getId());
			topic.setCourseIds(courseArray);
			topicService.updateTopic(topicId,topic);
			courseRepository.save(course);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * 
	 * @param Course Id, Course object
	 * Update the course in database using repository built in method save with only
	 * attributes in the request body and keeping others intact
	 * @return void
	 */	
	public void updateCourse(int id, Course course)
	{
		try {
			Course theCourse = getCourse(id);
			if (course.getName() != null){
				theCourse.setName(course.getName());
			}
			if(course.getDescription()!=null)
			{
				theCourse.setDescription(course.getDescription());
			}
			courseRepository.save(theCourse);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * 
	 * @param Course Id, Topic Id
	 * DELETE the course in database using repository built in method deleteById
	 * Fetch the topic object using the given topic id
	 * takes the course Ids list from the topic 
	 * Remove course Id in list 
	 * Saves the topic object
	 * @return void
	 */	
	public void deleteCourse(int id,int topicId)
	{
		{
			try {
				Topic theTopic = topicService.getTopic(topicId);
				System.out.println(theTopic.getName()+ ":"+ theTopic.getId()+":" + theTopic.getDescription()+theTopic.getCourseIds());
				List<Integer>courseArray = theTopic.getCourseIds();
				courseArray.remove(new Integer(id));
				theTopic.setCourseIds(courseArray);
				System.out.println(theTopic.getCourseIds());
				courseRepository.deleteById(id);
				topicService.updateTopic(topicId,theTopic);
				
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}	
	}
}
