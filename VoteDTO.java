package com.evs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="vote")
@Getter
@Setter
public class VoteDTO extends BaseDTO  {
	
	@Column(name = "userId")
	public long userId;
	
	@Column(name = "electionId")
	public long electionId;
	
	@Column(name = "candidateId")
	public long candidateId;
	
	@Column(name = "voterId")
	public long voterId;
	
	@Column(name = "status")
	public long status;

	public void setStatus(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setVoterId(long long1) {
		// TODO Auto-generated method stub
		
	}

	public void setElectionId(long long1) {
		// TODO Auto-generated method stub
		
	}

	public void setCandidateId(long long1) {
		// TODO Auto-generated method stub
		
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}

	public Object getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getElectionId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCandidateId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserId(long long1) {
		// TODO Auto-generated method stub
		
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getVoterId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
