package com.amy.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amy.Entity.Candidate;
import com.amy.Repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	CandidateRepository candRepo;
	
	//------> Add
	public Candidate addNewCandidate(Candidate candidate) {
		return this.candRepo.save(candidate);
	}
	
	//-------> Get All
	public List<Candidate> getAllCandidate(){
		return this.candRepo.findAll();
	}
	
	//--------> Find One By Id
	public Candidate findById(int id ) {
		return this.candRepo.findById(id).orElse(null);
	}
	
	//-------->delete by Id
	public String removeById(int id) {
		Candidate c = this.candRepo.findById(id).orElse(null);
		if(c != null) {
			this.candRepo.deleteById(id);
			return "Deleted";
		}
		return "Not Found";
	}
	
	
}
