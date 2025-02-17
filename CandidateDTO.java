package com.evs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="candidate")
@Getter
@Setter
public class CandidateDTO extends BaseDTO {
	
	@Column(name = "firstName", length = 755)
	private String firstName;

	@Column(name = "lastName", length = 755)
	private String lastName;
	
	@Column(name = "gender", length = 755)
	private String gender;

	@Column(name = "email", length = 755)
	private String email;
	
	
	@Column(name = "phoneNumber", length = 755)
	private String phoneNumber;
	
	@Column(name = "partyId")
	private long partyId;
	
	@Column(name = "partyName", length = 755)
	private String partyName;

	public long getPartyId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPartyName(Object partyName2) {
		// TODO Auto-generated method stub
		
	}

	public void setLastName(@NotEmpty(message = "This Field is Required") String lastName2) {
		// TODO Auto-generated method stub
		
	}

	public void setPhoneNumber(@NotEmpty(message = "This Field is Required") String phoneNumber2) {
		// TODO Auto-generated method stub
		
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty(message = "This Field is Required") String getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty(message = "This Field is Required") String getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}

	public void setPartyId(long long1) {
		// TODO Auto-generated method stub
		
	}

	public void setFirstName(@NotEmpty(message = "First Name is Required") String firstName2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(@NotEmpty(message = "This Field is Required") String email2) {
		// TODO Auto-generated method stub
		
	}

	public void setGender(@NotEmpty(message = "This Field is Required") String gender2) {
		// TODO Auto-generated method stub
		
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public @NotEmpty(message = "This Field is Required") String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty(message = "This Field is Required") String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
