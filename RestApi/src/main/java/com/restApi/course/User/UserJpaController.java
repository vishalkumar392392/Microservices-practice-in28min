package com.restApi.course.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.course.exception.UserNotFoundException;

@RestController
@RequestMapping("/api")
public class UserJpaController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/users")
	public List<User> findAllUsers() {

		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable int id) {

		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("user not found ");
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		userRepository.save(user);

		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {

		userRepository.deleteById(id);
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> findAllPosts(@PathVariable int id) {

		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("user not found ");
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<User> createPost(@PathVariable int id,@RequestBody Post post) {

		Optional<User> userOption = userRepository.findById(id);

		if (!userOption.isPresent()) {
			throw new UserNotFoundException("user not found ");
		}
        
		User user = userOption.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		return ResponseEntity.ok().body(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
