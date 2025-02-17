package com.evs.form;

import javax.validation.constraints.NotEmpty;

import com.evs.dto.BaseDTO;
import com.evs.dto.ElectionDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectionFrom extends BaseDTO {
	
	@NotEmpty(message = "Election Name is Required..")
	public String electionName;
	
	@NotEmpty(message = "Date is Required..")
	public String date;
	
	
	public ElectionDTO getDTO() {
		ElectionDTO bean=new ElectionDTO();
		bean.setId(id);
		
		bean.setElectionName(electionName);
		bean.setDate(date);

		return bean;
	}

	public void populate(ElectionDTO bean) {
		id = bean.getId();
		electionName = bean.getElectionName();
		date = bean.getDate();

	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}


}
