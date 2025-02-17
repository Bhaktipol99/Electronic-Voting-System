package com.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evs.dto.CandidateDTO;

public interface CandidateDAO extends JpaRepository<CandidateDTO, Long> {
	
	public CandidateDTO findById(long id);
	public CandidateDTO findByPartyName(String partyName);
	public CandidateDTO findByEmail(String email);
}
