package com.springboot.crud.app.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.crud.app.LearningRepositoryApplication;
import com.springboot.crud.app.entity.Topic;
import com.springboot.crud.app.repository.TopicRepositiory;
import com.springboot.crud.app.services.TopicService;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = TopicController.class, secure = false)
public class TopicControllerTest {
//	
//	@Autowired
//	private MockMvc mockMvc;

//	@MockBean
//	private TopicService topicService;
	
	@Test
	public void getTopicsRepository_basic() throws Exception {
		
		TopicRepositiory mockRepository = mock(TopicRepositiory.class);
		Topic topic = new Topic(4,"python","complete course for beginners");
		
		when (mockRepository.findById(101)).thenReturn(Optional.of(topic));
		assertEquals(topic, mockRepository.findById(101).get());
	}
	
	@Test
	public void getTopicsService_basic() throws Exception {
		
		TopicService mockService = mock(TopicService.class);
		
		Topic topic = new Topic(4,"python","complete course for beginners");
		
		when (mockService.getTopic(108)).thenReturn(topic);
		assertEquals(topic, mockService.getTopic(108));

	}
	
	@Test
	public void getTopicsController_basic() throws Exception {
		
		TopicController mockController = mock(TopicController.class);
		
		Topic topic = new Topic(4,"python","complete course for beginners");
		
		when (mockController.getTopic(108)).thenReturn(topic);
		assertEquals(topic, mockController.getTopic(108));

	}
			
		
		//call "/hello-world"
//		RequestBuilder request = MockMvcRequestBuilders
//				.get("/topics")
//				.accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(request).andExpect(status().is(200)).andReturn();
//		assertEquals("Hello World", result.getResponse().getContentAsString());
//		
//		//verify "Hello World"/		
//	}

}

