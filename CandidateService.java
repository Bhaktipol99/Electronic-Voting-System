package com.evs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evs.dao.CandidateDAO;
import com.evs.dto.CandidateDTO;
import com.evs.exception.RecordNotFoundException;

@Service
public class CandidateService {

	@Autowired
	public CandidateDAO dao;
	

	public CandidateDTO Add(CandidateDTO dto) {
		CandidateDTO entity = null;
		entity = dao.findByEmail(dto.getEmail());
	// System.out.println("shop By Name........: "+entity);
	
	if(entity != null)
		throw new RecordNotFoundException("Candidate is already exists..");
	    System.out.println("dto Before Save: "+dto);
	    entity = dao.save(dto);
       return  entity;
	}
	


	public CandidateDTO findCandidateById(long id) {
		return dao.findById(id);
	}
	
	
	public List<CandidateDTO> list(){
		List<CandidateDTO> dto = dao.findAll();
		return dto;
	}
	
	public CandidateDTO update(CandidateDTO dto){
		CandidateDTO bean = dao.saveAndFlush(dto);
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



	public CandidateDTO findCandidateById(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
