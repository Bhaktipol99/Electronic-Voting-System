package com.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evs.dto.VoterApplicationDTO;

public interface VoterApplicationDAO extends JpaRepository<VoterApplicationDTO, Long> {
	
	public VoterApplicationDTO findById(long id);
	public VoterApplicationDTO findByUserId(long id);
	public VoterApplicationDTO findByEmail(String email);
	public VoterApplicationDTO findByVoterIdNumber(String id);
	
	

}
