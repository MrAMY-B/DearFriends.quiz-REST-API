package com.amy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amy.Entity.Friends;
import com.amy.Services.FriendsService;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/friends")
public class FriendsController {
	
	@Autowired
	FriendsService frndService;
	
	//----> Add New F.
	@PostMapping("/add")
	public Friends addNewFriend(@RequestBody Friends friend) {
		return this.frndService.addNewFriend(friend);
	}
	
	//----> Find F.
	@GetMapping("/find/{id}")
	public Friends findFriendById(@PathVariable(value = "id")int id) {
		return this.frndService.findFriendById(id);
	}
	
	//----> Find All F
	@GetMapping("/find-all")
	public List<Friends> findAllFrinds(){
		return this.frndService.getAllFriends();
	}

	//----->Find all by Candidate Id
	@GetMapping("/find-by-candi/{id}")
	public List<Friends> findFriendByCandidateId(@PathVariable(value = "id")int id) {
		return this.frndService.getAllFriendsByCandiId(id);
	}
	
	//----> Delete F 
	@DeleteMapping("/delete/{id}")
	public String deleteFriendById(@PathVariable (value = "id" ) int id) {
		return this.frndService.deleteAnyFriendById(id);
	}
	
	
	
}
