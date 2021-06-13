package com.amy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amy.Entity.Qlist;
import com.amy.Services.QueListService;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quelist")
public class QueListController {
	
	@Autowired
	QueListService qlService;
	
	@PostMapping("/add")
	public Qlist addNewQue(@RequestBody Qlist q) {
		return this.qlService.addNewQl(q);
	}
	
	@PostMapping("/add-all")
	public List<Qlist> addAllQue(@RequestBody List<Qlist> qlist){
		return this.qlService.addAllQl(qlist);
	}
	
	@GetMapping("/find/{id}")
	public Qlist findOneQue(@PathVariable(value = "id")int id) {
		return this.qlService.findOneById(id);
	}
	
	@GetMapping("/find-all")
	public List<Qlist> getAllQueList(){
		return this.qlService.findAllQl();
	}
	
	@PutMapping("/update")
	public String updateAnyQue(@RequestBody Qlist q) {
		return this.qlService.updateAnyQl(q);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAnyQue(@PathVariable (value = "id") int id) {
		return this.qlService.deleteQliById(id);
	}
	
	
}












