package com.amy.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String name;
	private String token;
	@OneToMany(targetEntity = Question.class, cascade = CascadeType.ALL )
	private List<Question> questions;
	private String myque;
}
