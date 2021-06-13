package com.amy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amy.Entity.Visitors;
import com.amy.Repository.VisitorsRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/visitors")
public class VisitorsController {

	@Autowired
	private VisitorsRepository visiRepo;
	
	@PostMapping("/add-new")
	public boolean addNewVisitor(@RequestBody Visitors v) {
		Visitors visi = this.visiRepo.save(v);
		if(visi!=null)
			return true;
		
		return false;
	}

	@GetMapping("/find-all")
	public List<Visitors> getAllVisitors(){
		return this.visiRepo.findAll();
	}
}
