package com.rachna.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

//this is interface because we are probably going to do same method for every entity...like topic,course.
//CrudRepository(which_entity, datatype_of_Id) 
public interface TopicRepository extends CrudRepository<Topic,String>{
	
	
	//getAllTopics()
	//getATopic(String id)
	//addTopic()
	//updateTopic(Topic t)
	//deleteTopic(String id)
	

}
