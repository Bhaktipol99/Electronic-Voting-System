package com.evs.ctl;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.evs.dto.UserDTO;
import com.evs.exception.RecordNotFoundException;
import com.evs.form.UserForm;
import com.evs.service.UserService;

@Controller
public class UserCtl {
	
	@Autowired
	public UserService service;

	
	@GetMapping("/registration")
	public String RegistrationPage(@ModelAttribute("form")UserForm form, Model model) {

		return "registration";
	}
	
	@PostMapping("/AddUser")
	public String Add(@Valid @ModelAttribute("form")UserForm form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "registration";
		}else {
			UserDTO bean = form.getDTO();
			if(form.getId()>0) {
				//bean.setUserRole("User");
				service.update(bean);
				model.addAttribute("success", "User Updated successfully");
			}else {
				//bean.setUserRole("User");
				service.Add(bean);
				model.addAttribute("success", "Registration successfully");
			}
			
			return "registration";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "registration";
		}
	}
	
	@GetMapping("/userList")
	public String list(@ModelAttribute("form")UserForm form, Model model){
	List<UserDTO> list = service.list();
	model.addAttribute("list", list);
	return "userlist";
		
	}
	
	@GetMapping("/userEdit")	
	public String update(@ModelAttribute("form")UserForm form, Model model, @RequestParam("id") long id ){
		UserDTO bean = service.findDeptById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "registration";
	}
	
	@GetMapping("/userDelete")	
	public String delete(@ModelAttribute("form")UserForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<UserDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "User Deleted successfully");
		return "userlist";
	}
	
	@PostMapping("/searchUser")	
	public String SearchByFirstName(@ModelAttribute("form")UserForm form, Model model ) throws Exception{
		UserDTO bean = form.getDTO();
		if (form.getOperation().equalsIgnoreCase("Reset")) {
			System.out.println("Required Operation: "+form.getOperation());
			return "redirect:/userList";
		}
		List<UserDTO> list = service.searchByFirstName(bean.getFirstName());
		model.addAttribute("list", list);
		return "userlist";
		
	}

}
