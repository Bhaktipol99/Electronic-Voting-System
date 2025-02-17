package com.evs.form;

import javax.validation.constraints.NotEmpty;

import com.evs.dto.BaseDTO;
import com.evs.dto.VoterApplicationDTO;
import com.evs.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoterApplicationFrom extends BaseDTO {
	
	
	@NotEmpty(message = "First Name is Required")
	private String firstName;

	@NotEmpty(message = "This Field is Required")
	private String lastName;

	@NotEmpty(message = "This Field is Required")
	private String email;
	
	@NotEmpty(message = "This Field is Required")
	private String phoneNumber;
	
	private String userId;
	
	public VoterApplicationDTO getDTO() {
		VoterApplicationDTO bean=new VoterApplicationDTO();
		bean.setId(id);
		bean.setUserId(DataUtility.getLong(userId));
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmail(email);
		bean.setPhoneNumber(phoneNumber);
		
		return bean;
	}

	public void populate(VoterApplicationDTO bean) {
		
		id = bean.getId();
		userId = DataUtility.getStringData(bean.getUserId());
		firstName=bean.getFirstName();
		lastName=bean.getLastName();
		email = bean.getEmail();
		phoneNumber = bean.getPhoneNumber();

	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
