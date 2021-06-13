package com.amy.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amy.Entity.Qlist;
import com.amy.Repository.QlistRepository;

@Service
public class QueListService {

	@Autowired
	QlistRepository qlRepo;
	
	//-----> Save
	public Qlist addNewQl(Qlist q) {
		return this.qlRepo.save(q);
	}
	
	//-----> Save [Ql]
	public List<Qlist> addAllQl(List<Qlist> ql){
		return this.qlRepo.saveAll(ql);
	}
	
	//-----> Find One
	public Qlist findOneById(int id) {
		return this.qlRepo.findById(id).orElse(null);
	}
	
	//-----> Find All
	public List<Qlist> findAllQl(){
		return this.qlRepo.findAll();
	}
	
	public String deleteQliById(int id) {
		Qlist q=this.qlRepo.findById(id).orElse(null);
		if(q != null) {
			this.qlRepo.deleteById(id);
			return "Deleted ...";
		}
		return "not found";
	}
	
	public String updateAnyQl(Qlist q) {
		Qlist qq=this.qlRepo.findById(q.getQlid()).orElse(null);
		if(qq != null) {
			qq.setQue_for_sender(q.getQue_for_sender());
			qq.setQue_for_reciver(q.getQue_for_reciver());
			qq.setOption_a(q.getOption_a());
			qq.setOption_a_image_link(q.getOption_a_image_link());
			qq.setOption_b_image_link(q.getOption_b_image_link());
			qq.setOption_c_image_link(q.getOption_c_image_link());
			qq.setOption_d_image_link(q.getOption_d_image_link());
			qq.setAdded_by(q.getAdded_by());
			this.qlRepo.save(qq);
			System.out.println("UPDATED----------------------------------------------------------");
			return "Question Updated Successfully of id: "+q.getQlid();
		}
		return "Question not found of id: "+q.getQlid();
	}
}
