package com.examples.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.examples.rest.webservices.restfulwebservices.user.post.Post;

@Repository
public class UserDao {
	
	private static List<User> users = new ArrayList<User>();
	
	static{
		users.add(new User(1, "Delia", LocalDate.of(1984, Month.FEBRUARY, 10),  new ArrayList<Post>(Arrays.asList(new Post(1, "post 1"), new Post(2, "post 2")))));
		users.add(new User(2, "Robert", LocalDate.of(1982, Month.DECEMBER, 17), null));
		users.add(new User(3, "Catalin", LocalDate.of(1985, Month.JULY, 11), null));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id){
		return users.stream().filter(user -> id == user.getId()).findFirst().orElse(null);
	}
	
	public User removeById(int id){
		User user = findById(id);
		if(user != null){
			users.remove(user);
			return user;
		}
		return null;
	}
	
	public User add(User user){
		if(user.getId() == null){
			user.setId(users.size() + 1);
		}
		users.add(user);
		return user;
	}
}
