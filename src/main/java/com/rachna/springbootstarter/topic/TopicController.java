package com.rachna.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//step12: making it a controller...
@RestController
public class TopicController {
	//step23: add annotation @Autowired to tell that this need a dependency injection.
	@Autowired
	//step22: make a private instance of service.
	private TopicService topicService;
	
	//step13: create a function which returns all topics...
	//step14: annotate this function with the RequestMapping
	//step15: creating a class Topic and hardcoding toics in it...
	//step16: what is bill of material...for answer go to step 17 in pom.xml...
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getATopic(@PathVariable String id) {
//		System.out.println("get a topic");
		return topicService.getATopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/topics")
	public void addTopic(@RequestBody Topic topic) {
		//what we want to do is: get the request body..convert it to Topic and pass to service
		topicService.addTopic(topic);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);		
	}

}
