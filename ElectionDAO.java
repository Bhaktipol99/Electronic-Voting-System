package com.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evs.dto.ElectionDTO;


public interface ElectionDAO  extends JpaRepository<ElectionDTO, Long>{

	
	public ElectionDTO findById(long id);
	public ElectionDTO findByElectionName(String ename);
	public ElectionDTO findByDate(String date);
}
