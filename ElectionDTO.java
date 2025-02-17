package com.evs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="election")
@Getter
@Setter
public class ElectionDTO extends BaseDTO {

	@Column(name = "electionName", length = 755)
	private String electionName;
	
	@Column(name = "date", length = 755)
	private String date;

	public @NotEmpty(message = "Date is Required..") String getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setElectionName(@NotEmpty(message = "Election Name is Required..") String electionName2) {
		// TODO Auto-generated method stub
		
	}

	public void setDate(@NotEmpty(message = "Date is Required..") String date2) {
		// TODO Auto-generated method stub
		
	}

	public @NotEmpty(message = "Election Name is Required..") String getElectionName() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
