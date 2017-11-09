package com.rachna.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.rachna.springbootstarter.topic.Topic;

//step 16: generating pojo for topic..
@Entity
public class Course {
	@Id
	private String id;
	private String name;
	private String description;
	
	//tie this course to particular topic...

	@ManyToOne
	private Topic topic;
	

	public Course() {
		
	}

	public Course(String id, String name, String description, String topicId){
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId,"","");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

}