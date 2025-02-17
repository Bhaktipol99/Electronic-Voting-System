package com.evs.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evs.dao.CandidateDAO;
import com.evs.dao.VoterApplicationDAO;
import com.evs.dto.CandidateDTO;
import com.evs.dto.PartyDTO;
import com.evs.dto.UserDTO;
import com.evs.dto.VoterApplicationDTO;
import com.evs.exception.RecordNotFoundException;

@Service
public class VoterApplicationService {
	
	@Autowired
	public VoterApplicationDAO dao;
	
	public VoterApplicationDTO Add(VoterApplicationDTO dto) {
		
		VoterApplicationDTO voterApplicationDTO = null;
		voterApplicationDTO = dao.findByEmail(dto.getEmail());
		//System.out.println("user by email........: "+user);
		if(voterApplicationDTO != null)
			throw new RecordNotFoundException("Already applied for it...");
		    System.out.println("dto Before Save: "+dto);
		    voterApplicationDTO = dao.save(dto);
       return  voterApplicationDTO;
	}

	public VoterApplicationDTO findVoterApplicationById(long id) {
		return dao.findById(id);
	}
		
	public List<VoterApplicationDTO> list(){
		List<VoterApplicationDTO> dto = dao.findAll();
		return dto;
	}
	

	
	public VoterApplicationDTO update(VoterApplicationDTO dto){
		VoterApplicationDTO bean = dao.saveAndFlush(dto);
		return bean;
	}
	
	public void delete(long id) throws Exception {
		if(id>0)
		{
			dao.deleteById(id);
		}else {
			throw new Exception("Not a valid id");
		}
	}
	
	public Blob getImageById(long id) throws SerialException, SQLException {		
		VoterApplicationDTO logo = dao.findById(id);
		byte[] blob = logo.getImage();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}

}
