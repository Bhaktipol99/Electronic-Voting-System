package com.evs.form;


import javax.validation.constraints.NotEmpty;

import com.evs.dto.BaseDTO;
import com.evs.dto.CandidateDTO;
import com.evs.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateForm extends BaseDTO {

	@NotEmpty(message = "First Name is Required")
	private String firstName;

	@NotEmpty(message = "This Field is Required")
	private String lastName;
	
	@NotEmpty(message = "This Field is Required")
	private String gender;

	@NotEmpty(message = "This Field is Required")
	private String email;
	
	@NotEmpty(message = "This Field is Required")
	private String phoneNumber;
	

	private String partyId;
	

	
	public CandidateDTO getDTO() {
		CandidateDTO bean=new CandidateDTO();
		bean.setId(id);
		bean.setPartyId(DataUtility.getLong(partyId));
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setGender(gender);
		bean.setEmail(email);
		bean.setPhoneNumber(phoneNumber);
	

		return bean;
	}

	public void populate(CandidateDTO bean) {
		id = bean.getId();
		partyId = DataUtility.getStringData(bean.getPartyId());
		firstName=bean.getFirstName();
		lastName=bean.getLastName();
		gender = bean.getGender();
		email = bean.getEmail();
		phoneNumber = bean.getPhoneNumber();
		

	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
