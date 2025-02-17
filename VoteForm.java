package com.evs.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.evs.dto.BaseDTO;
import com.evs.dto.UserDTO;
import com.evs.dto.VoteDTO;
import com.evs.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteForm extends BaseDTO {
	
	public String userId;
	
	public String electionId;
	
	public String candidateId;
	
	@Column(name = "voterId")
	public String voterId;
	
	public VoteDTO getDTO() {
		VoteDTO bean=new VoteDTO();
		bean.setId(id);
		bean.setUserId(DataUtility.getLong(userId));
		bean.setElectionId(DataUtility.getLong(electionId));
		bean.setCandidateId(DataUtility.getLong(candidateId));
		bean.setVoterId(DataUtility.getLong(voterId));

		return bean;
	}

	public void populate(VoteDTO bean) {
		id = bean.getId();
		userId = DataUtility.getStringData(bean.getUserId());
		electionId = DataUtility.getStringData(bean.getElectionId());
		candidateId = DataUtility.getStringData(bean.getCandidateId());
		voterId = DataUtility.getStringData(bean.getVoterId());
	}


}
