package com.evs.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evs.dao.UserDAO;
import com.evs.dto.UserDTO;
import com.evs.exception.RecordNotFoundException;

@Service
public class UserService {

	@Autowired
	public UserDAO dao;

	public UserDTO Add(UserDTO dto) {
	UserDTO user = null;
	user = dao.findByEmail(dto.getEmail());
	System.out.println("user by email........: "+user);
	if(user != null)
		throw new RecordNotFoundException("Email is already exists..");
	    System.out.println("dto Before Save: "+dto);
	    user = dao.save(dto);
       return  user;
	}
	
	public UserDTO Login(String username, String password) {
		UserDTO user =	dao.findByEmailAndPassword(username, password);
		return user;
	}
	
	public UserDTO findUserById(long id) {
		return dao.findById(id);
	}
	
	public UserDTO findDeptById(long id) {
		return dao.findById(id);
	}
	
	public List<UserDTO> list(){
		List<UserDTO> dto = dao.findAll();
		return dto;
	}
	
	public UserDTO update(UserDTO dto){
		UserDTO bean = dao.saveAndFlush(dto);
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
	public List<UserDTO> searchByFirstName(String fname){
		List<UserDTO> dto = dao.findByFirstName(fname);
		return dto;
	}
}
