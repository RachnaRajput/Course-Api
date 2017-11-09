//Step19: In spring BusinessServices are generally singleton. when application starts up, 
//spring create an instance of this service and keeps that in its memory

package com.rachna.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

//Step20: Using an annotation @Service to tell spring that this is service
//step21: Now lets say TopicController wants the instance of this service...go to tOPIC CONTROLLER.
@Service
public class TopicService {
	//getting the instnce of crud repository in service..
	@Autowired
	private TopicRepository topicRepository;
//	List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("Spring","Spring Framework","Spring description"),
//			new Topic("JAVA","JAVA Framework","JAVA description"),
//			new Topic("Python","PyCharm ","Python description"),
//			new Topic("Mysql","Oracle mysql","mysql description"),
//			new Topic("JavaScript","JavaScript Framework","JavaScript description")
//			));
	
	public List<Topic> getAllTopics(){
		
    	List<Topic>topics = new ArrayList<Topic>();
    	topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	
	public Topic getATopic(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();  //lamda notation.....
//		for(Topic topic: topics) {
//			if(topic.getId().equals(id))
//				return topic;
//		}
		return topicRepository.findOne(id);
//		return null;
	}
	public void addTopic(Topic add_topic) {
		topicRepository.save(add_topic);

//		topics.add(add_topic);
	}
	
	public void updateTopic(Topic new_topic) {
//		for(int i = 0; i <topics.size();i++) {
//			Topic topic = topics.get(i);
//			if(topic.getId().equals(id)) {
//				topics.set(i, new_topic);
//			}
//		}
		topicRepository.save(new_topic);// if row doesnot exist..means it has to insert but if row exist then means update
	}
	
	public void deleteTopic(String id) {
		// topics.removeIf(t -> t.getId().equals(id)); //lamda notation
//		System.out.print("delete service");
//		for(int i =0; i <topics.size(); i++) {
//			Topic topic = topics.get(i);
//			if(topic.getId().equals(id))
//				topics.remove(i);
//		}
//		return;
		topicRepository.delete(id);
	}
		

}
