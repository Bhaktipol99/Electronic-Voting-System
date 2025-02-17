package com.evs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="voterapplication")
@Getter
@Setter
public class VoterApplicationDTO extends BaseDTO {
	
	@Column(name = "userId")
	public long userId;
	
	@Column(name = "firstName", length = 755)
	private String firstName;

	@Column(name = "lastName", length = 755)
	private String lastName;

	@Column(name = "email", length = 755)
	private String email;

	@Column(name = "phoneNumber", length = 755)
	private String phoneNumber;
	
	@Column(name = "voterIdNumber", length = 755)
	private String voterIdNumber;
	
	@Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

	public void setVoterIdNumber(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setUserId(long long1) {
		// TODO Auto-generated method stub
		
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte[] getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setImage(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}

	public @NotEmpty(message = "First Name is Required") String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}

	public void setFirstName(@NotEmpty(message = "First Name is Required") String firstName2) {
		// TODO Auto-generated method stub
		
	}

	public void setLastName(@NotEmpty(message = "This Field is Required") String lastName2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(@NotEmpty(message = "This Field is Required") String email2) {
		// TODO Auto-generated method stub
		
	}

	public void setPhoneNumber(@NotEmpty(message = "This Field is Required") String phoneNumber2) {
		// TODO Auto-generated method stub
		
	}

	public @NotEmpty(message = "This Field is Required") String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty(message = "This Field is Required") String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty(message = "This Field is Required") String getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
