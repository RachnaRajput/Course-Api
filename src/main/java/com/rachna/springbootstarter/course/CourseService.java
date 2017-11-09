//Step19: In spring BusinessServices are generally singleton. when application starts up, 
//spring create an instance of this service and keeps that in its memory

package com.rachna.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

//Step20: Using an annotation @Service to tell spring that this is service
//step21: Now lets say TopicController wants the instance of this service...go to tOPIC CONTROLLER.
@Service
public class CourseService {
	//getting the instnce of crud repository in service..
	@Autowired
	private CourseRepository courseRepository;
//	List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("Spring","Spring Framework","Spring description"),
//			new Topic("JAVA","JAVA Framework","JAVA description"),
//			new Topic("Python","PyCharm ","Python description"),
//			new Topic("Mysql","Oracle mysql","mysql description"),
//			new Topic("JavaScript","JavaScript Framework","JavaScript description")
//			));
	
	public List<Course> getAllCourse(String topicId){
		
    	List<Course>courses = new ArrayList<Course>();
    	courseRepository.findByTopicId(topicId)
    	.forEach(courses::add);
		return courses;
	}
	
	
	public Course getACourse(String id) {
		return courseRepository.findOne(id);
	}
	
	
	public void addCourse(Course add_course) {
		courseRepository.save(add_course);

	}
	
	public void updateCourse(Course new_course) {
		courseRepository.save(new_course);// if row doesnot exist..means it has to insert but if row exist then means update
	}
	
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
		

}
