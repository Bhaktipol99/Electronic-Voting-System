package com.evs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="party")
@Getter
@Setter
public class PartyDTO extends BaseDTO {
	
	@Column(name = "partyName", length = 755)
	private String partyName;
	
	@Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

	public @NotEmpty(message = "Party Name is Required..") Object getPartyName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPartyName(@NotEmpty(message = "Party Name is Required..") @NotEmpty(message = "Party Name is Required..") Object partyName2) {
		// TODO Auto-generated method stub
		
	}

	public void setImage(byte[] bytes) {
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

	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
