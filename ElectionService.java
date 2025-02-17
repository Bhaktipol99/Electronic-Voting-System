package com.evs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evs.dao.ElectionDAO;
import com.evs.dto.ElectionDTO;
import com.evs.exception.RecordNotFoundException;

@Service
public class ElectionService {
	
	@Autowired
	public ElectionDAO dao;
	

	public ElectionDTO Add(ElectionDTO dto) {
		ElectionDTO entity = null;
		entity = dao.findByElectionName(dto.getElectionName());
	// System.out.println("shop By Name........: "+entity);
	
	if(entity != null)
		throw new RecordNotFoundException("Election is already exists..");
	    System.out.println("dto Before Save: "+dto);
	    entity = dao.save(dto);
       return  entity;
	}
	


	public ElectionDTO findElectionById(long id) {
		return dao.findById(id);
	}
	
	
	public List<ElectionDTO> list(){
		List<ElectionDTO> dto = dao.findAll();
		return dto;
	}
	
	public ElectionDTO update(ElectionDTO dto){
		ElectionDTO bean = dao.saveAndFlush(dto);
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

}
