package com.evs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evs.dao.VoterApplicationDAO;
import com.evs.dao.VoterDAO;
import com.evs.dto.VoteDTO;
import com.evs.dto.VoterApplicationDTO;
import com.evs.exception.RecordNotFoundException;
import com.evs.utility.DataUtility;

@Service
public class VoterService {
	
	
	@Autowired
	public VoterDAO dao;
	
	@Autowired
	public VoterApplicationDAO voterApplicationDAO;
	

	public VoteDTO Add(VoteDTO dto) {
		VoteDTO entity = null;
		entity = dao.findByVoterIdAndElectionId(dto.getVoterId(), dto.getElectionId());
	// System.out.println("shop By Name........: "+entity);
		 VoterApplicationDTO voterApplicationDTO = voterApplicationDAO.findByVoterIdNumber(DataUtility.getStringData(dto.getVoterId()));
	  // System.out.println("voterApplicationDTO: "+voterApplicationDTO.getVoterIdNumber());
	
	if(entity != null) {
		throw new RecordNotFoundException("Vote is already exists..");
	}else if( voterApplicationDTO == null) {
		throw new RecordNotFoundException("Voter id not exists..");
	}else {
		System.out.println("dto Before Save: "+dto);
	    entity = dao.save(dto);
	}
	    
       return  entity;
	
	}

	public VoteDTO findVoteById(long id) {
		return dao.findById(id);
	}
	
	
	public List<VoteDTO> list(){
		List<VoteDTO> dto = dao.findAll();
		return dto;
	}

	public void add(VoteDTO bean) {
		// TODO Auto-generated method stub
		
	}

}
