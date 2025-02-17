package com.evs.ctl;

import java.io.IOException;
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


import com.evs.dto.ElectionDTO;
import com.evs.exception.RecordNotFoundException;
import com.evs.form.ElectionFrom;
import com.evs.service.ElectionService;


@Controller
public class ElectionCtl {

	@Autowired
	public ElectionService service;

	@GetMapping("/election")
	public String election(@ModelAttribute("form")ElectionFrom form, Model model) {
	
		return "election";
	}

	@PostMapping("/addElection")
	public String Add(@Valid @ModelAttribute("form")ElectionFrom form,  BindingResult bindingResult, Model model) throws IOException {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "election";
		}else {
			ElectionDTO bean = form.getDTO();			
		
			if(form.getId()>0) {
				service.update(bean);
				model.addAttribute("success", "Election Updated successfully");
			}else {
							
			service.Add(bean);
			model.addAttribute("success", "Election Added successfully");
			}
			
			return "election";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "election";
		}
	}
	
	@GetMapping("/electionList")
	public String list(@ModelAttribute("form")ElectionFrom form, Model model){
	List<ElectionDTO> list = service.list();
	model.addAttribute("list", list);
	return "electionlist";		
	}
	
	
	@GetMapping("/electionEdit")	
	public String update(@ModelAttribute("form")ElectionFrom form, Model model, @RequestParam("id") long id ){
		ElectionDTO bean = service.findElectionById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "election";
	}
	
	@GetMapping("/electionDelete")	
	public String delete(@ModelAttribute("form")ElectionFrom form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);		
		List<ElectionDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Election Deleted successfully");
		return "electionlist";
	}


	
	
}
