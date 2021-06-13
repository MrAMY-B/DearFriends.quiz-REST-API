package com.amy.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Friends {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int fid;
	private String f_name;
	private int uid;
	private String uname; 
	private String cque;
	private String myans;
	private int score;
	
	
	
}
