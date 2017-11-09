package com.rachna.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rachna.springbootstarter.topic.Topic;

//this is interface because we are probably going to do same method for every entity...like topic,course.
//CrudRepository(which_entity, datatype_of_Id) 
public interface CourseRepository extends CrudRepository<Course,String>{
	
//	public List<Course> findByName(String name); //find all courses by name
//	
//	public List<Course> findByDescription(String description); //find all curses based on description
	
	public List<Course> findByTopicId(String topicId);
	
	

}
