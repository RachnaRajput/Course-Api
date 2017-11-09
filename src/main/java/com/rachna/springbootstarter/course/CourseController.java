package com.rachna.springbootstarter.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rachna.springbootstarter.topic.Topic;

//step12: making it a controller...
@RestController
public class CourseController {
	//step23: add annotation @Autowired to tell that this need a dependency injection.
	@Autowired
	//step22: make a private instance of service.
	private CourseService courseService;
	
	//step13: create a function which returns all topics...
	//step14: annotate this function with the RequestMapping
	//step15: creating a class Topic and hardcoding toics in it...
	//step16: what is bill of material...for answer go to step 17 in pom.xml...
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourse(@PathVariable String id) {
		System.out.println("in get all courses");
		return courseService.getAllCourse(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}") //not worry about topicId because we know course id is PK.
	public Course getACourse(@PathVariable String id) {
//		System.out.println("get a topic");
		return courseService.getACourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		//what we want to do is: get the request body..convert it to Topic and pass to service
		courseService.addCourse(course);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);		
	}

}
