package com.restApi.course.User;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.course.exception.UserNotFoundException;

@RestController
public class UserController {
	
	@Autowired
	private UserDao service;
	
	@GetMapping("/users")
	public List<User> findAll(){
		
		return service.findAll();
	}

	@GetMapping(path="/users/{id}")
	public User getUserById(@PathVariable(value="id") int id) throws Exception {
		User us =  service.getUserById(id);
		if(us==null) {
			throw new UserNotFoundException("id: "+id);
		}
		
		
		/*
		 * EntityModel<User> resource = new EntityModel<User>(us); ControllerLinkBuilder
		 * linkTo= ControllerLinkBuilder.linkTo(getClass(), findAll());
		 * resource.add(linkTo.withRel("all-users"));
		 */
		return us;
		
	}
	
	@PostMapping(path="/users")
	public User create(@Valid @RequestBody User user) {
		
		return service.createUser(user);
	}
	
	@DeleteMapping(path="/users/{id}")
	public ResponseEntity<User> delete(@PathVariable int id) throws Exception{
		
		User us = service.delete(id);
		if(us==null) {
			throw new Exception("id"+id);
		}
		return ResponseEntity.ok().body(us);
	}
}
