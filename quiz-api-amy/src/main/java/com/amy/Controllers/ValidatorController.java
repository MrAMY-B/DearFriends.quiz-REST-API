package com.amy.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amy.Entity.Admin;
import com.amy.Entity.Candidate;
import com.amy.Entity.UserCookie;
import com.amy.Services.CandidateService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/validate")
public class ValidatorController {
	
	@Autowired
	CandidateService candSer;
	
	@PostMapping("/user-cookie")
	public String validateUserCookie(@RequestBody UserCookie cookie) {
		Candidate candidate= this.candSer.findById(cookie.getId());
		if(candidate.getCid()==cookie.getId() && candidate.getToken().equals(cookie.getToken()) && candidate.getName().equals(cookie.getName()))
			return "true";
		
		return "false";
	}
	@PostMapping("/tmcbcmcgkb")
	public boolean validateMyCookie(@RequestBody UserCookie cookie) {
		Candidate candidate= this.candSer.findById(cookie.getId());
		if(candidate.getCid()==cookie.getId() && candidate.getToken().equals(cookie.getToken()) && candidate.getName().equals(cookie.getName()))
			return true;
		
		return false;
	}
	
	@PostMapping("/admin")
	public boolean adminValidate(@RequestBody Admin admin) {
		if(admin.getName().equals("MrAMY") && admin.getPassw().equals("zXXXXXXXXXXXXXXXXXXd"))
			return true;
		
		return false;
	}

}
