package com.amy.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amy.Entity.Question;
import com.amy.Repository.QuestionRepository;

@Service
public class QuestionServices {
	@Autowired
	QuestionRepository queRepo;
	
	//-----> ADD Q.
	public Question addNewQuestion(Question que) {
		return this.queRepo.save(que);
	}
	
	//-----> View Any Q.
	public Question getQuestionById(int id) {
		return this.queRepo.findById(id).orElse(null);
	}
	
	//-----> View All Q.
	public List<Question> getAllQuestions(){
		return this.queRepo.findAll();
	}
	//-----> Remove Any Q.
	public String deleteQuetionById(int id) {
		Question q = this.queRepo.findById(id).orElse(null);
		if(q != null) {
			this.queRepo.deleteById(id);
			return "Question Deleted with id "+id;
		}
		return "Question Not Deleted";
	}
	//-----> Update Any Q.
	public String updateQuestion(Question q) {
		Question qq = this.queRepo.findById(q.getQid()).orElse(null);
		if(qq != null) {
			qq.setQue_for_sender(q.getQue_for_sender());
			qq.setQue_for_reciver(q.getQue_for_reciver());
			qq.setOption_a(q.getOption_a());
			qq.setOption_a_image_link(q.getOption_a_image_link());
			qq.setOption_b_image_link(q.getOption_b_image_link());
			qq.setOption_c_image_link(q.getOption_c_image_link());
			qq.setOption_d_image_link(q.getOption_d_image_link());
			qq.setAns(q.getAns());
			this.queRepo.save(qq);
			return "Question Updated Successfully of id: "+q.getQid();
		}
		return "Question not updated of id: "+q.getQid();
	}
}