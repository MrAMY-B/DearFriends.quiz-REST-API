package com.amy.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amy.Entity.Friends;
import com.amy.Repository.FriendRepository;


@Service
public class FriendsService {
	
	@Autowired
	FriendRepository frndRepo;
	
	//----> Add New F.
	public Friends addNewFriend(Friends friend) {
		return this.frndRepo.save(friend);
	}
	
	//----> Find Any F.
	public Friends findFriendById(int id) {
		return this.frndRepo.findById(id).orElse(null);
	}

	//----> Find All F by Candidate Id
	public List<Friends> getAllFriendsByCandiId(int id){
		List<Friends> frList = new ArrayList<Friends>();
		List<Friends> tList = this.frndRepo.findAll();
		for (Friends friends : tList) {
			if(friends.getUid()==id) {
				frList.add(friends);
			}
		}
		return frList;
	}
	
	//----> Get list of all F.
	public List<Friends> getAllFriends(){
		return this.frndRepo.findAll();
	}
	
	//----> Delete any F
	public String deleteAnyFriendById(int id) {
		Friends f = this.frndRepo.findById(id).orElse(null);
		if(f != null) {
			this.frndRepo.deleteById(id);
			return "Reciver Friend Record DELETE.";
		}
		return "Friends Record Doesnt Exist of id: "+id;
	}
	

}

