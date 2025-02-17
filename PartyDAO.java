package com.evs.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.evs.dto.PartyDTO;


public interface PartyDAO extends JpaRepository<PartyDTO, Long>{

	
	public PartyDTO findById(long id);
	public PartyDTO findByPartyName(String fname);
	public PartyDTO findByPartyName(Object partyName);
}
