package com.examples.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examples.rest.webservices.restfulwebservices.user.exception.PostNotFoundException;
import com.examples.rest.webservices.restfulwebservices.user.exception.UserNotFoundException;
import com.examples.rest.webservices.restfulwebservices.user.post.Post;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@GetMapping("/users/{id}")
	public Resource<User> getUserById(@PathVariable int id) {
		User user = userDao.findById(id);
		
		Resource<User> resource = buildUserResource(user);
		
		if(user == null){
			throw new UserNotFoundException(String.format("user id %s not found", id));
		}
		
		return resource;
	}

	@DeleteMapping("/users/{id}")
	public Resource<User> removeUserById(@PathVariable Integer id){
		User user = userDao.removeById(id);
		
		Resource<User> resource = buildUserResource(user);
		
		if(user == null){
			throw new UserNotFoundException(String.format("user id %s not found", id));
		}
		
		return resource;
	}

	private Resource<User> buildUserResource(User user) {
		Resource<User> resource = new Resource<User>(user);
		Link allUsersLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserController.class).getAllUsers()).withRel("all-users");
		Link allUserPostsLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserController.class, user.getId()).getAllUserPosts(user.getId())).withRel("all-user-posts");
		resource.add(allUsersLink, allUserPostsLink);
		return resource;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User createdUser = userDao.add(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getAllUserPosts(@PathVariable Integer id){
		User user = userDao.findById(id);
		if(user == null){
			throw new UserNotFoundException(String.format("user id %s not found", id));
		}
		return user.getPosts();
	}
	
	@GetMapping("/users/{id}/posts/{post_id}")
	public Post getUserPostById(@PathVariable Integer id, @PathVariable("post_id") Integer postId){
		User user = userDao.findById(id);
		if(user == null){
			throw new UserNotFoundException(String.format("user id %s not found", id));
		}
		List<Post> posts = user.getPosts();
		Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().orElse(null);
		if(post == null){
			throw new PostNotFoundException(String.format("post with id %s doesn't exist for user %s", postId, id));
		}
		return post;
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Post> addPostToUser(@PathVariable Integer id, @Valid @RequestBody Post post){
		User user = userDao.findById(id);
		if(user == null){
			throw new UserNotFoundException(String.format("user id %s not found", id));
		}
		user.getPosts().add(post);
		URI newPostUri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{post_id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(newPostUri).build();
	}
}
