package com.restApi.course.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	public static List<User> userList = new ArrayList<User>();
	
	private int id=106;
	
	static {
		
		userList.add(new User("vishal", LocalDateTime.now()));
		userList.add(new User("vikas", LocalDateTime.now()));
		userList.add(new User("ajith", LocalDateTime.now()));
		userList.add(new User("vissu", LocalDateTime.now()));
		userList.add(new User("sravan", LocalDateTime.now()));
	}

	public List<User> findAll(){
		
		return userList;
	}
	
	public User createUser(User user) {
		
		int updatedId= ++id;
		user.setId(updatedId);
		userList.add(user);
		
		return user;
	}
	
	public User getUserById(int id) {
		
		for(User user : userList) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User delete(int id) {
		
		for(User user : userList) {
			if(user.getId()==id) {
				userList.remove(user);
				return user;
			}
		}
		return null;
		
	}
	
	
	
	
	
}
