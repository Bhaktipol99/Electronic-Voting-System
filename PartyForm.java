package com.evs.form;


import javax.validation.constraints.NotEmpty;

import com.evs.dto.BaseDTO;
import com.evs.dto.PartyDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartyForm extends BaseDTO{

	@NotEmpty(message = "Party Name is Required..")
	public Object partyName;
	
	public PartyDTO getDTO() {
		PartyDTO bean=new PartyDTO();
		bean.setId(id);
		
		bean.setPartyName(partyName);

		return bean;
	}

	public void populate(PartyDTO bean) {
		id = bean.getId();
		partyName = (@NotEmpty(message = "Party Name is Required..") Object) bean.getPartyName();

	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
