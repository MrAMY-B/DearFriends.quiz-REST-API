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

import com.amy.Entity.Question;
import com.amy.Services.QuestionServices;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/questions")
public class QuestionController {
		
	@Autowired
	QuestionServices queService;

	//------> Adding
	@PostMapping("/add")
	public Question addNewQuestion(@RequestBody Question que) {
		return this.queService.addNewQuestion(que);
	}
	
	//------> Get All
	@GetMapping("/find-all")
	public List<Question> getAllQuestion(){
		return this.queService.getAllQuestions();
	}
	
	//------> Find One
	@GetMapping("/find/{id}")
	public Question getQuestionById(@PathVariable (value = "id")int id) {
		return this.queService.getQuestionById(id);
	}
	
	
	//------> Delete by id
	@DeleteMapping("/delete/{id}")
	public String deleteQuetionById(@PathVariable(value = "id")int id) {
		return this.queService.deleteQuetionById(id);
	}
	
	//-----> Update Q.
	@PutMapping("/update")
	public String updateQuestion(@RequestBody Question que) {
		return this.queService.updateQuestion(que);
	}
}