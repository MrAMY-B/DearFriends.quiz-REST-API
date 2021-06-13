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

import com.amy.Entity.Candidate;
import com.amy.Entity.UserCookie;
import com.amy.Services.CandidateService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/candi")
public class CandidateController {
	
	@Autowired
	CandidateService candSer;
	//------> Adding
		@PostMapping("/add")
		public Candidate addNewCandidate(@RequestBody Candidate candidate) {
			return this.candSer.addNewCandidate(candidate);
		}
		
		//------> Get All
		@GetMapping("/find-all")
		public List<Candidate> getAllCandidate(){
			return this.candSer.getAllCandidate();
		}
		
		//------> Find One
		@GetMapping("/find/{id}")
		public Candidate getCandidateById(@PathVariable (value = "id")int id) {
			return this.candSer.findById(id);
		}
		
		
		//------> Delete by id
		@DeleteMapping("/delete/{id}")
		public String deleteCandidateById(@PathVariable(value = "id")int id) {
			return this.candSer.removeById(id);
		}

		@PostMapping("/user-cookie")
		public String validateUserCookie(@RequestBody UserCookie cookie) {
		Candidate candidate= this.candSer.findById(cookie.getId());
		if(candidate.getCid()==cookie.getId() && candidate.getToken().equals(cookie.getToken()) && candidate.getName().equals(cookie.getName()))
			return "true";
		
		return "false";
	}

}
