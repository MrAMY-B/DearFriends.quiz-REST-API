package com.amy.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qlist {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int qlid;
	private String que_for_sender;
	private String que_for_reciver;
	private String option_a;
	private String option_a_image_link;
	private String option_b;
	private String option_b_image_link;
	private String option_c;
	private String option_c_image_link;
	private String option_d;
	private String option_d_image_link;
	private String added_by;
	
}
