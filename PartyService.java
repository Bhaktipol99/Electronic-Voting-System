package com.evs.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evs.dao.PartyDAO;
import com.evs.dto.PartyDTO;
import com.evs.exception.RecordNotFoundException;



@Service
public class PartyService {

	@Autowired
	public PartyDAO dao;
	

	public PartyDTO Add(PartyDTO dto) {
		PartyDTO entity = null;
		entity = dao.findByPartyName(dto.getPartyName());
	// System.out.println("shop By Name........: "+entity);
	
	if(entity != null)
		throw new RecordNotFoundException("Party is already exists..");
	    System.out.println("dto Before Save: "+dto);
	    entity = dao.save(dto);
       return  entity;
	}
	


	public PartyDTO findPartyById(long id) {
		return dao.findById(id);
	}
	
	
	public List<PartyDTO> list(){
		List<PartyDTO> dto = dao.findAll();
		return dto;
	}
	
	public PartyDTO update(PartyDTO dto){
		PartyDTO bean = dao.saveAndFlush(dto);
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
		PartyDTO logo = dao.findById(id);
		byte[] blob = logo.getImage();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}
}
